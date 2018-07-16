package com.example.xk.circleoffriends.service.impl;

import com.example.xk.circleoffriends.mapper.UserMapper;
import com.example.xk.circleoffriends.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUser(String account) {
        return userMapper.selectByPrimaryKey(account);
    }

//    //注册账户
//    public int addUser(User user) {
//        return userMapper.insert(user);
//    }

    //登录
    public Boolean login(String account,String password){
        User user = userMapper.selectByPrimaryKey(account);
        if (password.equals(user.getPassword()))
            return true;
        return false;
    }

    public Boolean register(String account,String nickname,String password){
        User user = userMapper.selectByPrimaryKey(account);
        if (Objects.nonNull(user))
            return false;
        user = new User(account,nickname,password);
        userMapper.insert(user);
        return true;
    }

    public void modifyNickName(String account,String nickname){
        User user = userMapper.selectByPrimaryKey(account);
        user.setNickname(nickname);
        userMapper.updateByPrimaryKey(user);
    }

}
