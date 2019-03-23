package cn.tigers.commons.exception;

/**
 * 系统异常
 * @author Miao Weiwei
 * Created by tigershome on 2018/11/18.
 */
public class SysException extends Exception {

    /**
     * 系统错误码
     */
    private String errCode;

    /**
     * 错误描述
     */
    private String errMsg;

    public SysException() {
        super();
    }

    /**
     * we can use custom exception without looseing the root cause from which they occurred.
     * @param cause
     */
    public SysException(Throwable cause) {
        super(cause);
    }

    public SysException(String errMsg, Throwable cause) {
        super(errMsg, cause);
    }

    public SysException(String errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public SysException(String errCode, String errMsg, Throwable cause) {
        super(cause);
        this.errMsg = errMsg;
        this.errMsg = errMsg;
    }

    public String getErrCode() { return this.errCode; }

    public String getErrMsg() { return this.errMsg; }
}
