package main

import "os"

func main()  {
	var rmdirs []func()

	for _, d := range tempDirs {
		dir := d
		_ = os.MkdirAll(dir, 0755)
		rmdirs = append(rmdirs, func() {
			_ =os.RemoveAll(dir)
		})
	}

	for _, rmdir := range rmdirs {
		rmdir()
	}
}

