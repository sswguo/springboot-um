package com.lizard.notification.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController
{


    @RequestMapping(method = RequestMethod.POST, value="/mock")
    @ResponseBody
    public String mockNotify( @RequestParam(name = "username") String username )
    {
        return "User: " + username;
    }

    @RequestMapping(method = RequestMethod.POST, value="/mail")
    public void mailNotify( @RequestParam(name = "username") String username )
    {
        //TODO
    }

}
