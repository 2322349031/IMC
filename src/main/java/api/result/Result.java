package api.result;

import java.io.Serializable;

/**
 * Created by wangtc on 2017/6/26.
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -8345783591775974825L;
    private boolean success = false;

    private T value;

    private String errorMsg;

    private String errorCode;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        success = false;
        this.errorCode = errorCode;
    }


}
