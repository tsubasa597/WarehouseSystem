package entry

import (
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type Goods struct {
	ID         int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:goods_id;autoIncrement"`
	Name       string `json:"name" form:"name" binding:"required" gorm:"column:goods_name"`
	Num        int    `json:"num" form:"num" binding:"required,min=0" gorm:"column:goods_num"`
	Price      int    `json:"price" form:"price" binding:"required,min=0" gorm:"column:goods_price"`
	SupplierID int    `json:"supplier" form:"supplier" gorm:"column:goods_supplier"`
}

var _ models.Modeler = (*Goods)(nil)

func (goods Goods) Get(page view.Page) (interface{}, error) {
	return models.FindAll(goods, page.Limit, page.PageNum)
}

func (goods Goods) Delete() error {
	return models.Delete(&goods)
}

func (goods Goods) Add() error {
	return models.Insert(&goods)
}

func (goods Goods) Find(page view.Page) (interface{}, error) {
	return models.Find(goods, page.Limit, page.PageNum)
}

func (goods Goods) Update() error {
	return models.Update(&goods)
}

func (Goods) GetModels() interface{} {
	return &[]Goods{}
}

func (goods Goods) TableName() string {
	return "db_goods"
}
