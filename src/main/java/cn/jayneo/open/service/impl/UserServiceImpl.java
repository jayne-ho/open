package cn.jayneo.open.service.impl;

import cn.jayneo.open.entity.UserEntity;
import cn.jayneo.open.mapper.UserMapper;
import cn.jayneo.open.service.IUserService;
import cn.jayneo.open.service.ex.EmailConflictException;
import cn.jayneo.open.service.ex.InsertException;
import cn.jayneo.open.service.ex.PasswordNotMatchException;
import cn.jayneo.open.service.ex.UserNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.UUID;
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据email查询用户数据
     * @param Email 用户邮箱
     * @return 匹配的用户数据
     */
    private UserEntity findByEmail(String Email){
        return userMapper.findByEmail(Email);
    }

    /**
     * 插入数据
     * @param user
     */
    private void addNew(UserEntity user){
        Integer rows = userMapper.addNew(user);
        if (rows != 1){
            throw new InsertException("注册失败!请稍后重试");
        }
    }

    /**
     * 使用md5摘要进行对传入数据进行加密
     * @param password 要加密的数据
     * @param salt 盐值
     * @return 加密后数据
     */
    private String getMd5Password(String password, String salt){
        String str = salt + password;
        for (int i = 0; i < 5; i++) {
            str = DigestUtils.md5DigestAsHex(str.getBytes()).toString();
        }
        return str;
    }

    /**
     * 用户注册
     * @param user 用户数据
     * @throws InsertException
     * @throws EmailConflictException
     */
    @Override
    public void reg(UserEntity user) throws InsertException, EmailConflictException {
        //根据user.getEmail查询匹配的用户数据
        String email = user.getEmail();
        UserEntity data = findByEmail(email);
        //判断用户数据是否存在
        if (data == null){
            //不存在则执行用户插入
            //密码加密并封装
            String salt = UUID.randomUUID().toString();
            String md5Password = getMd5Password(user.getPassword(), salt);
            user.setPassword(md5Password);
            //封装盐值
            user.setSalt(salt);
            //封装isDelete
            user.setIsDelete(0);
            //执行插入数据
            addNew(user);

        }else {
            //是则抛出用户已存在异常
            throw new EmailConflictException("该邮箱已被注册!");
        }




    }

    /**
     * 用户登录
     * @param Email 用户邮箱
     * @param password 用户密码
     * @throws UserNotFoundException
     * @throws PasswordNotMatchException
     */
    @Override
    public UserEntity login(String Email, String password) throws UserNotFoundException, PasswordNotMatchException {
        //根据email从数据库中查询匹配的数据
        UserEntity data = findByEmail(Email);
        //判断是否有匹配的数据
        if (data == null){
            //否则抛出用户不存在异常
            throw new UserNotFoundException("用户不存在!");
        }

        //是则判断isDelete是否为1,是抛出用户不存在异常
        if (1 == data.getIsDelete()){
            throw new UserNotFoundException("用户不存在!");
        }

        //否则把参数中的password通过查询出来的结果加上盐值进行加密
        String salt = data.getSalt();
        String newPassword = getMd5Password(password, salt);
        //匹配加密后的密码和查询出来的密码是否相同
        if (!newPassword.equals(data.getPassword())){
            //不同则抛出密码不匹配异常
            throw new PasswordNotMatchException("您输入的密码有误!");
        }
        //相同则将密码和盐值设为null再返回数据
        data.setPassword(null);
        data.setSalt(null);
        return data;
    }
}
