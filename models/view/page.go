package view

type Page struct {
	OrderType string `json:"type" form:"type" binding:"min=0,max=2"`
	PageNum   int    `json:"page" form:"page" binding:"min=0"`
	Limit     int    `json:"limit" form:"limit" binding:"min=1,max=100"`
}
