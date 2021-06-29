package entry

import (
	"crypto/md5"
	"encoding/hex"
	"fmt"

	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/view"
)

type User struct {
	ID    int    `json:"id" form:"id" binding:"min=0" gorm:"primaryKey;column:id;autoIncrement"`
	Age   int    `json:"age" form:"age" binding:"required,min=0" gorm:"column:age"`
	Sex   int    `json:"sex" form:"sex" binding:"required" gorm:"column:sex"`
	Phone string `json:"phone" form:"phone" binding:"min=11" gorm:"column:phone"`
	Type  int    `json:"type" form:"type" binding:"required,min=0,max=2" gorm:"column:type"`
	Name  string `json:"name" form:"name" binding:"required" gorm:"column:name"`
	Pwd   string `json:"-" form:"pwd" gorm:"column:pwd"`
}

var _ models.Modeler = (*User)(nil)

func (user User) Get(page view.Page) (interface{}, error) {
	return models.FindAll(user, page.Limit, page.PageNum)
}

func (user User) Delete() error {
	return models.Delete(&user)
}

func (user User) Add() error {
	if user.Pwd == "" {
		return fmt.Errorf("错误")
	}
	md5Ctx := md5.New()
	md5Ctx.Write([]byte(user.Pwd))
	cipherStr := md5Ctx.Sum(nil)
	user.Pwd = hex.EncodeToString(cipherStr)

	return models.Insert(&user)
}

func (user User) Find(page view.Page) (interface{}, error) {
	return models.Find(user, page.Limit, page.PageNum)
}

func (user User) Update() error {
	return models.Update(&user)
}

func (User) GetModels() interface{} {
	return &[]User{}
}

func (User) TableName() string {
	return "db_users"
}

type Login struct {
	Name string `json:"name" form:"name" binding:"required" gorm:"column:user_name"`
	Pwd  string `json:"-" form:"pwd" binding:"required" gorm:"column:user_pwd"`
	Type int    `json:"type" form:"type" gorm:"column:user_type"`
}

func (login *Login) GetOne() error {
	if login.Pwd == "" {
		return fmt.Errorf("错误")
	}

	md5Ctx := md5.New()
	md5Ctx.Write([]byte(login.Pwd))
	cipherStr := md5Ctx.Sum(nil)
	login.Pwd = hex.EncodeToString(cipherStr)

	if v, err := models.GetOne(login); err == nil {
		login.Type = v.(*Login).Type
		return nil
	} else {
		return err
	}
}

func (Login) TableName() string {
	return "db_users"
}

func (Login) GetModels() interface{} {
	return &Login{}
}
