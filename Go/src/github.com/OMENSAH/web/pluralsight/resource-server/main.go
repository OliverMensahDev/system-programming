// package main
//
// import (
// 	"net/http"
// )
//
// func main() {
// 	http.HandleFunc("/", func(w http.ResponseWriter, req *http.Request) {
// 		w.Write([]byte("Hellow World"))
// 	})
// 	http.ListenAndServe(":8000", nil)
// }

// package main
//
// import (
// 	"io/ioutil"
// 	"net/http"
// )
//
// type MyHandler struct {
// 	http.Handler
// }
//
// func (this *MyHandler) ServeHTTP(w http.ResponseWriter, req *http.Request) {
// 	path := "public/" + req.URL.Path
// 	data, err := ioutil.ReadFile(string(path))
// 	if err == nil {
// 		w.Write(data)
// 	} else {
// 		w.WriteHeader(404)
// 		w.Write([]byte("404 - " + http.StatusText(404)))
// 	}
// }
//
// func main() {
// 	http.Handle("/", new(MyHandler))
// 	http.ListenAndServe(":8000", nil)
// }

// package main
//
// import (
// 	"io/ioutil"
// 	"net/http"
// 	"strings"
// )
//
// type MyHandler struct {
// 	http.Handler
// }
//
// func (this *MyHandler) ServeHTTP(w http.ResponseWriter, req *http.Request) {
// 	path := "public/" + req.URL.Path
// 	data, err := ioutil.ReadFile(string(path))
// 	if err == nil {
// 		var contentType string
// 		if strings.HasSuffix(path, ".css") {
// 			contentType = "text/css"
// 		} else if strings.HasSuffix(path, ".html") {
// 			contentType = "text/html"
// 		} else if strings.HasSuffix(path, ".js") {
// 			contentType = "text/javascript"
// 		} else if strings.HasSuffix(path, ".png") {
// 			contentType = "image/png"
// 		} else if strings.HasSuffix(path, ".mp4") {
// 			contentType = "video/mp4"
// 		} else {
// 			contentType = "text/plain"
// 		}
// 		w.Header().Add("Content-Type", contentType)
// 		w.Write(data)
// 	} else {
// 		w.WriteHeader(404)
// 		w.Write([]byte("404 - " + http.StatusText(404)))
// 	}
// }
//
// func main() {
// 	http.Handle("/", new(MyHandler))
// 	http.ListenAndServe(":8000", nil)
// }

// package main
//
// import (
// 	"bufio"
// 	"net/http"
// 	"os"
// 	"strings"
// )
//
// type MyHandler struct {
// 	http.Handler
// }
//
// func (this *MyHandler) ServeHTTP(w http.ResponseWriter, req *http.Request) {
// 	path := "public/" + req.URL.Path
// 	data, err := os.Open(path)
// 	if err == nil {
// 		bufferedReader := bufio.NewReader(data)
// 		var contentType string
// 		if strings.HasSuffix(path, ".css") {
// 			contentType = "text/css"
// 		} else if strings.HasSuffix(path, ".html") {
// 			contentType = "text/html"
// 		} else if strings.HasSuffix(path, ".js") {
// 			contentType = "text/javascript"
// 		} else if strings.HasSuffix(path, ".png") {
// 			contentType = "image/png"
// 		} else if strings.HasSuffix(path, ".mp4") {
// 			contentType = "video/mp4"
// 		} else {
// 			contentType = "text/plain"
// 		}
// 		w.Header().Add("Content-Type", contentType)
// 		bufferedReader.WriteTo(w)
// 	} else {
// 		w.WriteHeader(404)
// 		w.Write([]byte("404 - " + http.StatusText(404)))
// 	}
// }
//
// func main() {
// 	http.Handle("/", new(MyHandler))
// 	http.ListenAndServe(":8000", nil)
// }

package main

import (
	"net/http"
)

func main() {
	http.ListenAndServe(":8000", http.FileServer(http.Dir("public")))
}
