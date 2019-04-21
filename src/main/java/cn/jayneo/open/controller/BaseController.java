package cn.jayneo.open.controller;

import cn.jayneo.open.service.ex.*;
import cn.jayneo.open.utils.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * 控制器类的基类
 */
public abstract class BaseController {

    /**
     * 处理请求时,用于表示操作正确的代码
     */
    public static final int SUCESS = 200;

    /**
     * 从当前登录中获取uid
     * @param session
     * @return
     */
    protected Integer getUidFromSession(HttpSession session){
        Object uid = session.getAttribute("uid");
        if (uid == null){
            return null;
        }
        return Integer.valueOf(uid.toString());
    }


    @ExceptionHandler(ServiceException.class)
    public ResponseResult<Void> handleException(Exception e){
        //声明返回的类型
        ResponseResult<Void> rr = new ResponseResult<>();
        //在返回对象中封装错误提示
        rr.setMassage(e.getMessage());
        //根据不同的异常返回不同的错误代码
        if (e instanceof UserNotFoundException){
            //400-用户不存在
            rr.setState(400);
        }else if (e instanceof EmailConflictException) {
            //401-用户已存在
            rr.setState(401);
        }else if (e instanceof PasswordNotMatchException) {
            //402-密码不匹配
            rr.setState(402);
        }else if (e instanceof InsertException) {
            //500-数据插入异常
            rr.setState(500);
        }
        return rr;
    }

}
