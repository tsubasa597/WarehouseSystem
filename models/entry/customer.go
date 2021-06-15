package entry

import (
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type Customer struct {
	ID    int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:customer_id"`
	Name  string `json:"name" form:"name" binding:"required" gorm:"column:customer_name"`
	Phone string `json:"phone" form:"phone" binding:"required,min=11" gorm:"column:customer_phone"`
}

var _ models.Modeler = (*Customer)(nil)

func (customer Customer) Get(page view.Page) (interface{}, error) {
	return models.FindAll(customer, page.Limit, page.PageNum)
}

func (customer Customer) Delete() error {
	return models.Delete(&customer)
}

func (customer Customer) Add() error {
	return models.Insert(&customer)
}

func (customer Customer) Find(page view.Page) (interface{}, error) {
	return models.Find(customer, page.Limit, page.PageNum)
}

func (customer Customer) Update() error {
	return models.Update(&customer)
}

func (Customer) GetModels() interface{} {
	return &[]Customer{}
}

func (customer Customer) TableName() string {
	return "db_customer"
}
