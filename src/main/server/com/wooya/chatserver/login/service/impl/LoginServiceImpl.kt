package com.wooya.chatserver.login.service.impl

import com.wooya.chatserver.common.error.LoginErrorMessage
import com.wooya.chatserver.common.exception.LoginErrorException
import com.wooya.chatserver.db.mongodb.domain.service.UserService
import com.wooya.chatserver.login.dto.LoginDto
import com.wooya.chatserver.login.service.LoginService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import kotlin.jvm.Throws

@Service
class LoginServiceImpl(private val userService: UserService) : LoginService {

    val LOGGER = LoggerFactory.getLogger(LoginServiceImpl::class.java)

    override fun login(loginDto: LoginDto) {
        LOGGER.info("START [ {} ]",loginDto.toString())

        val userList  = userService.findAll();
        LOGGER.info("List  [ {} ]",userList.toString())

        val selectUser =  userService.findByUserId(loginDto.userId);

        if (selectUser === null) {
            throw LoginErrorException(LoginErrorMessage.USER_NOT_FINDING_ERROR)
        }

        if(selectUser.password  != loginDto.password){
            throw LoginErrorException(LoginErrorMessage.LOGIN_INPUT_ERROR)
        }

    }
}