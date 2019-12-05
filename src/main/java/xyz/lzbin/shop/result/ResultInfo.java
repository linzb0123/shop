package xyz.lzbin.shop.result;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lzb
 * 2019/12/4
 * @Description: 返回json数据
 */
public class ResultInfo {

    public static final int SUCCESS = 200;
    public static final int FAIL = 1;

    /**
     * data
     */
    private Map<String, Object> data;

    /**
     * 操作信息
     */
    private String msg;

    /**
     * 操作是否成功等标识
     */
    private int code;


    /**
     * 转成json后为 {"msg":msg,"code":code, "content":{}}
     */
    public static ResultInfo success() {
        // 默认设置操作成功
        ResultInfo resultInfo = getInstance(SUCCESS);
        return resultInfo;
    }

    public static ResultInfo success(String msg) {
        // 默认设置操作成功
        ResultInfo resultInfo = getInstance(msg, SUCCESS);
        return resultInfo;
    }

    public static ResultInfo fail() {
        // 默认设置操作成功
        ResultInfo resultInfo = getInstance(FAIL);
        return resultInfo;
    }

    public static ResultInfo fail(String msg) {
        // 默认设置操作成功
        ResultInfo resultInfo = getInstance(msg, FAIL);
        return resultInfo;
    }

    /**
     * 转成json后为 {"msg":msg,"code":code, "content":{}}
     */
    public static ResultInfo getInstance(String msg, int code) {
        return new ResultInfo(msg, code);
    }

    public static ResultInfo getInstance(int code) {
        return new ResultInfo(code);
    }

    public ResultInfo data(String key, Object o) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(key, o);
        return this;
    }

    public ResultInfo data(Object o) {
        if (data == null) {
            data = new HashMap<>();
        }
        data.put(getClassLowerSimpleName(o), o);
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String,Object> getData(){
        return this.data;
    }

    public String toString() {
        JSONObject jsonObject1 = (JSONObject) JSONObject.toJSON(this);
        return jsonObject1.toString();
    }

    private ResultInfo(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    private ResultInfo(int code) {
        this.code = code;
    }


    private static String getClassLowerSimpleName(Object obj) {
        String name = obj.getClass().getSimpleName();
        return Character.toLowerCase(name.charAt(0)) + name.substring(1, name.length());
    }
}
