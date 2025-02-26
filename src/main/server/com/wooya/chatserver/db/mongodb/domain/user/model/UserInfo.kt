package com.wooya.chatserver.db.mongodb.domain.user.model

import org.springframework.data.mongodb.core.mapping.Document


@Document(collection = "user")
data class UserInfo(
    val userId : String? = null,
    val name : String,
    var dept : String,
    var position : String,

)
