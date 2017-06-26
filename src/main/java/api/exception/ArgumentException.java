package api.exception;

/**
 * Created by wangtc on 2017/6/26.
 */
public class ArgumentException extends RuntimeException{

    private static final long serialVersionUID = 8310868561985270035L;

    private String errorCode;

    public String getErrorCode(){
        return errorCode;
    }

    public ArgumentException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public ArgumentException(ExceptionCode exceptionCode){
        super(exceptionCode.getErrorMsg());
        this.errorCode = exceptionCode.getErrorCode();
    }

    public ArgumentException(String errorCode,String errorMsg,Throwable cause){
        super(errorMsg,cause);
        this.errorCode = errorCode;
    }


}
