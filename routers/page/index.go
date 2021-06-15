package page

import (
	"fmt"
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/middleware/auth"
	"github.com/tsubasa597/WarehouseSystem/models/view"

	"github.com/gin-gonic/gin"
)

func Index(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	fmt.Println(token["info"].(map[string]interface{})["type"].(float64))
	if int(token["info"].(map[string]interface{})["type"].(float64)) < 2 {
		ctx.HTML(http.StatusOK, "main.tmpl", gin.H{
			"menus": view.GetMenu(view.Manager),
		})
		return
	}
	ctx.HTML(http.StatusOK, "main.tmpl", gin.H{
		"menus": view.GetMenu(view.Admin),
	})
}
