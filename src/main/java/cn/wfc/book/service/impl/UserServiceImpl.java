package cn.wfc.book.service.impl;

import cn.wfc.book.bean.JsonResult;
import cn.wfc.book.bean.User;
import cn.wfc.book.dao.UserDao;
import cn.wfc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserByName(String name) {
        return userDao.findUserByName("demo");
    }

    @Override
    public JsonResult login(String name, String password, HttpServletRequest request) {
        User user = new User(name, password);
        if (user == null) {
            return new JsonResult("传入用户信息为空");
        } else {
            User one = userDao.findUserByName(name);
            if (one == null) {
                return new JsonResult(1, "用户名不存在");
            } else if (!one.getPassword().equals(user.getPassword())) {
                return new JsonResult(2, "密码错误");
            } else {
                request.getSession().setAttribute("loginUser", one);
                return new JsonResult(one);
            }
        }
    }
}
