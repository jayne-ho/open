package cn.jayneo.open.service;

import cn.jayneo.open.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTastCase {

    @Autowired
    private IUserService userService;

    @Test
    public void reg(){
        try {
            UserEntity user = new UserEntity();
            user.setPassword("1234");
            user.setEmail("666@qq.com");
            user.setFirstName("jayne1");
            user.setLastName("ho");
            userService.reg(user);
            System.err.println("注册成功!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void login(){
        try {
            UserEntity login = userService.login("666@qq.com", "1234");
            System.err.println(login);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
    }

}
