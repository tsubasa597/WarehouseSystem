package v1

import (
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	"github.com/gin-gonic/gin"
)

func GetGoods(ctx *gin.Context) {
	GetV1(entry.Goods{}, ctx)
}

// AddOrder 添加订单
func AddGoods(ctx *gin.Context) {
	var goods entry.Goods
	AddV1(&goods, ctx)
}

// DeleteOrder 删除订单
func DeleteGoods(ctx *gin.Context) {
	var goods entry.Goods
	DeleteV1(&goods, ctx)
}

// EditOrder 修改订单
func EditGoods(ctx *gin.Context) {
	var goods entry.Goods
	UpdateV1(&goods, ctx)
}

func FindGoods(ctx *gin.Context) {
	var goods entry.Goods
	goods.Name = ctx.Query("name")
	FindV1(&goods, ctx)
}
