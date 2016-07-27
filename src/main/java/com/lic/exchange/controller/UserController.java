package com.lic.exchange.controller;


import com.lic.exchange.bean.UserEntity;
import com.lic.exchange.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by lichong on 16/7/18.
 */

@RestController
@EnableWebMvc
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody UserEntity getUser() {
        System.out.println(userDao.findUserById(1).getPhone());
        return userDao.findUserById(1);
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam(value = "userName", defaultValue = "null") String name,
                          @RequestParam(value = "phone", defaultValue = "0") String phone) {
        System.out.println(name + phone);
//        User user = new User();
//        user.setPhone(phone);
//        user.setUserName(name);
        return "add user success:" + name;
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody String delUser() {
        return "delete user success";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody String updateUser(@RequestParam(value = "userName",defaultValue = "null") String userName,
                                           @RequestParam(value = "phone", defaultValue = "1234567") String phone) {
        return "update user success:" + userName + phone;
    }
}
