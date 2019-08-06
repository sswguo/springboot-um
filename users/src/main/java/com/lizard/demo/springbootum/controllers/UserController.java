package com.lizard.demo.springbootum.controllers;

import com.lizard.demo.springbootum.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @RequestMapping(method = RequestMethod.GET, value="/allusers")
    public List<User> getAllUsers()
    {
        //TODO
        List<User> users = new ArrayList<>(  );
        User u1 = new User();
        u1.setName( "Jack" );
        u1.setEmail( "jack@gmail.com" );
        users.add( u1 );

        return users;
    }

}
