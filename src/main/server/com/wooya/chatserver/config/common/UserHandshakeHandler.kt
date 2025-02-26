package com.wooya.chatserver.config.common

import org.springframework.http.server.ServerHttpRequest
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.DefaultHandshakeHandler
import java.security.Principal

class UserHandshakeHandler :DefaultHandshakeHandler() {

    override fun determineUser(
        request: ServerHttpRequest,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Principal {
        val userId = attributes["userId"] as? String ?: "anonymous"
        return Principal { userId }
    }
}