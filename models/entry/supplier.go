package entry

import (
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type Supplier struct {
	ID    int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:supplier_id;autoIncrement"`
	Name  string `json:"name" form:"name" binding:"required" gorm:"column:supplier_name"`
	Phone string `json:"phone" form:"phone" binding:"min=11" gorm:"column:supplier_phone"`
}

var _ models.Modeler = (*Supplier)(nil)

func (supplier Supplier) Get(page view.Page) (interface{}, error) {
	return models.FindAll(supplier, page.Limit, page.PageNum)
}

func (supplier Supplier) Delete() error {
	return models.Delete(&supplier)
}

func (supplier Supplier) Add() error {
	return models.Insert(&supplier)
}

func (supplier Supplier) Find(page view.Page) (interface{}, error) {
	return models.Find(supplier, page.Limit, page.PageNum)
}

func (supplier Supplier) Update() error {
	return models.Update(&supplier)
}

func (Supplier) GetModels() interface{} {
	return &[]Supplier{}
}

func (Supplier) TableName() string {
	return "db_supplier"
}
