package v1

import (
	"fmt"
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
	"github.com/tsubasa597/WarehouseSystem/msg"

	"github.com/gin-gonic/gin"
)

func DeleteV1(model models.Modeler, ctx *gin.Context) {
	if err := ctx.ShouldBind(model); err == nil {
		if err := model.Delete(); err == nil {
			ctx.JSON(http.StatusOK, msg.GetMsg(msg.SUCCESS))
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}

func AddV1(model models.Modeler, ctx *gin.Context) {
	if err := ctx.ShouldBind(model); err == nil {
		if err := model.Add(); err == nil {
			ctx.JSON(http.StatusOK, msg.GetMsg(msg.SUCCESS))
			return
		}
	} else {
		fmt.Println(err)
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}

func UpdateV1(model models.Modeler, ctx *gin.Context) {
	if err := ctx.ShouldBind(model); err == nil {
		if err := model.Update(); err == nil {
			ctx.JSON(http.StatusOK, msg.GetMsg(msg.SUCCESS))
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}

func GetV1(model models.Modeler, ctx *gin.Context) {
	var page view.Page
	page.PageNum = 1
	page.Limit = conf.PageSize
	if err := ctx.ShouldBind(&page); err == nil && page.PageNum >= 0 {
		if models, err := model.Get(page); err == nil {
			resp := msg.GetMsg(msg.SUCCESS)
			resp.Data = models

			ctx.JSON(http.StatusOK, resp)
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}

func FindV1(model models.Modeler, ctx *gin.Context) {
	var page view.Page
	page.PageNum = 1
	page.Limit = conf.PageSize
	if err := ctx.ShouldBind(&page); err == nil && page.PageNum >= 0 {
		if models, err := model.Find(page); err == nil {
			resp := msg.GetMsg(msg.SUCCESS)
			resp.Data = models

			ctx.JSON(http.StatusOK, resp)
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}
