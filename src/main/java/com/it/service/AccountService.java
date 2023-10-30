package com.it.service;

import com.it.pojo.BaseAccount;

import java.util.List;
import java.util.Map;

public interface AccountService {
    /**
     * 根据用户名和密码返回JWT字符串
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 根据token字符串获取账号信息
     * @param token
     * @return
     */
    BaseAccount findLoginUser(String token);


    ///**
    // * 修改用户密码
    // * @param oldPwd
    // * @param newPwd
    // * @param rePasswd
    // * @param request
    // */
    //void updateUserPassword(String oldPwd, String newPwd, String rePasswd, String request);
}
