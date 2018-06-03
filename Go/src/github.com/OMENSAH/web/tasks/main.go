package main

import (
	"log"
	"net/http"
)

func main() {
	PORT := "127.0.0.1:8080"
	http.HandleFunc("/", CompletedTaskFunc)
	http.HandleFunc("/task/123", GetTaskFunc)
	log.Fatal(http.ListenAndServe(PORT, nil))
}

//serving route
func CompletedTaskFunc(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte(r.URL.Path))
}

//parameterized routing
func GetTaskFunc(w http.ResponseWriter, r *http.Request) {
	if r.Method == "GET" {
		id := r.URL.Path[len("/task/"):]
		w.Write([]byte("Get task ID " + id))
	}
}
