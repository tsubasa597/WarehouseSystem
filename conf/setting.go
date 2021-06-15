package conf

import (
	"log"
	"time"

	"github.com/go-ini/ini"
)

var (
	// Cfg ini File
	Cfg *ini.File

	// RunMode gin 运行时的模式
	RunMode string
	// HTTPPort 监听端口
	HTTPPort int
	// ReadTimeout 超时
	ReadTimeout time.Duration
	// WriteTimeout 超时
	WriteTimeout time.Duration
	// PageSize 分页大小
	PageSize int
	// JwtSecret jwt 的密钥
	JwtSecret    string
	DATABASETYPE string
)

func init() {
	var err error
	Cfg, err = ini.Load("conf/conf.ini")
	if err != nil {
		log.Fatalf("Fail to parse 'conf/app.ini': %v", err)
	}

	LoadBase()
	LoadServer()
	LoadApp()
}

// LoadBase 读取数据库配置
func LoadBase() {
	RunMode = Cfg.Section("").Key("RUN_MODE").MustString("debug")
	DATABASETYPE = Cfg.Section("database").Key("TYPE").MustString("sqllite")
}

// LoadServer 读取服务配置
func LoadServer() {
	sec, err := Cfg.GetSection("server")
	if err != nil {
		log.Fatalf("Fail to get section 'server': %v", err)
	}

	HTTPPort = sec.Key("HTTP_PORT").MustInt(8000)
	ReadTimeout = time.Duration(sec.Key("READ_TIMEOUT").MustInt(60)) * time.Second
	WriteTimeout = time.Duration(sec.Key("WRITE_TIMEOUT").MustInt(60)) * time.Second
}

// LoadApp 读取 App 配置
func LoadApp() {
	sec, err := Cfg.GetSection("app")
	if err != nil {
		log.Fatalf("Fail to get section 'app': %v", err)
	}

	JwtSecret = sec.Key("JWT_SECRET").MustString("!@)*#)!@U#@*!@!)")
	PageSize = sec.Key("PAGE_SIZE").MustInt(10)
}
