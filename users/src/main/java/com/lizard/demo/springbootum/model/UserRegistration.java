package com.lizard.demo.springbootum.model;

import java.util.ArrayList;
import java.util.List;

public class UserRegistration
{

    private List<User> users;

    private static UserRegistration userRegistration;

    private UserRegistration()
    {
        users = new ArrayList<>(  );
    }

    public static UserRegistration getInstance()
    {
        if ( userRegistration == null )
        {
            userRegistration = new UserRegistration();
            return userRegistration;
        }
        else
        {
            return userRegistration;
        }
    }

    public void add(User user)
    {
        users.add( user );
    }

    public List<User> getUsers()
    {
        return users;
    }
}
