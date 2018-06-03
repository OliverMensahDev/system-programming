package main

import (
	"fmt"

	"github.com/OMENSAH/package/computerStruct"
)

func main() {
	var spec computerStruct.Spec

	spec.Maker = "apple"
	spec.Price = 50000
	fmt.Println("Spec: ", spec)
}
