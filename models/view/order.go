package view

type Order struct {
	ID           int    `json:"id"`
	Type         int    `json:"type"`
	Date         string `json:"date"`
	Price        int    `json:"price"`
	Done         int    `json:"done"`
	UserName     string `json:"user_name"`
	CustomerName string `json:"customer_name"`
}
