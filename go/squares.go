package main

import "fmt"

func main()  {
	f := squares() // 初始化 var x ；返回匿名函数
	fmt.Println(f()) // 执行匿名函数
	fmt.Println(f()) // 执行匿名函数
}

func squares() func() int {
	var x int
	return func() int {
		x++
		return x * x
	}
}
