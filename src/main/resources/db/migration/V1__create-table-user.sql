CREATE TABLE usuario(
    user_id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    user_password VARCHAR(50) NOT NULL,
    user_is_active BOOLEAN NOT NULL,
    user_role INT NOT NULL,
    user_phone VARCHAR(20),
    user_cpf VARCHAR(20) NOT NULL
);

CREATE TABLE produto(
    product_id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    product_price DECIMAL(10,2) NOT NULL,
    product_expiry VARCHAR(20) NOT NULL,
    product_description VARCHAR(255),
    product_manufactoring_date VARCHAR(20) NOT NULL,
    product_supplier_id INT,
    FOREIGN KEY (product_supplier_id) REFERENCES usuario(user_id)
);