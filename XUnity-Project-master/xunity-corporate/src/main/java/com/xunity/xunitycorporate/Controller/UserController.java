package com.xunity.xunitycorporate.Controller;

import com.xunity.xunitycorporate.Model.User;
import com.xunity.xunitycorporate.Model.User;
import com.xunity.xunitycorporate.Service.UserService;
import com.xunity.xunitycorporate.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController implements GenericController<User, Integer>{
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getList(Model model) {
        //list
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user";
    }

    @PostMapping("/users/save")
    public String save(User user, Model model) {
        //save
        userService.create(user);

        return "redirect:/users";
    }

    @GetMapping("/users/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user-add";
    }

    @GetMapping("/users/edit/{userId}")
    public String getForUpdate(@PathVariable Integer userId, Model model) {
        User currentUser = userService.findById(userId);
        model.addAttribute("user", currentUser);
        return "user-edit";
    }

    @PostMapping("/users/update/{userId}")
    public String update(@PathVariable Integer userId, User user, Model model) {
        //Update
        userService.update(user);

        return "redirect:/users";
    }

    @GetMapping("/users/delete/{userId}")
    public String delete(@PathVariable Integer userId, Model model) {
        User currentUser = userService.findById(userId);
        //Delete
        userService.delete(currentUser);
        return "redirect:/users";
    }
}
