create table if not exists db_customer (
    customer_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    customer_name varchar(10) not null,
    customer_phone varchar(20)
)