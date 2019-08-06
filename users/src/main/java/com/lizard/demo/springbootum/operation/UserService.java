package com.lizard.demo.springbootum.operation;

import com.lizard.demo.springbootum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService
{

    @Autowired
    UserRepository repo;

    public void addUser(User user)
    {
        repo.save(user);
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>(  );
        repo.findAll().forEach( user -> {
            users.add( user );
        } );
        return users;
    }

}
