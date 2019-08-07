package com.lizard.demo.springbootum.service;

import com.lizard.demo.springbootum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository
                extends CrudRepository<User, Long>, JpaRepository<User, Long>
{

    @Query("FROM User WHERE active = true")
    List<User> getAllActiveUser();

    @Nullable
    @Query("FROM User WHERE email = ?1 and active =true")
    List<User> findUserByEmail( String email );

}
