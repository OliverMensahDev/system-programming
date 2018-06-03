package main

import "fmt"

func main() {
	fmt.Printf("%d - %b  - %o  - %x  - %X \n", 42, 42, 42, 42, 42)
	fmt.Println("DEC \t BIN \t OCT \t hex \t HEX")
  for  i := 0; i <=200 ; i++{
		fmt.Printf("%d  \t %b  \t  %o \t %x \t %X \n", i , i, i, i , i)
	}
}
