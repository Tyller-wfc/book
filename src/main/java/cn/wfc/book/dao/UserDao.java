package cn.wfc.book.dao;

import cn.wfc.book.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User findUserByName(String name);

    int addUser(User user);

    User findUserById(String userId);
}
