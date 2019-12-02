package com.xunity.xunitycorporate.Repository;

import com.xunity.xunitycorporate.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(User user) {
        final String sql = "insert into user(username,password,name,lastName,email,department,marketId) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, user.getUsername(),user.getPassword(),user.getName(),user.getLastName(),user.getEmail(),user.getDepartment(),user.getMarketId());
    }

    @Override
    public void update(User user) {
        final String sql = "update user set username = ?, password = ?, name=?, lastName=?,email=?, department=?,marketId=? where id = ?";
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(),user.getName(),user.getLastName(),user.getEmail(),user.getDepartment(),user.getMarketId(), user.getUserId());
    }

    @Override
    public void delete(Integer id) {
        final String sql = "delete user where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<User> findAll() {
        final String sql = "select * from user";
        return jdbcTemplate.query(sql, JdbcUserRepository::UserRowMapper);
    }

    @Override
    public User findById(Integer id) {
        final String sql = "select * from user where id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcUserRepository::UserRowMapper);
    }
    private static User UserRowMapper(ResultSet resultSet, int i)
            throws SQLException {

        Integer userId           = resultSet.getInt("id");
        String userName          = resultSet.getString("username");
        String password   = resultSet.getString("password");
        String name              = resultSet.getString("name");
        String lastName          = resultSet.getString("lastName");
        String email          = resultSet.getString("email");
        String department          = resultSet.getString("department");
        Integer marketId               = resultSet.getInt("marketId");


        return new User(userId, userName,password, name,lastName,email,department,marketId);
    }
}
