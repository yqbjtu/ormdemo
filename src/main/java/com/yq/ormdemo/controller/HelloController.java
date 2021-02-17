package com.yq.ormdemo.controller;

/**
 * Created by EricYang on 2021/2/12.
 */


import com.yq.ormdemo.domain.User;
import com.yq.ormdemo.domain.query.QUser;
import com.yq.ormdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        User user =
                new QUser()                                // Contact query bean
                        .username.equalTo("abc")               // type safe expression
                        .findOne();
        log.info("user {}", user);
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/user")
    public User userFind() {
        User user = userService.getById(1);

        log.info("user {}", user);
        return user;
    }
}