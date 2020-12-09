create table if not exists db_supplier (
    supplier_id int unsigned AUTO_INCREMENT PRIMARY KEY,
    supplier_name varchar(10) not null,
    supplier_phone varchar(20)
);