CREATE TABLE IF NOT EXISTS wishlist (
    id INT PRIMARY KEY AUTO_INCREMENT,
    wishlistname VARCHAR(100) NOT NULL
);

-- Opret produkttabellen med en fremmednøgle til wishlist tabellen
CREATE TABLE IF NOT EXISTS products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    productname VARCHAR(100),
    productlink VARCHAR(250),
    productdescription VARCHAR(500),
    price DOUBLE,
    quantity INT,
    wishlistid INT,
    FOREIGN KEY (wishlistid) REFERENCES wishlist(id) ON UPDATE CASCADE ON DELETE RESTRICT
);

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlistid = wishlist.id;

SHOW COLUMNS FROM products;

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlist_id = wishlist.id;