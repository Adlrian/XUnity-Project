package com.xunity.xunitycorporate.Service;

import com.xunity.xunitycorporate.Model.Customer;
import com.xunity.xunitycorporate.Model.Product;
import com.xunity.xunitycorporate.Repository.JdbcCustomerRepository;
import com.xunity.xunitycorporate.Repository.JdbcProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements GenericService<Customer, Integer>{

    @Autowired
    private JdbcCustomerRepository jdbcCustomerRepository;

    @Override
    public void create(Customer customer) {
        jdbcCustomerRepository.create(customer);
    }

    @Override
    public void update(Customer customer) {
        jdbcCustomerRepository.update(customer);
    }

    @Override
    public void delete(Customer customer) {
        jdbcCustomerRepository.delete(customer.getCustomerId());
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = jdbcCustomerRepository.findAll();
        return customers;    }

    @Override
    public Customer findById(Integer buscarporid) {
        Customer customer =jdbcCustomerRepository.findById(buscarporid);
        return customer;
    }
}
