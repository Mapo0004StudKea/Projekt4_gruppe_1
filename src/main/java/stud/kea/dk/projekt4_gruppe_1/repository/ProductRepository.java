package stud.kea.dk.projekt4_gruppe_1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stud.kea.dk.projekt4_gruppe_1.model.Product;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getProductsList() {
        String DISPLAY_PRODUCTLIST_SQL = "SELECT * FROM products";
        List<Product> productList = jdbcTemplate.query(DISPLAY_PRODUCTLIST_SQL, new BeanPropertyRowMapper<>(Product.class));
        return productList;
    }

    public List<Product> getProductListBySpecifiedId(int wishlistId) {
        String DISPLAY_ID_SQL = "SELECT * FROM Products WHERE wishlist_id = ?;";
        List<Product> productListById = jdbcTemplate.query(DISPLAY_ID_SQL, new Object[]{wishlistId},  new BeanPropertyRowMapper<>(Product.class));
        return productListById;
    }

    public void createNewProducts(Product product) {
        final String INSERT_PRODUCTS_SQL = "INSERT INTO products (productName, productLink, productDescription, price, quantity, wishlist_id) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(INSERT_PRODUCTS_SQL, product.getProductName(), product.getProductLink(), product.getProductDescription(), product.getPrice(), product.getQuantity(), product.getWishlist_id());
    }

    public void deleteFromProducts(int id) {
        String DELETE_FROM_Products_SQL = "DELETE FROM products where id = ?";
        jdbcTemplate.update(DELETE_FROM_Products_SQL, id);
    }

    public Product getProductById(int id) {
        String GET_ID_SQL = "SELECT * FROM products WHERE id = ?";
        return jdbcTemplate.queryForObject(GET_ID_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public void updateProductEntry(Product product) {
        String UPDATE_SQL = "UPDATE products SET productName = ?, productLink = ?, productDescription = ?, price = ?, quantity = ? WHERE id = ?";
        jdbcTemplate.update(UPDATE_SQL, product.getProductName(), product.getProductLink(), product.getProductDescription(), product.getPrice(), product.getQuantity(), product.getId());
    }
}
