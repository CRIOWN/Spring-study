package com.criown.mapper;

import com.criown.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserlist();

    //根据ID查询用户
    User getUserById(int id);

    //insert一个用户
    int addUser(User user);

    //updata
    int updateUser(User user);

    //delete
    int deleteUser(int id);
}
