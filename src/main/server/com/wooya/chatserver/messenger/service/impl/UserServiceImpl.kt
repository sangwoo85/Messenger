package com.wooya.chatserver.messenger.service.impl

import com.wooya.chatserver.common.util.HttpUtil
import com.wooya.chatserver.db.mongodb.domain.user.repo.ChatRoomRepository
import com.wooya.chatserver.db.mongodb.domain.user.repo.UserRepository
import com.wooya.chatserver.messenger.dto.ChatInfoDto
import com.wooya.chatserver.messenger.dto.ChatUserDto
import com.wooya.chatserver.messenger.dto.UserGroupDto
import com.wooya.chatserver.messenger.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val  userRepository: UserRepository
                        ,private val chatRoomRepository: ChatRoomRepository) : UserService {

    val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)

    fun getChatUserList() : ChatInfoDto{
        LOGGER.info("START")
        val loginId = HttpUtil.getLoginId()

        val userDeptList = userRepository.groupByDeplList();

        val roomList = chatRoomRepository.findByParticipants(loginId)


        val memberDto = userDeptList.map { dept -> { UserGroupDto(dept._id
                                                                ,dept.deptName
                                                                ,dept.memberList.stream().map {
                                                                                                                        e -> ChatUserDto(e.userId,e.name,"",e.comment,e.profileImg)
                                                                                                                            }.toList())}
                                                            }


        val responeDto = ChatInfoDto(memberDto,null);

        return null;
    }


}