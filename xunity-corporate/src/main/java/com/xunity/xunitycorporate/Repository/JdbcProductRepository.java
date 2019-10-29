package com.xunity.xunitycorporate.Repository;
import com.xunity.xunitycorporate.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcProductRepository implements ProductRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Product product) {
        final String sql = "insert into product(name,description,price,stock,cvPoints,status,imageUrl) values (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, product.getProductName(),product.getProductDescription(),product.getPrice(),product.getStock(),product.getCvPoints(),product.getStatus(),product.getImageUrl());
    }

    @Override
    public void update(Product product) {
        final String sql = "update product set name = ?, price = ? where id = ?";
        jdbcTemplate.update(sql, product.getProductName(), product.getPrice(), product.getProductId());
    }

    @Override
    public void delete(Integer id) {
        final String sql = "delete product where id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Product> findAll() {
        final String sql = "select * from product";
        return jdbcTemplate.query(sql, JdbcProductRepository::ProductRowMapper);
    }

    @Override
    public Product findById(Integer id) {
        final String sql = "select * from product where id = ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                JdbcProductRepository::ProductRowMapper);
    }

    private static Product ProductRowMapper(ResultSet resultSet, int i)
            throws SQLException {

        Integer productId           = resultSet.getInt("id");
        String productName          = resultSet.getString("name");
        String productDescription   = resultSet.getString("description");
        Double price                = resultSet.getDouble("price");
        Integer stock               = resultSet.getInt("stock");
        Integer cvPoints            = resultSet.getInt("cvPoints");
        Integer status              = resultSet.getInt("status");
        String imageUrl             = resultSet.getString("imageUrl");

        return new Product(productId, productName,productDescription, price,stock,cvPoints,status,imageUrl);
    }
}
