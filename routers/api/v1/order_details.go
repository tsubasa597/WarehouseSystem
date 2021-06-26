package v1

import (
	"net/http"

	"github.com/gin-gonic/gin"
	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/models/entry"
	"github.com/tsubasa597/WarehouseSystem/models/view"
	"github.com/tsubasa597/WarehouseSystem/msg"
)

func GetOrderDetails(ctx *gin.Context) {
	var orderId int
	var page view.Page
	page.PageNum = 1
	page.Limit = conf.PageSize
	orderDetails := entry.OrderDetails{
		OroderID: orderId,
	}
	if err := ctx.ShouldBind(&page); err == nil {
		if models, err := orderDetails.Find(page); err == nil {
			resp := msg.GetMsg(msg.SUCCESS)
			resp.Data = entry.TransformOrderDetails(models.(*[]entry.OrderDetails))

			ctx.JSON(http.StatusOK, resp)
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}
