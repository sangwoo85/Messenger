package com.wooya.chatserver.db.mongodb.domain.user;

import com.wooya.chatserver.db.mongodb.domain.user.model.Position;
import com.wooya.chatserver.db.mongodb.domain.user.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wooya.chatserver.db.mongodb.domain.user.repo.PositionRepository;

import java.util.List;

@RestController
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    final private UserRepo userService;

    final private PositionRepository  positionRepository;

    public UserController(UserRepo userService ,PositionRepository  positionRepository){
        this.userService = userService;
        this.positionRepository =  positionRepository;
    }

    @GetMapping("/getAll")
    public List<User> getAll(){

        LOGGER.info("START");
        List<User>users = userService.findAll();
        List<Position>positionList = positionRepository.findAll();
        LOGGER.info("positionList {}  ",positionList.toArray());
        LOGGER.info("END  {} ",users.toArray());
        return users;
    }
}
