package com.lizard.demo.springbootum.service;

import com.lizard.demo.springbootum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class UserService
{

    @Autowired
    UserRepository repo;

    private final RestTemplate restTemplate;

    public UserService( RestTemplateBuilder restTemplateBuilder )
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<ResponseEntity> addUser( User user)
    {
        repo.save(user);

        MultiValueMap<String, String> mvm = new LinkedMultiValueMap<String, String>();
        mvm.add("username", user.getName());
        mvm.add("email", user.getEmail());

        ResponseEntity<String>
                        result = restTemplate.postForEntity( "http://notification:8080/notification/mail", mvm, String.class);

        return CompletableFuture.completedFuture( result );
    }

    public CompletableFuture<ResponseEntity> updateUser( User user )
    {
        List<User> users = repo.findUserByEmail( user.getEmail() );
        if ( users.size() > 0 )
        {
            User temp = users.get( 0 );
            temp.setName( user.getName() );
            temp.setActive( user.getActive() );
            repo.save( temp );
        }

        return null;
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>(  );
        repo.getAllActiveUser().forEach( user -> {
            users.add( user );
        } );
        return users;
    }

}
