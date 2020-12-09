create table if not exists db_users (
    user_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(10) not null,
    user_age tinyint unsigned not null,
    user_sex tinyint unsigned not null,
    user_phone varchar(20) not null,
    user_pwd varchar(32),
    user_type tinyint unsigned not null
);