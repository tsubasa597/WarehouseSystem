package entry

import (
	"strconv"

	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type Order struct {
	ID    int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:order_id;autoIncrement"`
	Name  string `json:"name" form:"name" binding:"required" gorm:"column:goods_name"`
	Num   int    `json:"num" form:"num" binding:"min=0" gorm:"column:goods_num"`
	Date  string `json:"date" form:"date" binding:"required" gorm:"column:order_date"`
	Type  int    `json:"type" form:"type" binding:"required,min=1,max=3" gorm:"column:order_type"`
	User  string `json:"user" form:"user" gorm:"column:order_user"`
	Price int    `json:"price" form:"price" binding:"required,min=0" gorm:"column:order_price"`
	Done  int    `json:"done" form:"done"  binding:"required" gorm:"column:order_done"`
}

var _ models.Modeler = (*Order)(nil)

func (order Order) Get(page view.Page) (interface{}, error) {
	if page.OrderType < "0" {
		return models.FindAll(order, page.Limit, page.PageNum)
	}

	i, _ := strconv.Atoi(page.OrderType)
	order.Type = i
	return models.Find(order, page.Limit, page.PageNum)
}

func (order Order) Delete() error {
	return models.Delete(&order)
}

func (order Order) Find(page view.Page) (interface{}, error) {
	return models.Find(order, page.Limit, page.PageNum)
}

func (order Order) Add() error {
	return models.Insert(&order)
}

func (order Order) Update() error {
	return models.Update(&order)
}

func (Order) GetModels() interface{} {
	return &[]Order{}
}

func (Order) TableName() string {
	return "db_orders"
}
