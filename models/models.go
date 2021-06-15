package models

import (
	"fmt"
	"log"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/models/view"

	"gorm.io/driver/mysql"
	"gorm.io/driver/sqlite"
	"gorm.io/gorm"
)

var db *gorm.DB

type Modeler interface {
	Get(view.Page) (interface{}, error)
	Delete() error
	Add() error
	Update() error
	Find(view.Page) (interface{}, error)
	tabler
}

type tabler interface {
	TableName() string
	GetModels() interface{}
}

func Migrate(model Modeler) {
	db.AutoMigrate(model)
}

func HasTable(model Modeler) bool {
	return db.Migrator().HasTable(model)
}

func OpenDB(debug bool) error {
	var (
		err                          error
		dbName, user, password, host string
	)

	sec, err := conf.Cfg.GetSection("database")
	if err != nil {
		log.Fatal(2, "Fail to get section 'database': %v", err)
	}

	dbName = sec.Key("NAME").String()
	user = sec.Key("USER").String()
	password = sec.Key("PASSWORD").String()
	host = sec.Key("HOST").String()

	if conf.DATABASETYPE == "mysql" {
		dsn := fmt.Sprintf("%s:%s@tcp(%s)/%s?charset=utf8mb4&parseTime=True&loc=Local", user, password, host, dbName)
		db, err = gorm.Open(mysql.Open(dsn), &gorm.Config{})
		if err != nil {
			return err
		}
	} else {
		db, err = gorm.Open(sqlite.Open("homework.db"), &gorm.Config{})
		if err != nil {
			return err
		}
	}

	if conf.RunMode == "debug" {
		db = db.Debug()
	}

	return nil
}

func FindAll(model Modeler, pageSize, pageNum int) (res interface{}, err error) {
	res = model.GetModels()
	db.Scopes(paginate(pageSize, pageNum), tableName(model)).Find(res)
	err = db.Error
	return
}

func Find(model Modeler, pageSize, pageNum int) (res interface{}, err error) {
	res = model.GetModels()
	db.Scopes(paginate(pageSize, pageNum), tableName(model)).Where(model).Find(res)
	err = db.Error
	return
}

func GetOne(model tabler) (res interface{}, err error) {
	res = model.GetModels()
	if db.Scopes(tableName(model)).Where(model).Find(res).RowsAffected == 0 {
		return nil, fmt.Errorf("不存在")
	}
	return res, db.Error
}

func Insert(model Modeler) error {
	return db.Scopes(tableName(model)).Create(model).Error
}

func Delete(model Modeler) error {
	if db.Scopes(tableName(model)).Where(model).Find(model).RowsAffected == 0 {
		return fmt.Errorf("不存在")
	}
	return db.Scopes(tableName(model)).Delete(model).Error
}

func Update(model Modeler) error {
	if db.Scopes(tableName(model)).Updates(model).RowsAffected == 0 {
		return fmt.Errorf("不存在")
	}
	return db.Error
}

func paginate(pageSize, pageNum int) func(db *gorm.DB) *gorm.DB {
	return func(db *gorm.DB) *gorm.DB {
		offset := (pageNum - 1) * pageSize
		return db.Offset(offset).Limit(pageSize)
	}
}

func tableName(table tabler) func(db *gorm.DB) *gorm.DB {
	return func(db *gorm.DB) *gorm.DB {
		return db.Table(table.TableName())
	}
}
