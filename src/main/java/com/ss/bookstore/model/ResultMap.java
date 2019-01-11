package com.ss.bookstore.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;
@Component
public class ResultMap extends HashMap<String, Object> {
    public ResultMap success() {
        this.put("result", "success");
        return this;
    }
    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }
    public ResultMap page(String page){
        this.put("page",page);
        return this;
    }
    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}

