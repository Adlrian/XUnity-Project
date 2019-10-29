package com.xunity.xunitycorporate;
import com.xunity.xunitycorporate.Model.Customer;
import com.xunity.xunitycorporate.Repository.JdbcCustomerRepository;
import org.slf4j.Logger;
import com.xunity.xunitycorporate.Model.Product;
import com.xunity.xunitycorporate.Repository.JdbcProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@SpringBootApplication
public class XunityCorporateApplication implements CommandLineRunner {

    Logger logger =  LoggerFactory.getLogger(XunityCorporateApplication.class);

    @Autowired
    private JdbcProductRepository jdbcProductRepository;

    public static void main(String[] args) {
        SpringApplication.run(XunityCorporateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("iniciando ....");

        jdbcProductRepository
                .create(new Product(null,"AAA", "AAA", 10.2, 20,9,1,"URLTEST"));
        List<Product> products = jdbcProductRepository
                .findAll();
        logger.info("products: {}", products);



    }
}
