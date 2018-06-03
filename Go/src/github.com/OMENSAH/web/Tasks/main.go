package main

/**
 * Entry point of the application
 */
import (
	"flag"
	"log"
	"net/http"
	"strings"

	"github.com/OMENSAH/web/Tasks/config"
	"github.com/OMENSAH/web/Tasks/views"
)

func main() {
	values, err := config.ReadConfig("config.json")
	var port *string

	if err != nil {
		port = flag.String("port", "", "IP address")
		flag.Parse()
		//User is expected to give :8080 like input, if they give 8080
		//we'll append the required ':'
		if !strings.HasPrefix(*port, ":") {
			*port = ":" + *port
			log.Println("port is " + *port)
		}
		values.ServerPort = *port
	}
	views.PopulateTemplates()
	http.HandleFunc("/", views.RequiresLogin(views.HomePage))
	http.Handle("/static/", http.FileServer(http.Dir("public")))
	http.HandleFunc("/login/", views.LoginFunc)
	http.HandleFunc("/signup/", views.SignupFunc)
	log.Println("running server on ", values.ServerPort)
	log.Fatal(http.ListenAndServe(values.ServerPort, nil))
}
