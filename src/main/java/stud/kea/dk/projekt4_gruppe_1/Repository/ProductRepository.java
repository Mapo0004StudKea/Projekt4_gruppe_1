package stud.kea.dk.projekt4_gruppe_1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stud.kea.dk.projekt4_gruppe_1.Model.Product;
import stud.kea.dk.projekt4_gruppe_1.Model.WishList;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Product> getProductsList() {
        String DISPLAY_SQL = "SELECT * FROM products";
        List<Product> productList = jdbcTemplate.query(DISPLAY_SQL, new BeanPropertyRowMapper<>(Product.class));
        return productList;
    }

    public void createNewProducts(Product product) {
        final String INSERT_PRODUCTS_SQL = "INSERT INTO products (productName, productLink, productDescription, price, quantity) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(INSERT_PRODUCTS_SQL, product.getProductName(), product.getProductLink(), product.getProductDescription(), product.getPrice(), product.getQuantity());
    }

}
