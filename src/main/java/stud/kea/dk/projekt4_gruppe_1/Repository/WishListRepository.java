package stud.kea.dk.projekt4_gruppe_1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import stud.kea.dk.projekt4_gruppe_1.Model.WishList;

import java.util.List;

@Repository
public class WishListRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<WishList> getWishList() {
        String DISPLAY_WISHLIST_SQL = "SELECT * FROM wishlist";
        List<WishList> wishList = jdbcTemplate.query(DISPLAY_WISHLIST_SQL, new BeanPropertyRowMapper<>(WishList.class));
        return wishList;
    }

    public void createWishlist(WishList wishList) {
        final String INSERT_WISHLIST_SQL = "INSERT INTO wishlist (wishListName) VALUES (?)";
        jdbcTemplate.update(INSERT_WISHLIST_SQL, wishList.getWishListName());
    }

    public WishList getWishlistByid(int id) {
        String GET_WISHLIST_SQL = "SELECT * FROM wishlist WHERE id = ?";
        return jdbcTemplate.queryForObject(GET_WISHLIST_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(WishList.class));
    }

    public void deleteWishlistById(int id) {
        String DELETE_WISHLIST_SQL = "DELETE FROM wishlist WHERE id = ?";
        jdbcTemplate.update(DELETE_WISHLIST_SQL, id);
    }

    public void updateWiSHList(WishList wishList) {
        String UPDATE_WISHLIST_SQL = "UPDATE wishlist SET wishListName WHERE id = ?";
        jdbcTemplate.update(UPDATE_WISHLIST_SQL, wishList.getWishListName(), wishList.getId());
    }
}
