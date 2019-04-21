package cn.jayneo.open.controller;

import cn.jayneo.open.entity.UserEntity;
import cn.jayneo.open.service.IUserService;
import cn.jayneo.open.utils.ResponseResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 处理用户请求控制器
 */

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 注册请求
     * @param user
     * @return
     */
    @RequestMapping("reg")
    public ResponseResult<Void> reg(UserEntity user){
        userService.reg(user);
        return new ResponseResult<>(SUCESS);
    }

    /**
     * 登录请求
     * @param email
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("login")
    public ResponseResult<UserEntity> login(@Param("email") String email, @Param("password") String password, HttpSession session){
        UserEntity user = userService.login(email, password);
        session.setAttribute("email", user.getEmail());
        session.setAttribute("uid", user.getUid());
        session.setAttribute("firstName", user.getFirstName());
        session.setAttribute("lastName", user.getLastName());
        return new ResponseResult<>(SUCESS,user);
    }

    @GetMapping("loginState")
    public ResponseResult<String> loginState(HttpSession session){
        Integer uid = getUidFromSession(session);
        if (uid != null){
            String firstName = session.getAttribute("firstName").toString();
            String lastName = session.getAttribute("lastName").toString();
            String name = firstName + " " + lastName;
            System.out.println(name);
            return new ResponseResult<>(SUCESS,name);
        }
        return new ResponseResult<>(300);
    }


}
