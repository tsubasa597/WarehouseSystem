package routers

import (
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/middleware/auth"
	"github.com/tsubasa597/WarehouseSystem/models"
	"github.com/tsubasa597/WarehouseSystem/models/entry"
	"github.com/tsubasa597/WarehouseSystem/models/view"
	v1 "github.com/tsubasa597/WarehouseSystem/routers/api/v1"
	"github.com/tsubasa597/WarehouseSystem/routers/page"

	"github.com/gin-gonic/gin"
)

// InitRouter 初始化 Route
func InitRouter() *gin.Engine {
	OpenDB()

	r := gin.New()
	r.Use(gin.Logger())
	r.Use(gin.Recovery())

	auth.Init()
	jwt := auth.GetJwt()

	gin.SetMode(conf.RunMode)

	r.Delims("{{{", "}}}")
	r.StaticFS("/static", http.Dir("./static"))

	r.LoadHTMLGlob("templates/**/*")

	r.POST("/login", jwt.LoginHandler)
	r.GET("/login", func(c *gin.Context) {
		c.HTML(http.StatusOK, "login.tmpl", nil)
	})

	r.Use(jwt.MiddlewareFunc())
	PageRoute(r)

	apiv1 := r.Group("/api/v1")
	APIRoute(apiv1)
	return r
}

func APIRoute(group *gin.RouterGroup) {
	group.GET("/order", v1.GetOrder)
	group.POST("/order/add", v1.AddOrder)
	group.POST("/order/delete", v1.DeleteOrder)
	group.POST("/order/update", v1.EditOrder)
	group.GET("/order/find", v1.FindOrder)
	group.GET("/order/details", v1.GetOrderDetails)

	group.GET("/goods", v1.GetGoods)
	group.POST("/goods/add", v1.AddGoods)
	group.POST("/goods/delete", v1.DeleteGoods)
	group.POST("/goods/update", v1.EditGoods)
	group.GET("/goods/find", v1.FindGoods)

	group.GET("/customer", v1.GetCustomer)
	group.POST("/customer/add", v1.AddCustomer)
	group.POST("/customer/delete", v1.DeleteCustomer)
	group.POST("/customer/update", v1.EditCustomer)
	group.GET("/customer/find", v1.FindCustomer)

	group.GET("/supplier", v1.GetSupplier)
	group.POST("/supplier/add", v1.AddSupplier)
	group.POST("/supplier/delete", v1.DeleteSupplier)
	group.POST("/supplier/update", v1.EditSupplier)
	group.GET("/supplier/find", v1.FindSupplier)

	group.GET("/user", v1.GetUser)
	group.POST("/user/add", v1.AddUser)
	group.POST("/user/delete", v1.DeleteUser)
	group.POST("/user/update", v1.EditUser)
	group.GET("/user/find", v1.FindUser)
}

func PageRoute(route *gin.Engine) {
	route.GET("/index", page.Index)
	route.GET("/main/manager/user", page.User)
	route.GET("main/newUser", page.NewUser)
	route.GET("/main/newOrder", page.NewOrder)
	route.GET("/main/manager/order", page.Order)
	route.GET("/main/manager/goods", page.Goods)
	route.GET("/main/newGoods", page.NewGoods)
	route.GET("/main/manager/supplier", page.Supplier)
	route.GET("/main/newSupplier", page.NewSupplier)
	route.GET("/main/manager/customer", page.Customer)
	route.GET("/main/newCustomer", page.NewCustomer)
}

func OpenDB() {
	if models.OpenDB(true) == nil {
		if !models.HasTable(entry.Customer{}) {
			models.Migrate(entry.Customer{})
		}
		if !models.HasTable(entry.Goods{}) {
			models.Migrate(entry.Goods{})
		}
		if !models.HasTable(entry.User{}) {
			models.Migrate(entry.User{})
			entry.User{
				Name: "admin",
				Pwd:  "admin",
				Type: view.Admin,
			}.Add()
		}
		if !models.HasTable(entry.Order{}) {
			models.Migrate(entry.Order{})
		}
		if !models.HasTable(entry.Supplier{}) {
			models.Migrate(entry.Supplier{})
		}

		if !models.HasTable(entry.OrderDetails{}) {
			models.Migrate(entry.OrderDetails{})
		}

	}
}
