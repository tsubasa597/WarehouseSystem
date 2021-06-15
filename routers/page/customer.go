package page

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func Customer(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "customer.tmpl", nil)
}

func NewCustomer(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "newCustomer.tmpl", nil)
}
