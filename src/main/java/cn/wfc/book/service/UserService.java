package cn.wfc.book.service;

import cn.wfc.book.bean.JsonResult;
import cn.wfc.book.bean.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public interface UserService {
    User findUserByName(String name);

    JsonResult login(String name, String password,HttpSession session);
}
