create table if not exists db_order (
    order_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    goods_name varchar(25) not null,
    goods_num mediumint unsigned not null,
    order_start_date varchar(10) not null,
    order_end_date varchar(10),
    is_order tinyint unsigned,
    order_type tinyint unsigned,
    order_describe text
);