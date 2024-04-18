CREATE TABLE users (
  id INT PRIMARY KEY AUTO_INCREMENT,
  firstname VARCHAR(255),
  lastname VARCHAR(255),
  email VARCHAR(255),
  pwd VARCHAR(255),
  dateOfBirth VARCHAR(255)
);

CREATE TABLE WishList (
    id INT AUTO_INCREMENT PRIMARY KEY,
    wishListName VARCHAR(255),
	user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
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
 FOREIGN KEY (wishlist_id) REFERENCES WishList(id) ON DELETE CASCADE
);

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlistid = wishlist.id;

SHOW COLUMNS FROM products;

SELECT products.*, wishlist.wishlistname
FROM products
JOIN wishlist ON products.wishlist_id = wishlist.id;