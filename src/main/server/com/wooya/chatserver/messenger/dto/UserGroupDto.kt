package com.wooya.chatserver.messenger.dto

import com.wooya.chatserver.db.mongodb.domain.user.model.User

data class UserGroupDto(

   //dept code
   var _id: String,
   // 부서 이름
   val deptName: String,
   //부서안의 사용자 List
   val memberList: List<ChatUserDto>


)
