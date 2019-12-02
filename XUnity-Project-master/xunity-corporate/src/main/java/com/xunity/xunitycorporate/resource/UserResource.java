package com.xunity.xunitycorporate.resource;

import com.xunity.xunitycorporate.Model.User;
import com.xunity.xunitycorporate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    //GET
    @GetMapping("/users")
    public ResponseEntity getAll(){

        List<User> users = userService.findAll();
        if(users == null){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(users, HttpStatus.OK);
    }

    //GET BY ID
    @GetMapping("/users/{id}")
    public ResponseEntity getById(@PathVariable Integer id){

        User currentUser = userService.findById(id);
        if(currentUser == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentUser, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity create(@RequestBody User user){
        userService.create(user);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody User user){

        User currentUser = userService.findById(id);
        if(currentUser == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setName(user.getName());
        currentUser.setLastName(user.getLastName());
        currentUser.setEmail(user.getEmail());
        currentUser.setDepartment(user.getDepartment());
        currentUser.setMarketId(user.getMarketId());

        userService.update(currentUser);

        return new ResponseEntity(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        User currentUser = userService.findById(id);
        if(currentUser == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        userService.delete(currentUser);
        return new ResponseEntity(HttpStatus.OK);
    }
}

