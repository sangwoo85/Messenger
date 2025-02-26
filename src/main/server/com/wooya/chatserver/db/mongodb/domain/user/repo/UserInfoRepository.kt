package com.wooya.chatserver.db.mongodb.domain.user.repo

import com.wooya.chatserver.db.mongodb.domain.user.model.UserInfo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserInfoRepository :MongoRepository<UserInfo,String> {
    fun findByUserId(userId:String): UserInfo?
}


