package com.example.xk.circleoffriends.service.impl;

import com.example.xk.circleoffriends.entity.PassageLike;
import com.example.xk.circleoffriends.mapper.PassageLikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassageLikeService {
    @Autowired
    private PassageLikeMapper passageLikeMapper;

    public int likePassage(String account,Integer passageId){
        PassageLike passageLike = new PassageLike();
        passageLike.setAccount(account);
        passageLike.setPassageId(passageId);
        return passageLikeMapper.insert(passageLike);
    }

    public int cancel(String account,Integer passageId){
        PassageLike passageLike = new PassageLike();
        passageLike.setAccount(account);
        passageLike.setPassageId(passageId);
        return passageLikeMapper.delete(passageLike);
    }
}
