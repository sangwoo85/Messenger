package com.wooya.chatserver.messenger.service.impl

import com.wooya.chatserver.common.util.HttpUtil
import com.wooya.chatserver.db.mongodb.domain.user.repo.ChatRoomRepository
import com.wooya.chatserver.db.mongodb.domain.user.repo.UserRepository
import com.wooya.chatserver.messenger.dto.ChatInfoDto
import com.wooya.chatserver.messenger.dto.ChatRoomDto
import com.wooya.chatserver.messenger.dto.ChatUserDto
import com.wooya.chatserver.messenger.dto.UserGroupDto
import com.wooya.chatserver.messenger.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
@Service
class UserServiceImpl(private val  userRepository: UserRepository
                        ,private val chatRoomRepository: ChatRoomRepository) : UserService {

    val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun getChatUserList() : ChatInfoDto{
        LOGGER.info("START")
        val loginId = HttpUtil.getLoginId()

        val userDeptList = userRepository.groupByDeplList();

        val roomList = chatRoomRepository.findByParticipants(loginId)

        val memberDto: List<UserGroupDto> = userDeptList.map { dept ->
            UserGroupDto(
                deptCode = dept._id,
                deptName = dept.deptName,
                memberList = dept.memberList.map { member ->
                    ChatUserDto(
                        userId = member.userId,
                        userName = member.name,
                        roomId = "",
                        comment = member.comment,
                        profileImg = member.profileImg
                    )
                }
            )
        }

        val roomListDto  = roomList.map { room ->  ChatRoomDto( roomId = room.roomId, lastMessageId = room.lastMessageId, createDate = room.createDate, participants = room.participants ) }
        val responeDto = ChatInfoDto(userGrouList = memberDto,
                                    chatRoomList = roomListDto);
        return responeDto;
    }


}