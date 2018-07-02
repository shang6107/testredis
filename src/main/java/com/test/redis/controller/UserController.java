package com.test.redis.controller;

import com.test.redis.modal.User;
import com.test.redis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author 上官炳强
 * @description
 * @since 2018-06-30 / 03:35:48
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Integer id, Map<String, Object> map){
        map.put("user", userService.select(id));
        return "input";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id){
        userService.delete(id);
        return "redirect:/all";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String update(User u){
        userService.update(u);
        return "redirect:/all";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String add(){
        return "input";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String add2DB(User u){
        userService.add(u);
        return "redirect:/all";
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAll(Map<String, Object> map){
        map.put("all", userService.getAll());
        return "index";
    }

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "abc";
    }

}
