package cn.wfc.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @PostMapping("/login")
    public String login(String userName, String password) {
        if (userName.equals("admin") && password.equals("123456")) {
            return "edit";
        } else {
            return "error";
        }
    }
}
