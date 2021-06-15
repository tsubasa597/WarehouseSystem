package msg

import (
	"sync"
)

const (
	// SUCCESS 成功
	SUCCESS = iota
	// ERROR 错误
	ERROR
	// INVALIDPARAMS 缺少参数
	INVALIDPARAMS
	// ERRORAUTHTOKEN Token 生成失败
	ERRORAUTHTOKEN
	// ERRORAUTH Token 错误
	ERRORAUTH
)

type Resp struct {
	Code int         `json:"code"`
	Msg  string      `json:"msg"`
	Data interface{} `json:"data"`
}

type Data struct {
	Lists interface{} `json:"lists"`
	Total int         `json:"total"`
}

var (
	pool = sync.Pool{
		New: func() interface{} {
			return &Resp{}
		},
	}
	msgFlags = map[int]string{
		SUCCESS:        "ok",
		ERROR:          "fail",
		INVALIDPARAMS:  "请求参数错误",
		ERRORAUTHTOKEN: "Token生成失败",
		ERRORAUTH:      "Token错误",
	}
)

// GetMsg 返回错误信息
func GetMsg(code int) Resp {
	resp := pool.Get().(*Resp)
	defer func() {
		pool.Put(resp)
	}()
	resp.Code = code
	resp.Msg = msgFlags[code]
	return *resp
}
