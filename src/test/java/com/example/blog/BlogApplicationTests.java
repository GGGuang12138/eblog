package com.example.blog;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Autowired(required=true)
    UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.getById(1);
        System.out.println(user.toString());
    }

}
