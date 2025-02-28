package com.wooya.chatserver.db.mongodb.domain.service

import com.wooya.chatserver.db.mongodb.domain.user.model.User
import com.wooya.chatserver.db.mongodb.domain.user.repo.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUserInfo(userInfo : User): User{
        return userRepository.save(userInfo)
    }

    fun findAll() : List<User>{
        val sss = userRepository.findAll();
        println(sss.toString())
        return userRepository.findAll()
    }
    fun findByUserId(userId : String ): User?{
        return userRepository.findByUserId(userId)
    }
}