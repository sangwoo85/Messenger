package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.db.mongodb.domain.user.model.User
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class LoginApiController {

    private val LOGGER = LoggerFactory.getLogger(LoginApiController::class.java)

    @PostMapping("/login")
    fun login(@RequestBody user : User): String {
        val mav = ModelAndView("jsonView");

        mav.addObject("result","true");
        return "success";
    }
}