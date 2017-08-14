package api.exception;

import java.io.Serializable;

/**
 * Created by wangtc on 2017/6/27.
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -6567890810362058918L;

    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public ServiceException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public ServiceException(ExceptionCode exceptionCode){
        super(exceptionCode.getErrorMsg());
        this.errorCode = exceptionCode.getErrorCode();
    }

    public ServiceException(String errorCode,String errorMsg,Throwable th){
        super(errorMsg,th);
        this.errorCode = errorCode;
    }
}
