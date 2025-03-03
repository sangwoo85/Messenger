package com.wooya.chatserver.login.api

import com.wooya.chatserver.login.dto.LoginDto
import com.wooya.chatserver.login.service.LoginService
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpSession
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginApiController(private val loginService: LoginService) {

    private val LOGGER = LoggerFactory.getLogger(LoginApiController::class.java)

    @PostMapping("/login")
    fun login(@RequestBody loginDto : LoginDto, request: HttpServletRequest) {
        LOGGER.info("START [ {} ]",loginDto.toString())
        loginService.login(loginDto);
        val session = request.getSession(true)
       // request.session.setAttribute("userId",loginDto.userId);
        session.setAttribute("userId", loginDto.userId)
        request.changeSessionId()
        LOGGER.info("END [ {} ]",loginDto.toString());
    }

}