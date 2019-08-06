package com.lizard.demo.springbootum.controllers;

import com.lizard.demo.springbootum.model.User;
import com.lizard.demo.springbootum.operation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET, value="/allusers")
    public List<User> getAllUsers()
    {
        return service.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value="/register")
    @ResponseBody
    public String registerUser(@RequestParam(name = "username") String username, @RequestParam(name = "email") String email ) {
        User u1 = new User();
        u1.setName( username );
        u1.setEmail( email );
        service.addUser(u1);
        return "successfully.";

    }

}
