package stud.kea.dk.projekt4_gruppe_1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import stud.kea.dk.projekt4_gruppe_1.model.Product;
import stud.kea.dk.projekt4_gruppe_1.model.User;

import java.util.List;
@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUser(){
        String DISPLAY_USER_SQL = "SELECT FROM users";
        List<User> userList = jdbcTemplate.query(DISPLAY_USER_SQL,new BeanPropertyRowMapper<>(User.class));
        return userList;
    }
    public void createUser(User user) {
        final String INSERT_USER_SQL = "INSERT INTO users (firstname, lastname, email, pwd, dateOfBirth) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(INSERT_USER_SQL, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPwd(), user.getDateOfBirth());
    }

    public User getUserListbyId(int id) {
        String get_USER_SQL = "SELECT * FROM users WHERE id =?";
        return jdbcTemplate.queryForObject(get_USER_SQL, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    public void deleteUserById(int id) {
        String DELETE_USERLIST_SQL = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(DELETE_USERLIST_SQL, id);
    }

    public void updateProducts(User user) {
        String UPDATE_USER_SQL = "UPDATE users SET firstname WHERE id =?";
        jdbcTemplate.update(UPDATE_USER_SQL, user.getFirstName(), user.getId());
    }
}
