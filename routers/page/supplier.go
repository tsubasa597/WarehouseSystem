package page

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func Supplier(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "supplier.tmpl", nil)
}

func NewSupplier(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "newSupplier.tmpl", nil)
}
