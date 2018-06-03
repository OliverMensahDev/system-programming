package main

import (
	"html/template"
	"net/http"

	"github.com/OMENSAH/web/pluralsight/templating/textTemplate"
)

type Context struct {
	Title   string
	Message string
	Fruit   [3]string
}

func main() {
	//text
	html := textTemplate.TextTemplate()
	http.HandleFunc("/", func(w http.ResponseWriter, req *http.Request) {
		w.Header().Add("Content-Type", "text/html")
		tmpl := template.New("template")
		tmpl.New("test").Parse(html[0])
		tmpl.New("header").Parse(html[1])
		tmpl.New("footer").Parse(html[2])
		context := Context{
			"Text Template",
			"the message is here",
			[3]string{"Apple", "Mango", "Pear"},
		}
		tmpl.Lookup("test").Execute(w, context)
	})
	http.ListenAndServe(":8000", nil)
}
