package main

import "fmt"

type User struct {
	name  string
	email string
}

func (u User) notify() {
	fmt.Printf("Hello %s, please use this link to change your email(%s) \n", u.name, u.email)
}

func (u *User) changeEmail(email string) {
	u.email = email
}

func (u *User) changeName(name string) {
	u.name = name
}

func main() {
	me := User{
		name:  "Oliver Mensah",
		email: "Olivermensah96@gmail.com",
	}
	me.notify()
	me.changeEmail("mensaholiver08@gmail.com")
	me.changeName("Kwadwo")
	me.notify()
}
