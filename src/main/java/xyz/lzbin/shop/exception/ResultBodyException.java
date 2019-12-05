package xyz.lzbin.shop.exception;

/**
 * @author lzb
 * 2019/12/5
 */
public class ResultBodyException extends RuntimeException {

    private int code;
    private String msg;

    public ResultBodyException() {
        super();
    }

    public ResultBodyException(int code) {
        this.code = code;
    }

    public ResultBodyException(String msg) {
        this.msg = msg;
    }

    public ResultBodyException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
