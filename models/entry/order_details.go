package entry

import (
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type OrderDetails struct {
	OroderID int `json:"order_id" gorm:"column:order_id"`
	GoodsID  int `json:"goods_id" binding:"required" gorm:"column:goods_id"`
	Num      int `json:"num" form:"num" binding:"min=0" gorm:"column:num"`
}

var _ models.Modeler = (*OrderDetails)(nil)

func (order OrderDetails) Get(page view.Page) (interface{}, error) {
	return nil, nil
}

func (order OrderDetails) Delete() error {
	return nil
}

func (order OrderDetails) Find(page view.Page) (interface{}, error) {
	return models.Find(order, page.Limit, page.PageNum)
}

func (order OrderDetails) Add() error {
	return models.Insert(order)
}

func (order OrderDetails) Update() error {
	return nil
}

func (OrderDetails) GetModels() interface{} {
	return &[]OrderDetails{}
}

func (OrderDetails) TableName() string {
	return "db_order_detalis"
}

func TransformOrderDetails(o *[]OrderDetails) (res []view.OrderDetails) {
	for _, v := range *(o) {
		goods, _ := models.GetOne(&Goods{ID: v.GoodsID})
		res = append(res, view.OrderDetails{
			OrderID:   v.OroderID,
			GoodsName: goods.(*Goods).Name,
			Num:       v.Num,
		})
	}
	return
}
