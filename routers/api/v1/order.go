package v1

import (
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/models/entry"
	"github.com/tsubasa597/WarehouseSystem/models/view"
	"github.com/tsubasa597/WarehouseSystem/msg"

	"github.com/gin-gonic/gin"
)

// GetOrder 按 type 获取订单数据
func GetOrder(ctx *gin.Context) {
	var (
		page  view.Page
		order entry.Order
	)
	page.PageNum = 1
	page.Limit = conf.PageSize
	if err := ctx.ShouldBind(&page); err == nil && page.PageNum >= 0 {
		if models, err := order.Get(page); err == nil {
			resp := msg.GetMsg(msg.SUCCESS)
			resp.Data = entry.TransformOrder(models.(*[]entry.Order))

			ctx.JSON(http.StatusOK, resp)
			return
		}
	}
	ctx.JSON(http.StatusOK, msg.GetMsg(msg.ERROR))
}

// AddOrder 添加订单
func AddOrder(ctx *gin.Context) {
	var order entry.Order
	AddV1(&order, ctx)
}

// DeleteOrder 删除订单
func DeleteOrder(ctx *gin.Context) {
	var order entry.Order
	DeleteV1(&order, ctx)
}

// EditOrder 修改订单
func EditOrder(ctx *gin.Context) {
	var order entry.Order
	UpdateV1(&order, ctx)
}

func FindOrder(ctx *gin.Context) {
	var order entry.Order
	FindV1(&order, ctx)
}
