create table if not exists db_order (
    order_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    order_name varchar(25) not null,
    order_num mediumint unsigned not null,
    order_startDate date not null,
    order_endDate date,
    is_order tinyint unsigned
)