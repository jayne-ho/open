package cn.jayneo.open.utils;

import java.io.Serializable;

/**
 * 响应结果类型
 * @param <T> 服务器向客户端响应的数据的类型
 */
public class ResponseResult<T> implements Serializable {
    private Integer state;//状态码
    private String message;
    private T data;

    public ResponseResult() {
    }

    public ResponseResult(Integer state) {
        this.state = state;
    }

    public ResponseResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    public ResponseResult(Integer state, Exception e) {
        this.state = state;
        this.message = e.getMessage();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMassage() {
        return message;
    }

    public void setMassage(String massage) {
        this.message = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
