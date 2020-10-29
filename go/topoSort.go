package main

import (
	"fmt"
	"sort"
)

func main()  {
	for i, course := range topoSort(prereqs) {
		fmt.Printf("%d:\t%s\n", i + 1, course)
	}
}


var prereqs = map[string][]string {
	"algorithms": {"data structure"},
	"calculus": {"linear algebra"},
	"complilers" : {
		"data structures",
		"formal languages",
	},
}

func topoSort(m map[string][]string) []string {
	var order []string
	seen := make(map[string]bool)
	var visitAll func(items []string)

	visitAll = func(items []string) {
		for _, item := range items {
			if !seen[item] {
				seen[item] = true
				visitAll(m[item])
				order = append(order, item)
			}
		}
	}

	var keys []string
	for key := range m {
		keys = append(keys, key)
	}

	sort.Strings(keys)
	visitAll(keys)
	return order

}