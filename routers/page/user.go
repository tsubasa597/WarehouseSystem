package page

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func User(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "user.tmpl", nil)
}

func NewUser(ctx *gin.Context) {
	ctx.HTML(http.StatusOK, "newUser.tmpl", nil)
}
