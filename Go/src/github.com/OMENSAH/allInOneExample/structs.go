package main

import "fmt"

type User struct {
	email    string
	password string
	name     string
}

type Admin struct {
	admin User
	level string
}

func (u Admin) sendEmail() {
	fmt.Printf("Hello %s, please use this link to change your email(%s) \n", u.admin.name, u.admin.email)
}

func (admin *Admin) changeAdminName(name string) {
	admin.admin.name = name
}

func main() {
	ad := Admin{
		admin: User{
			name:     "Oliver Mensah",
			email:    "olivermensah96@gmail.com",
			password: "08admin",
		},
		level: "super",
	}
	ad.changeAdminName("Barbara Osei")
	ad.sendEmail()
}
