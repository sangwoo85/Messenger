package com.wooya.chatserver.messenger.dto

import com.wooya.chatserver.db.mongodb.domain.user.model.User
import org.bson.types.Code

data class UserGroupDto(

   //dept code
   var deptCode: String,
   // 부서 이름
   val deptName: String,
   //부서안의 사용자 List
   val memberList: List<ChatUserDto>


)
