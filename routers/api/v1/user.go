package v1

import (
	"net/http"

	"github.com/tsubasa597/WarehouseSystem/middleware/auth"
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	"github.com/gin-gonic/gin"
)

func GetUser(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	if token["info"].(map[string]interface{})["type"].(float64) < 2 {
		ctx.JSON(http.StatusOK, gin.H{})
		return
	}
	GetV1(entry.User{}, ctx)
}

// AddOrder 添加订单
func AddUser(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	if token["info"].(map[string]interface{})["type"].(float64) < 2 {
		ctx.JSON(http.StatusOK, gin.H{})
		return
	}
	var user entry.User
	AddV1(&user, ctx)
}

// DeleteOrder 删除订单
func DeleteUser(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	if token["info"].(map[string]interface{})["type"].(float64) < 2 {
		ctx.JSON(http.StatusOK, gin.H{})
		return
	}
	var user entry.User
	DeleteV1(&user, ctx)
}

// EditOrder 修改订单
func EditUser(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	if token["info"].(map[string]interface{})["type"].(float64) < 2 {
		ctx.JSON(http.StatusOK, gin.H{})
		return
	}
	var user entry.User
	UpdateV1(&user, ctx)
}

func FindUser(ctx *gin.Context) {
	token, _ := auth.GetToken(ctx)
	if token["info"].(map[string]interface{})["type"].(float64) < 2 {
		ctx.JSON(http.StatusOK, gin.H{})
		return
	}
	var user entry.User
	user.Name = ctx.Query("name")
	FindV1(&user, ctx)
}
