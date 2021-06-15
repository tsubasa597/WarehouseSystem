package view

const (
	Manager = iota + 1
	Admin
)

type Menu struct {
	Name string
	Url  string
}

type Menus struct {
	Name     string
	Children []Menu
}

func GetMenu(position int) []Menus {
	if position == Admin {
		return []Menus{
			{
				Name: "订单详情",
				Children: []Menu{
					{"查看订单", "main/manager/order"},
				},
			},
			{
				Name: "商品详情",
				Children: []Menu{
					{"查看商品", "main/manager/goods"},
				},
			},
			{
				Name: "用户管理",
				Children: []Menu{
					{"查看用户", "main/manager/user"},
					{"查看供应商", "main/manager/supplier"},
					{"查看客户", "main/manager/customer"},
				},
			},
		}
	} else if position == Manager {
		return []Menus{
			{
				Name: "订单详情",
				Children: []Menu{
					{"查看订单", "main/manager/order"},
				},
			},
			{
				Name: "商品详情",
				Children: []Menu{
					{"查看商品", "main/manager/goods"},
				},
			},
		}
	}
	return nil
}
