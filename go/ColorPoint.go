package main
//
//import (
//	"fmt"
//	"image/color"
//)
//
//type ColoredPoint struct {
//	*Point
//	Color color.RGBA
//}
//
//func main()  {
//	p := ColoredPoint{&Point{1, 2}, red}
//	q := ColoredPoint{&Point{2, 3}, blue}
//
//	fmt.Println(p.Distance(*q.Point))
//
//	q.Point = p.Point
//	p.ScaleBy(2)
//
//	fmt.Println(*p.Point, *q.Point)
//}