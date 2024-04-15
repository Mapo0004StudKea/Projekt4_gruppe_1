CREATE TABLE WishList (
    id INT AUTO_INCREMENT PRIMARY KEY,
    wishListName VARCHAR(255)
);

-- Opret produkttabellen med en fremmednøgle til wishlist tabellen
CREATE TABLE Products (
   id INT AUTO_INCREMENT PRIMARY KEY,
   productName VARCHAR(255),
   productLink VARCHAR(255),
   productDescription TEXT,
   price DOUBLE,
   quantity INT,
   wishlist_id INT,
   FOREIGN KEY (wishlist_id) REFERENCES WishList(id)
);

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlistid = wishlist.id;

SHOW COLUMNS FROM products;

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlist_id = wishlist.id;