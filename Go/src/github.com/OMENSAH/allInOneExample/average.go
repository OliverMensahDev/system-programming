package main

import "fmt"

func main() {
	var age []int
	var numberOfStudents int
	var studentAge int
	var averageAge int
	fmt.Print("How many students do you want to compute their average age: ")
	fmt.Scanln(&numberOfStudents)
	for index := 0; index < numberOfStudents; index++ {
		fmt.Println("Enter age for student ", index)
		fmt.Scanln(&studentAge)
		averageAge += studentAge
		age = append(age, studentAge)
	}
	fmt.Println("The average age is ", averageAge/numberOfStudents)
	for _, val := range age {
		fmt.Println(val)
	}

}
