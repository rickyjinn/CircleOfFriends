package com.example.xk.circleoffriends.controller;

import com.example.xk.circleoffriends.service.impl.PassageLikeService;
import com.example.xk.circleoffriends.service.impl.PassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/passage")
public class PassageController {
    @Autowired
    private PassageLikeService passageLikeService;

    @Autowired
    private PassageService passageService;

    @RequestMapping(value = "likePassage",method = RequestMethod.GET)
    public void likePassage(@PathVariable String account,@PathVariable Integer passageid){
       passageLikeService.likePassage(account,passageid);
    }

    @RequestMapping(value = "cancel",method = RequestMethod.GET)
    public void canclePassage(@PathVariable String account,@PathVariable Integer passageid){
        passageLikeService.cancel(account,passageid);
    }

    @RequestMapping(value = "publishPassage",method = RequestMethod.GET)
    public void publishPassage(HttpServletRequest request){
        String account = request.getParameter("account");
        String content = request.getParameter("content");
        passageService.publish(account,content);
    }

    @RequestMapping(value = "deletePassage",method = RequestMethod.GET)
    public void deletePassage(@PathVariable Integer passageId){
        passageService.deleteByPageId(passageId);
    }






}
