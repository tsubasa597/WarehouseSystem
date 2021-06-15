package v1

import (
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/models/entry"
	"github.com/tsubasa597/WarehouseSystem/msg"

	"github.com/gin-gonic/gin"
)

func Login(ctx *gin.Context) {
	var info entry.Login
	if err := ctx.ShouldBind(&info); err == nil {
		if err := info.GetOne(); err == nil {
			ctx.JSON(http.StatusOK, msg.GetMsg(msg.SUCCESS))
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}
