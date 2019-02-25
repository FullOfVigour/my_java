package cn.libra.utils.util.exception;

public class ControllerException extends RuntimeException {//getMessage(;



    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Throwable getErrorCause() {
        return errorCause;
    }

    public void setErrorCause(Throwable errorCause) {
        this.errorCause = errorCause;
    }

    private static final long serialVersionUID = -9171287832448832971L;

    protected String errorMsg; // 错误信息(For debug)
    protected Throwable errorCause = null; // 错误发生原因(原始Exception)
    protected Integer errorCost = 500; // 错误发生原因(原始Exception)

    public ControllerException(Throwable e, String errorMsg) {
        super(500+"_"+errorMsg);
        this.errorMsg = errorMsg;
        this.errorCause = e;
        this.errorCost = 500;
    }

    public ControllerException(String errorMsg) {
        super(500+"_"+errorMsg);
        this.errorMsg = errorMsg;
        this.errorCost = 500;
    }

    public ControllerException(Integer errorCost,String errorMsg) {
        super(errorCost+"_"+errorMsg);
        this.errorMsg = errorMsg;
        this.errorCost = errorCost;
    }

}


