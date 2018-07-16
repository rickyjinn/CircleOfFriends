package com.example.xk.circleoffriends.service.impl;

import com.example.xk.circleoffriends.entity.Passage;
import com.example.xk.circleoffriends.mapper.PassageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PassageService {
    @Autowired
    private PassageMapper passageMapper;


    public void publish(String account,String content){
        Timestamp ts=new Timestamp(new Date().getTime());
        Passage p = new Passage();
        p.setUserAccount(account);
        p.setContent(content);
        p.setDate(ts);
        passageMapper.insertUseGeneratedKeys(p);
    }

    public int deleteByPageId(Integer id){
        return passageMapper.deleteByPrimaryKey(id);
    }


}
