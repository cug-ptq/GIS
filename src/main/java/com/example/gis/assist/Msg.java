package com.example.gis.assist;

import java.util.HashMap;
import java.util.Map;

public class Msg {
    private int code;
    private String msg;
    private Map<String, Object> map = new HashMap<>();

    public static Msg success(){
        Msg msg = new Msg();
        msg.setCode(1);
        msg.setMsg("成功");
        return msg;
    }

    public static Msg error(){
        Msg msg = new Msg();
        msg.setCode(-1);
        msg.setMsg("邮箱或密码错误");
        return msg;
    }
    public Msg add(String key,Object value) {
        map.put(key, value);
        return this;
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
    public Map<String, Object> getMap() {
        return map;
    }
    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

}
