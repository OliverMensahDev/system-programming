package main

import (
	"fmt"
)

/*
//1
type VowelsFinder interface {
	FindVowels() []rune
}

type myString string

func (ms myString) FindVowels() []rune {
	var vowels []rune
	for _, rune := range ms {
		if rune == 'a' || rune == 'e' || rune == 'i' || rune == 'o' || rune == 'u' {
			vowels = append(vowels, rune)
		}
	}
	return vowels
}

func main() {
	ms := myString("Oliver Mensah")
	var v VowelsFinder
	v = ms
	fmt.Printf("Vowels are %c \n", v.FindVowels())
}


//2

type SalaryCalculator interface {
	CalCulateSalary() int
}

type Permanent struct {
	empId    int
	basicPay int
	pf       int
}
type Contract struct {
	empId    int
	basicPay int
}

func (p Permanent) CalCulateSalary() int {
	return p.basicPay + p.pf
}

func (c Contract) CalCulateSalary() int {
	return c.basicPay
}

func totalExpenses(s []SalaryCalculator) {
	expense := 0
	for _, v := range s {
		expense = expense + v.CalCulateSalary()
	}
	fmt.Printf("Total Expense Per Month  $%d\n", expense)
}

func main() {
	pemp1 := Permanent{1, 5000, 20}
	pemp2 := Permanent{2, 6000, 30}
	cemp1 := Contract{3, 5000}
	employees := []SalaryCalculator{pemp1, pemp2, cemp1}
	totalExpenses(employees)
}
*/

//3

type Describer interface {
	Describe()
	Change(a int)
}

type Person struct {
	name string
	age  int
}

func (p Person) Describe() {
	fmt.Printf("I am %s aged %d years\n", p.name, p.age)
}

func (p *Person) Change(a int) {
	p.age = a
}

func main() {
	var d1 Describer
	p := Person{"Oliver", 34}
	d1 = p
	d1.Describe()

	// var d2 Describer
	// d2 = &p
	// d2.Change(36)
	// d2.Describe()
}
