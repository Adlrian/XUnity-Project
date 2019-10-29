package com.xunity.xunitycorporate.Repository;

import com.xunity.xunitycorporate.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcCustomerRepository implements CustomerRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Customer customer) {
        final String sql = "insert into customer(name,lastname,username,password,phone,dni,address,enrollerId,status,customerType,marketId) values (?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, customer.getCustomerName(),customer.getCustomerLastName(),customer.getUsername(),customer.getPassword(),customer.getPhone(),customer.getDni(),customer.getAddress(), customer.getEnrollerId(),customer.getStatus(),customer.getCustomerType(),customer.getMarketId());
    }

    @Override
    public void update(Customer customer) {
        final String sql = "update customer set name = ?, lastname = ? where id = ?";
        jdbcTemplate.update(sql, customer.getCustomerName(), customer.getCustomerLastName(), customer.getCustomerId());
    }

    @Override
    public void delete(Integer id) {
        final String sql = "delete customer where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Customer> findAll() {
        final String sql = "select * from customer";
        return jdbcTemplate.query(sql, JdbcCustomerRepository::CustomerRowMapper);
    }

    @Override
    public Customer findById(Integer id) {
        final String sql = "select * from customer where id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcCustomerRepository::CustomerRowMapper);
    }

    private static Customer CustomerRowMapper(ResultSet resultSet, int i)
            throws SQLException {

        Integer customerId           = resultSet.getInt("id");
        String customerName          = resultSet.getString("name");
        String lastName              = resultSet.getString("lastName");
        String username              = resultSet.getString("username");
        String password              = resultSet.getString("password");
        String phone              = resultSet.getString("phone");
        String dni              = resultSet.getString("dni");
        String address              = resultSet.getString("address");
        Integer enrollerId                = resultSet.getInt("enrollerId");
        Integer status               = resultSet.getInt("status");
        Integer customerType               = resultSet.getInt("customerType");
        Integer marketId             = resultSet.getInt("marketId");


        return new Customer(customerId, customerName,lastName, username,password,phone,dni,address,enrollerId,status,customerType,marketId);

    }
}
