package cn.jayneo.open.service.ex;

/**
 * 邮箱重复异常
 */
public class EmailConflictException extends ServiceException{
    public EmailConflictException() {
        super();
    }

    public EmailConflictException(String message) {
        super(message);
    }

    public EmailConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailConflictException(Throwable cause) {
        super(cause);
    }

    protected EmailConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
