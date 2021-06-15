package v1

import (
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	"github.com/gin-gonic/gin"
)

func GetSupplier(ctx *gin.Context) {
	GetV1(entry.Supplier{}, ctx)
}

// AddOrder 添加订单
func AddSupplier(ctx *gin.Context) {
	var supplier entry.Supplier
	AddV1(&supplier, ctx)
}

// DeleteOrder 删除订单
func DeleteSupplier(ctx *gin.Context) {
	var supplier entry.Supplier
	DeleteV1(&supplier, ctx)
}

// EditOrder 修改订单
func EditSupplier(ctx *gin.Context) {
	var supplier entry.Supplier
	UpdateV1(&supplier, ctx)
}

func FindSupplier(ctx *gin.Context) {
	var supplier entry.Supplier
	supplier.Name = ctx.Query("name")
	FindV1(&supplier, ctx)
}
