package com.example.xk.circleoffriends.service.impl;

import com.example.xk.circleoffriends.entity.FriendRelationship;
import com.example.xk.circleoffriends.entity.User;
import com.example.xk.circleoffriends.mapper.FriendRelationshipMapper;
import com.example.xk.circleoffriends.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FriendRelationshipService {
    @Autowired
    private FriendRelationshipMapper friendRelationshipMapper;

    @Autowired
    private UserMapper userMapper;

    public void addFriend(String account,String friendAccount){
        FriendRelationship friendRelationship = new FriendRelationship(account,friendAccount);
        FriendRelationship friendRelationshipReverse = new FriendRelationship(friendAccount,account);
        try{
            friendRelationshipMapper.insert(friendRelationship);
            friendRelationshipMapper.insert(friendRelationshipReverse);
            //commit
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteFriend(String account,String friendAccount){
        FriendRelationship friendRelationship = new FriendRelationship(account,friendAccount);
        try{
            friendRelationshipMapper.delete(friendRelationship);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<User> selectFriends(String account){
        Example example = new Example(FriendRelationship.class);
        example.createCriteria().andEqualTo("account",account);
        List<FriendRelationship> friendRelationships = friendRelationshipMapper.selectByExample(example);
        List<String> friendsAccounts = friendRelationships.stream().map(FriendRelationship::getFriendAccount).collect(Collectors.toList());
        Example userExample = new Example(User.class);
        example.createCriteria().andIn("account",friendsAccounts);
        List<User> friends = userMapper.selectByExample(userExample);
        return friends;
    }

}
