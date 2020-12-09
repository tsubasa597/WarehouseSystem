create table if not exists db_orders (
    order_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    goods_name varchar(25) not null,
    goods_num mediumint unsigned not null,
    order_date varchar(10) not null,
    order_type tinyint unsigned,
    order_user varchar(10) not null,
    order_price tinyint unsigned not null
);