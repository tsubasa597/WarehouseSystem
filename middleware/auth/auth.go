package auth

import (
	"time"

	"github.com/tsubasa597/WarehouseSystem/conf"
	"github.com/tsubasa597/WarehouseSystem/models/entry"

	jwt "github.com/appleboy/gin-jwt/v2"
	"github.com/gin-gonic/gin"
)

var middleware *jwt.GinJWTMiddleware

func Init() {
	middleware, _ = jwt.New(&jwt.GinJWTMiddleware{
		Realm:       "Jwt",
		Key:         []byte(conf.JwtSecret),
		Timeout:     time.Hour,
		MaxRefresh:  time.Hour,
		IdentityKey: "info",
		PayloadFunc: func(data interface{}) jwt.MapClaims {
			if v, ok := data.(*entry.Login); ok {
				return jwt.MapClaims{
					"info": v,
				}
			}
			return jwt.MapClaims{}
		},
		IdentityHandler: func(c *gin.Context) interface{} {
			claims := jwt.ExtractClaims(c)
			return claims["info"]
		},
		Authenticator: func(ctx *gin.Context) (interface{}, error) {
			var info entry.Login
			if err := ctx.ShouldBind(&info); err != nil {
				return "", jwt.ErrMissingLoginValues
			}

			if err := info.GetOne(); err == nil {
				return &info, nil
			}
			return nil, jwt.ErrFailedAuthentication
		},
		Authorizator: func(data interface{}, c *gin.Context) bool {
			if v, ok := data.(map[string]interface{}); ok && v["type"].(float64) > 0 {
				return true
			}
			return false
		},
		Unauthorized: func(c *gin.Context, i int, s string) {
			c.JSON(i, gin.H{
				"code":    i,
				"messgae": s,
			})
		},
		TokenLookup:   "cookie:token",
		TokenHeadName: "Jwt",
		TimeFunc:      time.Now,
		SendCookie:    true,
		CookieName:    "token",
	})
}

func GetJwt() *jwt.GinJWTMiddleware {
	return middleware
}

func GetToken(ctx *gin.Context) (jwt.MapClaims, error) {
	return middleware.GetClaimsFromJWT(ctx)
}
