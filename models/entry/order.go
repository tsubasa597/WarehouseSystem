package entry

import (
	"strconv"

	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type Order struct {
	ID         int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:id;autoIncrement"`
	Type       int    `json:"type" form:"type" binding:"required,min=1,max=3" gorm:"column:type"`
	Date       string `json:"date" form:"date" binding:"required" gorm:"column:date"`
	Price      int    `json:"price" form:"price" binding:"required,min=0" gorm:"column:price"`
	Done       int    `json:"done" form:"done" binding:"required" gorm:"column:done"`
	UserID     int    `json:"user_id" form:"user_id" binding:"required" gorm:"column:user_id"`
	CustomerID int    `json:"customer_id" form:"customer_id" binding:"required" gorm:"column:customer_id"`
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

func TransformOrder(o *[]Order) (res []view.Order) {
	for _, v := range *(o) {
		user, _ := models.GetOne(&User{ID: v.UserID})
		customer, _ := models.GetOne(&Customer{ID: v.CustomerID})
		res = append(res, view.Order{
			ID:           v.ID,
			Type:         v.Type,
			Date:         v.Date,
			Price:        v.Price,
			Done:         v.Done,
			UserName:     user.(*User).Name,
			CustomerName: customer.(*Customer).Name,
		})
	}
	return
}
