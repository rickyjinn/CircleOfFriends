package com.example.xk.circleoffriends;

import com.example.xk.circleoffriends.entity.Passage;
import com.example.xk.circleoffriends.entity.User;
import com.example.xk.circleoffriends.service.impl.FriendRelationshipService;
import com.example.xk.circleoffriends.service.impl.PassageLikeService;
import com.example.xk.circleoffriends.service.impl.PassageService;
import com.example.xk.circleoffriends.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CircleoffriendsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    private PassageService passageService;

    @Autowired
    private PassageLikeService passageLikeService;

    @Autowired
    private FriendRelationshipService friendRelationshipService;

    @Test
    public void testGetUser(){
        String account = "c";
        User u = userService.getUser(account);
        System.out.println(u.getNickname());
    }

    @Test
    public void testPassage(){
        String account = "a";
        String content = "this is my first passage";
        passageService.publish(account,content);
    }

    @Test
    public void likePassage(){
        String account = "b";
        passageLikeService.likePassage(account,1);
    }

    @Test
    public void dislikePassage(){
        passageLikeService.cancel("b",1);
    }

    @Test
    public void testAddFriend(){
        friendRelationshipService.addFriend("a","b");
    }

    @Test
    public void testDeleteFriend(){
        friendRelationshipService.deleteFriend("a","b");
    }

}
