package main

import "fmt"

func main()  {
	var data string
	data = "Oliver"
	fmt.Println(data)
	fmt.Println(&data)
	fmt.Printf("%o \n", &data);
	changeData(&data);
}

func changeData(z *string){
	*z = "Oliver Mensah"
	fmt.Println(*z)
	slice()
	mapping()
	ranging()
}

func slice(){
	m := make([]int , 0)
	m = append(m,9)
	m = append(m, 10)
	for _, val := range m{
		fmt.Println(val)
	}

}

func mapping(){
	m:= make(map[string]int)
	m["Oliver"] = 23
	m["Kwadwo"] = 34
	m["Nana Addo"] = 74
	fmt.Println("map", m)
	delete(m, "Oliver")
	fmt.Println("map", m)
	fmt.Println(m["Kwadwo"])
	n := map[int]string{
		1:"Oliver",
		2:"Naa",
	}
	fmt.Println("map", n)
}

func ranging(){
	n := []int{2,3,5}
	for i, v := range n {
		fmt.Println(i, v)
	}

	m := make(map[int]string)
	m[1]="Oliver"
	m[2]="Nana Addo"
	for i, v := range m {
		fmt.Println(i, v)
	}

	for i, v := range "go Oliver" {
		fmt.Println(i, string(v))
	}
}

