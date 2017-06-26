package api.exception;

/**
 * Created by wangtc on 2017/6/26.
 */
public class RepositoryException extends RuntimeException {
    private static final long serialVersionUID = -5561371933463622035L;

    private String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public RepositoryException(String errorCode,String errorMsg){
        super(errorMsg);
        this.errorCode = errorCode;
    }

    public RepositoryException(ExceptionCode exceptionCode){
        super(exceptionCode.getErrorMsg());
        this.errorCode = exceptionCode.getErrorCode();
    }

    public RepositoryException(String errorCode,String errorMsg,Throwable cause){
        super(errorMsg,cause);
        this.errorCode = errorCode;
    }
}
