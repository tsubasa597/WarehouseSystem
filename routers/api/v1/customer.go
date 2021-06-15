package v1

import (
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	"github.com/gin-gonic/gin"
)

func GetCustomer(ctx *gin.Context) {
	GetV1(entry.Customer{}, ctx)
}

// AddOrder 添加订单
func AddCustomer(ctx *gin.Context) {
	var customer entry.Customer
	AddV1(&customer, ctx)
}

// DeleteOrder 删除订单
func DeleteCustomer(ctx *gin.Context) {
	var customer entry.Customer
	DeleteV1(&customer, ctx)
}

// EditOrder 修改订单
func EditCustomer(ctx *gin.Context) {
	var customer entry.Customer
	UpdateV1(&customer, ctx)
}

func FindCustomer(ctx *gin.Context) {
	var customer entry.Customer
	customer.Name = ctx.Query("name")
	FindV1(&customer, ctx)
}
