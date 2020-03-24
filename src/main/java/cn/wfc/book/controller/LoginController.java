package cn.wfc.book.controller;

import cn.wfc.book.bean.JsonResult;
import cn.wfc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    @ResponseBody
    public JsonResult login(@RequestParam("name") String name,
                            @RequestParam("password") String password,
                            HttpServletRequest request){
        return userService.login(name,password,request);
    }

    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }
}
