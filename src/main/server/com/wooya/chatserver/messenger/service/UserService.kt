package com.wooya.chatserver.messenger.service

import com.wooya.chatserver.messenger.dto.ChatInfoDto

interface UserService {
    fun getChatUserList() : ChatInfoDto
}