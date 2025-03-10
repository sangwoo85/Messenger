package com.wooya.chatserver.messenger.service.impl

import com.wooya.chatserver.common.util.HttpUtil
import com.wooya.chatserver.db.mongodb.domain.user.repo.ChatRoomRepository
import com.wooya.chatserver.db.mongodb.domain.user.repo.MessageRepository
import com.wooya.chatserver.messenger.dto.ChatMessage
import com.wooya.chatserver.messenger.dto.ChatRoomDto
import com.wooya.chatserver.messenger.service.MessengerService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.util.CollectionUtils
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes


@Service
class MessengerServiceImpl(private val roomRepository: ChatRoomRepository,
                           private val messageRepository: MessageRepository) : MessengerService {

    private val LOGGER = LoggerFactory.getLogger(MessengerServiceImpl::class.java)

    /**
     * @title 사용자를 클릭 했을때 대화방을 가져 오고
     * 만일 첫 대화일 경우 1:1 방을 만들어 줄까 아니면.... 첫 대화 했을때 만들어 줄까 고민중.....
     * */
    override fun getUserClickChatRoom(chatRoom : ChatRoomDto):List<ChatMessage>?{
        LOGGER.info("START [ {} ]",chatRoom.toString())

        /*
        * 우선은 null 체크 후
        *
        * 1. chatroomId가 있는지 여부 확인 chatRoomId가 있으면  바로 ChatRoomId로 메시지를 조회 해서 가져 오도록
        * 2. chatRoomtId가 없는 경우에는 첫 대화이기때문에
        *
        * */
        if(CollectionUtils.isEmpty(chatRoom.participants)){
            return null
        }
        if(!chatRoom.roomId.isEmpty()){

        }
        val servletRequest =  (RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?)!!.request

        val loginId = HttpUtil.getLoginId();
        /*
        val chatRoom =  roomRepository.findByChatRoomId(loginId)

        val messageList = messageRepository.findByRoomId(chatRoom.r);

       val messageDtoList =  messageList.map { messageModel ->  ChatMessage(messageModel.value
                                                        , messageModel.sender
                                                        , messageModel.date
                                                        , messageModel.type
                                                        , messageModel.messageId
                                                        )   }
*/
        LOGGER.info("END [ {} ]",chatRoom.toString())
        return null;
    }

}