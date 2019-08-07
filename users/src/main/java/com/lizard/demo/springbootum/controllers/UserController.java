package com.lizard.demo.springbootum.controllers;

import com.lizard.demo.springbootum.model.User;
import com.lizard.demo.springbootum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserService service;

    @RequestMapping(method = RequestMethod.GET, value="/all")
    public List<User> getAllUsers()
    {
        return service.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value="/register", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public String registerUsers( @RequestBody List<User> users )
    {
        users.forEach( user -> {
            user.setActive( true );
            service.addUser( user );
        } );
        return "Submit successfully.";
    }

    @RequestMapping(method = RequestMethod.POST, value="/edit", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public String updateUsers( @RequestBody List<User> users )
    {
        users.forEach( user -> {
            service.updateUser( user );
        } );
        return "Submit successfully.";
    }

    @RequestMapping(method = RequestMethod.POST, value="/delete", consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public String deleteUsers( @RequestBody List<User> users )
    {
        users.forEach( user -> {
            user.setActive( false );
            service.updateUser( user );
        } );
        return "Submit successfully.";
    }

}
