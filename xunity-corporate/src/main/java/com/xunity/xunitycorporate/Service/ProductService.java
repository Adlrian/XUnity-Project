package com.xunity.xunitycorporate.Service;

import com.xunity.xunitycorporate.Model.Product;
import com.xunity.xunitycorporate.Repository.JdbcProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService implements GenericService<Product, Integer>{

    @Autowired
    private JdbcProductRepository jdbcProductRepository;

    @Override
    public void create(Product product) {
        jdbcProductRepository.create(product);
    }

    @Override
    public void update(Product product) {
        //List<Product> products = jdbcProductRepository.findAll();
        //Product currentProduct = findById(product.getProductId());
        //int index = products.indexOf(currentProduct);
        //products.set(index, product);
        jdbcProductRepository.update(product);
    }

    @Override
    public void delete(Product product) {
        //products.remove(product);
        jdbcProductRepository.delete(product.getProductId());
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = jdbcProductRepository.findAll();
        return products;
    }

    @Override
    public Product findById(Integer productId) {
        Product product =jdbcProductRepository.findById(productId);
        return product;
    }
}
