package com.safe.web1.service;

import com.safe.web1.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    void isExist() {
        System.out.println(userService.isExist("root"));
    }

    @Test
    void getByName() {
        System.out.println(userService.getByName("root"));
    }

    @Test
    void get() {
        System.out.println( userService.get("root","123"));

    }

    @Test
    void add() {
        User user = new User("admin","123");
        userService.add(user);
    }
}
