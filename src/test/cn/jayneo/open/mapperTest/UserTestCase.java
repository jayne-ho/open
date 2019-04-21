package cn.jayneo.open.mapperTest;


import cn.jayneo.open.entity.UserEntity;
import cn.jayneo.open.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestCase {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findByEmail(){
        UserEntity byEmail = userMapper.findByEmail("1561629325@qq.com");
        System.out.println(byEmail);
    }

    @Test
    public void addNew(){
        UserEntity user = new UserEntity();
        user.setEmail("123@qq.com");
        user.setFirstName("jayne");
        user.setLastName("ho");
        user.setPassword("666");
        Integer addNew = userMapper.addNew(user);
        System.err.println(addNew);
    }


}
