package com.mmall.controller.backend;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by limengxiao on 2018/9/19.
 */
@Controller
@RequestMapping("/manage/user/")
public class UserManageController {

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    public ServerResponse<User> login() {
        System.out.println("run here...");
        return null;
    }

//    @RequestMapping(value = "login.do", method = RequestMethod.POST)
//    public ServerResponse<User> login(String username, String password, HttpSession httpSession) {
//        System.out.println("run here...");
//        ServerResponse<User> response = iUserService.login(username, password);
//        return null;
//    }
}
