package com.wooya.chatserver.db.mongodb.domain.user;

import com.wooya.chatserver.db.mongodb.domain.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getAll(){
        return userRepo.findAll();
    }
}
