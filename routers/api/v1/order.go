package v1

import (
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	"github.com/gin-gonic/gin"
)

// GetOrder 按 type 获取订单数据
func GetOrder(ctx *gin.Context) {
	GetV1(entry.Order{}, ctx)
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
	order.Name = ctx.Query("name")
	FindV1(&order, ctx)
}
