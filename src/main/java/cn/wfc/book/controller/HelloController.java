package cn.wfc.book.controller;

import cn.wfc.book.bean.User;
import cn.wfc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/v1")
    public String v1(){
        return "v1";
    }

    @RequestMapping("/user")
    @ResponseBody
    public User findUserByName(){
        return userService.findUserByName("");
    }
}
