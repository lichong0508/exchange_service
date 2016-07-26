package com.lic.exchange.controller;


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

//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody User getUser() {
////        User user = new User();
////        user.setUserName("testName");
////        user.setPhone("123456");
//        return user;
//    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody String addUser(@RequestParam(value = "userName", defaultValue = "null") String name,
                          @RequestParam(value = "phone", defaultValue = "0") String phone) {
        System.out.println(name + phone);
        userDao.updateUser(name, 1);
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
        userDao.updateUser(userName, 1);
        return "update user success:" + userName + phone;
    }
}
