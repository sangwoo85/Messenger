package com.wooya.chatserver.config.common

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.server.ServerHttpRequest
import org.springframework.http.server.ServerHttpResponse
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.HandshakeInterceptor
import java.util.*

class UserInterceptor : HandshakeInterceptor {

    final val LOGGER = LoggerFactory.getLogger(UserInterceptor::class.java)

    override fun beforeHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Boolean {
        if (request is org.springframework.http.server.ServletServerHttpRequest) {
            val servletRequest = request.servletRequest as HttpServletRequest
            val session = servletRequest.session
            //session.setAttribute("userId","ksswy")
            // HttpSession에서 userId 가져오기
            LOGGER.info(session.attributeNames.toList().toString())
            try {
                val userId = Optional.of(session.getAttribute("userId")).orElse("")
                attributes["userId"] = userId
            }catch(e : NullPointerException){
                LOGGER.error("",e)
            }
        }
        return true
    }

    override fun afterHandshake(
        request: ServerHttpRequest,
        response: ServerHttpResponse,
        wsHandler: WebSocketHandler,
        exception: Exception?
    ) {
        // 예외 처리 로그 추가 (구현하지 않으면 오류 발생 가능)
        if (exception != null) {
            println("WebSocket Handshake Error: ${exception.message}")
        }
    }


}