package api.exception;

/**
 * Created by wangtc on 2017/6/26.
 */
public class ExceptionCode {

    public static final ExceptionCode SYS_ERROR = new ExceptionCode("system_error","系统错误");
    public static final ExceptionCode DB_ERROR = new ExceptionCode("db_error","数据库错误");
    public static final ExceptionCode PARAM_ERROR = new ExceptionCode("param_error","参数异常");
    public static final ExceptionCode CONVERT_ERROR = new ExceptionCode("convert_error","转换异常");


    private String errorCode;

    private String errorMsg;

    public ExceptionCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
