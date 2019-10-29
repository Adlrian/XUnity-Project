package com.xunity.xunitycorporate.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping(value = {"/" , "/login"})
    private String Index(){
        return "index";
    }

    @GetMapping ("/menu")
    private String menu(){
        return "menu";
    }
}
