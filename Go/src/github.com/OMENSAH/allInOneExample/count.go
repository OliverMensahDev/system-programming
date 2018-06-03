package main

import (
	"fmt"
	"io/ioutil"
	"strings"
)

func countWords(fileName string) int {
	//get file Content
	fileContent, err := ioutil.ReadFile(fileName)
	if err != nil {
		fmt.Println("There was an error reading the file")
	}
	//get content to string
	content := string(fileContent)
	return len(strings.Fields(content))
}

func writeTo(fileName string) {
	fmt.Println("Enter the words to be stored in the file")
	var data string
	fmt.Scan(&data)
	err := ioutil.WriteFile(fileName, []byte(data), 0644)
	if err != nil {
		fmt.Println("There was an error reading the file")
	}

}

func main() {
	data := "data/words.txt"
	writeTo(data)
	fmt.Printf("There are %d in the text \n", countWords(data))
}
