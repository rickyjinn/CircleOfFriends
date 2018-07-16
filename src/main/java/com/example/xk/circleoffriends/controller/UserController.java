package com.example.xk.circleoffriends.controller;

import com.example.xk.circleoffriends.entity.User;
import com.example.xk.circleoffriends.service.impl.FriendRelationshipService;
import com.example.xk.circleoffriends.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private FriendRelationshipService friendRelationshipService;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public void addUser(){

    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(@RequestParam("account") String account,@RequestParam(value = "password",defaultValue="test") String password ){
        Boolean isLogin = userService.login(account,password);
        if (isLogin) {
            System.out.println("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
        return "login";
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String register(HttpServletRequest request){
        String account = request.getParameter("account");
        String nickname = request.getParameter("nickname");
        String password = request.getParameter("password");
        Boolean isRegist = userService.register(account,nickname,password);
        return "register";
    }


    @RequestMapping(value = "modifyNickname",method = RequestMethod.GET)
    public String modifyNickname(@PathVariable String account, @PathVariable String nickname){
        userService.modifyNickName(account,nickname);
        return "modifyNickname";
    }


    @RequestMapping(value = "getFriends",method = RequestMethod.GET)
    public void selectFriends(@PathVariable String account,Model model){
        List<User> users = friendRelationshipService.selectFriends(account);
        model.addAttribute("users",users);
        //  friendRelationshipService.addFriend();
        //  friendRelationshipService.deleteFriend();
    }






}
