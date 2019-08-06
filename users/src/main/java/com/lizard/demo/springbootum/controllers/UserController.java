package com.lizard.demo.springbootum.controllers;

import com.lizard.demo.springbootum.model.User;
import com.lizard.demo.springbootum.operation.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

        RestTemplate restTemplate = new RestTemplate(  );

        MultiValueMap<String, String> mvm = new LinkedMultiValueMap<String, String>();
        mvm.add("username", u1.getName());

        ResponseEntity<String>
                        result = restTemplate.postForEntity( "http://notification:8080/notification/mock", mvm, String.class);

        return "successfully.";

    }

}
