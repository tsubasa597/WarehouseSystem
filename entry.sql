create table db_users (
    id int unsigned AUTO_INCREMENT PRIMARY KEY,
    name varchar(10) not null,
    age tinyint unsigned not null,
    sex tinyint unsigned not null,
    phone varchar(20) not null,
    pwd varchar(32),
    type tinyint unsigned not null
);


create table db_customer (
    id int unsigned AUTO_INCREMENT PRIMARY KEY,
    name varchar(10) not null,
    phone varchar(14) not null,
    space varchar(14) not null,
);


create table db_supplier (
    id int unsigned AUTO_INCREMENT PRIMARY KEY,
    name varchar(10) not null,
    phone varchar(14) not null,
    space varchar(14) not null,
);

create table goods (
    id int unsigned AUTO_INCREMENT PRIMARY KEY,
    name varchar(20) not null,
    num int unsigned default 0,
    price int unsigned not null,
    supplier_id int unsigned,
    foreign key(supplier_id) references db_supplier(id),
);

create table db_orders (
    id int unsigned AUTO_INCREMENT PRIMARY KEY,
	type tinyint unsigned not null,
	date       varchar(11) not null,
	price      int unsigned not null,
	done       tinyint unsigned not null, 
	user_id     int unsigned,
	customer_id int unsigned,
    foreign key(user_id) references db_users(id),
    foreign key(customer_id) references db_customer(id),
);

create table db_order_details (
    order_id int unsigned,
    goods_id int unsigned,
    num int unsigned,
    foreign key(order_id) references db_orders(id),
    foreign key(goods_id) references db_goods(id),
);

