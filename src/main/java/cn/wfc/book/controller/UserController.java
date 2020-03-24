package cn.wfc.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/login")
    @ResponseBody
    public Map login(@RequestParam("name") String name,
                     @RequestParam("password") String password,
                     HttpServletRequest request){
        Map<String, String> map = new HashMap<>();
        if (name.equals("admin") && password.equals("111111")) {
            request.getSession().setAttribute("loginUser",name);
            map.put("message", "success");
        } else {
            map.put("message", "用户名错误");
        }
        return map;
    }
    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }
}
