package cn.jayneo.open.service;

import cn.jayneo.open.entity.UserEntity;
import cn.jayneo.open.service.ex.EmailConflictException;
import cn.jayneo.open.service.ex.InsertException;
import cn.jayneo.open.service.ex.PasswordNotMatchException;
import cn.jayneo.open.service.ex.UserNotFoundException;

/**
 * 用户处理业务层接口
 */
public interface IUserService {


    /**
     * 用户注册业务
     * @param user 用户数据
     */
    void reg(UserEntity user) throws InsertException,EmailConflictException;

    /**
     * 用户登录
     * @param Email 用户邮箱
     * @param password 用户密码
     */
    UserEntity login(String Email, String password) throws UserNotFoundException, PasswordNotMatchException;

}
