package com.xunity.xunitycorporate.Service;

import com.xunity.xunitycorporate.Model.User;
import com.xunity.xunitycorporate.Repository.JdbcUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements GenericService<User, Integer>{

    @Autowired
    private JdbcUserRepository jdbcUserRepository;

    @Override
    public void create(User user) {
        jdbcUserRepository.create(user);
    }

    @Override
    public void update(User user) {
        jdbcUserRepository.update(user);
    }

    @Override
    public void delete(User user) {
        jdbcUserRepository.delete(user.getUserId());
    }

    @Override
    public List<User> findAll() {
        List<User> users = jdbcUserRepository.findAll();
        return users;
    }

    @Override
    public User findById(Integer userId) {
        User user =jdbcUserRepository.findById(userId);
        return user;
    }
}
