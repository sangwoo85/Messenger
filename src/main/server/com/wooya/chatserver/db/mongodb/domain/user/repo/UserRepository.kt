package com.wooya.chatserver.db.mongodb.domain.user.repo

import com.wooya.chatserver.db.mongodb.domain.user.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository :MongoRepository<User,String> {
    fun findByUserId(userId:String): User?
}


