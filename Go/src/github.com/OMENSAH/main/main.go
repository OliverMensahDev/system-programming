package main

import (
	"fmt"

	"github.com/OMENSAH/packages/computerStruct"
	"github.com/OMENSAH/packages/languagelib"
)

func main() {
	var spec computerStruct.Spec
	spec.Maker = "apple"
	spec.Price = 50000
	fmt.Println("Spec: ", spec)
	fmt.Println()

	languagelib.Add("dr", "Dart")
	fmt.Println(languagelib.GetAll())
}
