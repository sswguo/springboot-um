package com.lizard.demo.springbootum.operation;

import com.lizard.demo.springbootum.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
                extends CrudRepository<User, Long> { }
