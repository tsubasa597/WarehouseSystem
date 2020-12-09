create table if not exists db_goods (
    goods_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    goods_name varchar(25) not null,
    goods_num mediumint unsigned not null,
    goods_supplier varchar(10)
);