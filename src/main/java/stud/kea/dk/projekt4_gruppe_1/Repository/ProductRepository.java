package stud.kea.dk.projekt4_gruppe_1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stud.kea.dk.projekt4_gruppe_1.Model.Product;

import java.util.List;

@Repository
public class ProductRepository {
@Autowired
    JdbcTemplate jdbcTemplate;

        public List<Product> getProducts(){
            String DISPLAY_PRODUCT_SQL = "SELECT FROM product";
            List<Product> productList = jdbcTemplate.query(DISPLAY_PRODUCT_SQL,new BeanPropertyRowMapper<>(Product.class));
            return productList;
        }
        public void createProduct(Product product) {
            final String INSERT_PRODUCT_SQL = "INSERT INTO product (productname, productdescription, price, quantity) VALUES (?,?,?,?)";
            jdbcTemplate.update(INSERT_PRODUCT_SQL, product.getProductName(), product.getProductDescription(), product.getPrice(), product.getQuantity());
    }

    public Product getProductListbyId(int id) {
            String get_PRODUCT_SQL = "SELECT * FROM product WHERE id =?";
            return jdbcTemplate.queryForObject(get_PRODUCT_SQL,new Object[]{id}, new BeanPropertyRowMapper<>(Product.class));
    }

    public void deleteProductById(int id) {
            String DELETE_PRODUCTLIST_SQL = "DELETE FROM product WHERE id = ?";
            jdbcTemplate.update(DELETE_PRODUCTLIST_SQL, id);
    }

    public void updateProducts(Product product) {
            String UPDATE_PRODUCT_SQL = "UPDATE product SET productname WHERE id =?";
            jdbcTemplate.update(UPDATE_PRODUCT_SQL, product.getProductName(), product.getId());
    }

}
