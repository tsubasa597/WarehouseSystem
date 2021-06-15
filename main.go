package main

import (
	"fmt"
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/routers"
)

func main() {
	router := routers.InitRouter()
	s := &http.Server{
		Addr:           fmt.Sprintf(":%d", conf.HTTPPort),
		Handler:        router,
		ReadTimeout:    conf.ReadTimeout,
		WriteTimeout:   conf.WriteTimeout,
		MaxHeaderBytes: 1 << 20,
	}

	s.ListenAndServe()
}
