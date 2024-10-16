package com.credithaat.crm.util;

import java.util.List;
import java.util.Map;

import com.credithaat.crm.entity.hicredit.Apply;
import com.credithaat.crm.entity.hicredit.UserInfo;

public class ObjResponse<T> {
    private int code;
    private String msg;
    private T obj;
    private List<Map<T,T>> list;

    public static<T> ObjResponse<T> success(T obj){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(1);
        resp.setMsg("success");
        resp.setObj(obj);
        return resp;
    }

    public static<T> ObjResponse<T> success(T obj,String msg){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(1);
        resp.setMsg(msg);
        resp.setObj(obj);
        return resp;
    }

    public List<Map<T, T>> getList() {
		return list;
	}

	public void setList(List<Map<T, T>> list) {
		this.list = list;
	}

	public static<T> ObjResponse<T> fail(String msg){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(-1);
        resp.setMsg(msg);
        resp.setObj(null);
        return resp;
    }

    public static<T> ObjResponse<T> fail(T obj,String msg){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(-1);
        resp.setMsg(msg);
        resp.setObj(obj);
        return resp;
    }

    public static<T> ObjResponse<T> exception(String msg){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(-2);
        resp.setMsg(msg);
        resp.setObj(null);
        return resp;
    }

    public static<T> ObjResponse<T> exception(T obj,String msg){
        ObjResponse<T> resp = new ObjResponse<>();
        resp.setCode(-2);
        resp.setMsg(msg);
        resp.setObj(obj);
        return resp;
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

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

//	public void setObj(List<Map<T, T>> obj) {
//		// TODO Auto-generated method stub
//		this.obj = (T) obj;
//		
//	}
}

