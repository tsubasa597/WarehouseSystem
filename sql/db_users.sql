create table if not exists db_users (
    order_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    users_name varchar(10) not null,
    users_pwd varchar(32) not null,
    users_type tinyint unsigned
)