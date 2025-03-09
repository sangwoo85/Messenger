package com.wooya.chatserver.db.mongodb.domain.user.repo

import com.wooya.chatserver.db.mongodb.domain.user.model.DeplGroupList
import com.wooya.chatserver.db.mongodb.domain.user.model.User
import org.springframework.data.mongodb.repository.Aggregation
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository :MongoRepository<User,String> {
    fun findByUserId(userId:String): User?

    @Aggregation(pipeline = [
        "{ '\$lookup': { 'from': 'Dept', 'localField': 'dept', 'foreignField': 'code', 'as': 'deptInfo' } }",
        "{ '\$unwind': '\$deptInfo' }",
        "{ '\$lookup': { 'from': 'Position', 'localField': 'position', 'foreignField': 'code', 'as': 'positionInfo' } }",
        "{ '\$unwind': '\$positionInfo' }",
        "{ '\$group': { '_id': '\$deptInfo.code', 'deptName':{ '\$first':'\$deptInfo.name'},  " +
                "'memberList': { " +
                "   '\$push': { 'userId': '\$userId', 'name': '\$name', 'position': '\$positionInfo.name', 'comment': '\$comment', 'profileImg': '\$profileImg' " +
                                "} " +
                                "} " +
                    "} " +
          "}"
    ])
    fun groupByDeplList():List<DeplGroupList>
}


