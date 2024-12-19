CREATE TABLE product_categories (
                                    id INT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
);

CREATE TABLE products (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          price INT NOT NULL,
                          category_id INT,
                          FOREIGN KEY (category_id) REFERENCES product_categories(id)
);
