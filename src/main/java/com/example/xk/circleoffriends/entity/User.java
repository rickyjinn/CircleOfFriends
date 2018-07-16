package com.example.xk.circleoffriends.entity;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user")   //可以指定为自定义表名
public class User {
    @Id
    private String account;
    @Column (name = "nickname") //可指定为自定义列名
    private String nickname;
    private String password;

    public User(String account, String nickname, String password) {
        this.account = account;
        this.nickname = nickname;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {

        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
