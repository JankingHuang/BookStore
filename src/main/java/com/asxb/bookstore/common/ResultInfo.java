package com.asxb.bookstore.common;

import java.io.Serializable;

/**
 * 结果集模板
 * @author 刘斌
 * @date 2021/6/25 19:01
 */
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = -1293910535713654759L;
    private String msg; // 返回的提示信息
    private int code; // 响应码
    private T data; // 返回的具体数据
    private String now;

    public ResultInfo() {
    }

    public ResultInfo(String msg, int code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getNow() {
        return now;
    }

    public void setNow(String now) {
        this.now = now;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                ", time=" + now +
                '}';
    }
}
