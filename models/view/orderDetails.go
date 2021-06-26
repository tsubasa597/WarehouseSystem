package view

type OrderDetails struct {
	OrderID   int    `json:"order_id" form:"order_id"`
	GoodsName string `json:"goods_name" form:"goods_name" binding:"required"`
	Num       int    `json:"num" form:"num" binding:"min=0"`
}
