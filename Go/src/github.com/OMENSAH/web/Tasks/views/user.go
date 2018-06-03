package views

import (
	"log"
	"net/http"

	"github.com/OMENSAH/web/Tasks/db"
	"github.com/gorilla/sessions"
)

//Store the cookie store which is used to store session data in the cookie
var Store = sessions.NewCookieStore([]byte("secret-password"))
var session *sessions.Session

//IsLoggedIn  will check if user  has an active session and return true
func IsLoggedIn(r *http.Request) bool {
	session, err := Store.Get(r, "session")
	if err == nil && (session.Values["loggedin"] == "true") {
		return true
	}
	return false
}

//GetCurrentUserName returns the username of the logged in usr
func GetCurrentUserName(r *http.Request) string {
	session, err := Store.Get(r, "session")
	if err == nil {
		return session.Values["username"].(string)
	}
	return ""
}

//middleware for handling active sessions
func RequiresLogin(handler func(w http.ResponseWriter, r *http.Request)) func(w http.ResponseWriter, r *http.Request) {
	return func(w http.ResponseWriter, r *http.Request) {
		if !IsLoggedIn(r) {
			http.Redirect(w, r, "/login/", 302)
		}
		handler(w, r)
	}
}

func LogoutFunc(w http.ResponseWriter, r *http.Request) {
	session, err := Store.Get(r, "session")
	if err == nil {
		if session.Values["loggedin"] != "false" {
			session.Values["loggedin"] = "false"
			session.Save(r, w)
		}
	}
	http.Redirect(w, r, "/login/", 302)
}

func LoginFunc(w http.ResponseWriter, r *http.Request) {
	session, err := Store.Get(r, "session")
	if err != nil {
		log.Println(err)
		loginTemplate.Execute(w, nil)
		return
	}
	switch r.Method {
	case "GET":
		loginTemplate.Execute(w, nil)
	case "POST":
		log.Println("Inside Post")
		r.ParseForm()
		username := r.Form.Get("username")
		password := r.Form.Get("password")
		if (username != "" && password != "") && db.ValidUser(username) {
			session.Values["loggedin"] = "true"
			session.Values["username"] = username
			session.Save(r, w)
			log.Println("user ", username, " is authenticated")
			http.Redirect(w, r, "/", 302)
			return
		}
		log.Println("Invalid User " + username)
		loginTemplate.Execute(w, nil)
	default:
		http.Redirect(w, r, "/login/", http.StatusUnauthorized)
	}
}
func SignupFunc(w http.ResponseWriter, r *http.Request) {
	switch r.Method {
	case "GET":
		if !IsLoggedIn(r) {
			singupTemplate.Execute(w, nil)
		}
	case "POST":
		log.Println("Inside Signup Post")
		r.ParseForm()
		email := r.Form.Get("email")
		username := r.Form.Get("username")
		password := r.Form.Get("password")
		if (username != "" && email != "" && password != "") && !db.ValidUser(username) {
			err := db.CreateUser(username, password, email)
			if err != nil {
				http.Error(w, "Unable to Signup as User", http.StatusInternalServerError)
			} else {
				http.Redirect(w, r, "/signup/", 302)
			}
		}
		log.Println("Invalid User " + username)
		singupTemplate.Execute(w, nil)
	default:
		http.Redirect(w, r, "/signup/", http.StatusUnauthorized)
	}
}
