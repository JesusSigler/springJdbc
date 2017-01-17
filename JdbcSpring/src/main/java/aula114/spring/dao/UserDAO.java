package aula114.spring.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import aula114.spring.domain.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
	
    public List<User> findAll() {
	String sql = "select * from user";
	List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	return userList;
    }
    public void add(User user) {
        String sql = "insert into user (first_name, age) values (?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getAge());
    }

}
