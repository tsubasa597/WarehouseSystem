package page

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func NewOrder(ctx *gin.Context) {
	type_ := ctx.Query("type")
	ctx.HTML(http.StatusOK, "newOrder.tmpl", gin.H{
		"type": type_,
	})
}

func Order(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "order.tmpl", gin.H{
		"url": "/api/v1/order/",
	})
}
