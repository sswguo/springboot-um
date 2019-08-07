package com.lizard.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationController
{


    @Autowired
    JavaMailSender javaMailSender;

    @RequestMapping(method = RequestMethod.POST, value="/mock")
    @ResponseBody
    public String mockNotify( @RequestParam(name = "username") String username, @RequestParam(name="email") String email )
    {
        System.out.println( Thread.currentThread().getName() + " - [MOCK] Notification user:" + username );
        return "User: " + username;
    }

    @RequestMapping(method = RequestMethod.POST, value="/mail")
    public void mailNotify( @RequestParam(name = "username") String username, @RequestParam(name="email") String email )
    {
        System.out.println( Thread.currentThread().getName() + " - [EMAIL] Notification user:" + username );

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Register successfully for user: " + username);
        msg.setText("Hello: \n Welcome to the app.");

        javaMailSender.send(msg);
    }

}
