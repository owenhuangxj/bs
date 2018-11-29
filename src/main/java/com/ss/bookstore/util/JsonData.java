package com.ss.bookstore.util;

import java.io.Serializable;

public class JsonData implements Serializable {
    private Object data;
    private String msg;
    private Boolean state;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                ", state=" + state +
                '}';
    }
    public JsonData(){}

    public JsonData(Object data, String msg, Boolean state) {
        this.data = data;
        this.msg = msg;
        this.state = state;
    }
}
