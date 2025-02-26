package com.wooya.chatserver.db.mongodb.domain.user;

import com.wooya.chatserver.db.mongodb.domain.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends MongoRepository<User,String> {

}
