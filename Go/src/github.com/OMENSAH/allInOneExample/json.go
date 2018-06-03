package main

import (
	"encoding/json"
	"fmt"
	"log"
	"os"
)

func main() {
	//placeholder for json data
	type Data struct {
		Name string `json:"site"`
		URI  string `json:"link"`
		Type string `json:"type"`
	}
	//load data
	file, err := os.Open("data/data.json")
	//print out the error if error occurred
	if err != nil {
		log.Fatal(err)
	}
	//Schedule the file to be closed
	defer file.Close()
	//read json data into struct
	var data []*Data
	err = json.NewDecoder(file).Decode(&data)
	fmt.Println(data)
}
