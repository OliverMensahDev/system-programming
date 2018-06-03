package main

import "fmt"

type Employee struct {
	name     string
	salary   int
	currency string
	age      int
}

/*
display name
*/

func (e Employee) displaySalary() {
	fmt.Printf("Salary of %s is %s%d \n", e.name, e.currency, e.salary)
}

func displaySalary(e Employee) {
	fmt.Printf("Salary of %s is %s%d \n", e.name, e.currency, e.salary)
}

type Rectangle struct {
	length int
	width  int
}
type Circle struct {
	radius float64
}

func (r Rectangle) Area() int {
	return r.length * r.width
}

func perimeter(r *Rectangle) {
	fmt.Println("Perimeter is ", 2*(r.length+r.width))
}
func (r *Rectangle) changeLength( int leng){
	*r.length = leng
}

func main() {
	emp1 := Employee{
		name:     "Oliver Mensah",
		salary:   5000,
		currency: "$",
		age:      23,
	}
	rect := Rectangle{
		length: 5,
		width:  4,
	}
	fmt.Println(rect.Area())
	rect.changeLength(6)
	fmt.Println(rect.Area())
	ptrR := &rect
	perimeter(ptrR)
	emp1.displaySalary()
	displaySalary(emp1)
}
