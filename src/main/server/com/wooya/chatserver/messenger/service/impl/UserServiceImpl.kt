package com.wooya.chatserver.messenger.service.impl

import com.wooya.chatserver.common.util.HttpUtil
import com.wooya.chatserver.db.mongodb.domain.user.model.User
import com.wooya.chatserver.db.mongodb.domain.user.repo.ChatRoomRepository
import com.wooya.chatserver.db.mongodb.domain.user.repo.MessageRepository
import com.wooya.chatserver.db.mongodb.domain.user.repo.UserRepository
import com.wooya.chatserver.messenger.dto.ChatUserDto
import com.wooya.chatserver.messenger.dto.UserGroup
import com.wooya.chatserver.messenger.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val  userRepository: UserRepository
                        ,private val chatRoomRepository: ChatRoomRepository) : UserService {

    val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)

    fun getChatUserList() : UserGroup{
        LOGGER.info("START")
        val loginId = HttpUtil.getLoginId()

        val userList = userRepository.groupByDeplList();

        val roomList = chatRoomRepository.findByParticipants(loginId)


        return null;
    }


}