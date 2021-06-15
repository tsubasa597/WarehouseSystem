package page

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func Goods(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "goods.tmpl", nil)
}

func NewGoods(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "newGoods.tmpl", nil)
}
