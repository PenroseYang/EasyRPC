package com.github.yeecode.easyrpc.client.controller;

import com.github.yeecode.easyrpc.client.remoteservice.SchoolService;
import com.github.yeecode.easyrpc.client.remoteservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    /**
     * (1) yang笔记
     * 先从client端开始看，比较简单
     * 直接就注入Interface，去找那个beanRegister出来
     */
    @Autowired
    private UserService userService;
    @Autowired
    private SchoolService schoolService;

    @RequestMapping("/getUserCount")
    public String getUserCount() {
        Integer userCount = userService.getUserCount();
        return userCount.toString();
    }

    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        String userInfo = userService.getUserInfo(1);
        return userInfo;
    }

    @RequestMapping("/addUser")
    public String addUser() {
        Integer userId = userService.addUser("name", "abc@gmail.com", 16, 0, "Garden School");
        return userId.toString();
    }

    @RequestMapping("/querySchoolName")
    public String querySchoolName() {
        return schoolService.querySchoolName(5);
    }
}