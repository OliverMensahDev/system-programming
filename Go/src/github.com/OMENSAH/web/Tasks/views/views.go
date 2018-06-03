package views

import (
	"html/template"
	"io/ioutil"
	"log"
	"net/http"
	"os"
	"strings"
)

//declare all views template
var homeTemplate *template.Template
var loginTemplate *template.Template
var singupTemplate *template.Template

/**
 * PopulateTemplates
 *  this is use to parse all  the templates pressent in the templates folder
 */
func PopulateTemplates() {
	var allFiles []string
	templateDir := "./templates/"
	files, err := ioutil.ReadDir(templateDir)
	if err != nil {
		log.Println(err)
		os.Exit(1)
	}
	for _, file := range files {
		filename := file.Name()
		if strings.HasSuffix(filename, "html") {
			allFiles = append(allFiles, templateDir+filename)
		}
	}
	templates, err := template.ParseFiles(allFiles...)
	if err != nil {
		log.Print(err)
		os.Exit(1)
	}
	//load all views
	homeTemplate = templates.Lookup("home.html")
	loginTemplate = templates.Lookup("login.html")
	singupTemplate = templates.Lookup("signup.html")
}

/*
 *HomePage
 *Creates the homepage
 */
func HomePage(w http.ResponseWriter, r *http.Request) {
	if r.Method == "GET" {
		context := HomeStruct{
			"HomePage",
		}
		homeTemplate.Execute(w, context)
	}
}
