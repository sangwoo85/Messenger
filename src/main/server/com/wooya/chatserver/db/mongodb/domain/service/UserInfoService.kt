package com.wooya.chatserver.db.mongodb.domain.service

import com.wooya.chatserver.db.mongodb.domain.user.model.UserInfo
import com.wooya.chatserver.db.mongodb.domain.user.repo.UserInfoRepository
import org.springframework.stereotype.Service

@Service
class UserInfoService(private val userInfoRepository: UserInfoRepository) {

    fun createUserInfo(userInfo : UserInfo): UserInfo{
        return userInfoRepository.save(userInfo)
    }

    fun findAll() : List<UserInfo>{
        val sss = userInfoRepository.findAll();
        println(sss.toString())
        return userInfoRepository.findAll()
    }
    fun findByUserId(userId : String ): UserInfo?{
        return userInfoRepository.findByUserId(userId)
    }
}