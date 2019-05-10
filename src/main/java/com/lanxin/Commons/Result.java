package com.lanxin.Commons;

import java.io.Serializable;

/**
 * Created by fjw on 2019/5/9.
 */
public class Result  implements Serializable{

    private int code;

    private String msg;

    private Object data;

    public Result(){

    }
    public Result(int code,String msg,Object data){
       super();
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public static Result ok(){
          return  new Result(200,"successs",null);
    }

    public static Result ok(Object data){
        return  new Result(200,"successs",data);
    }

    public static Result faild(){
        return  new Result(500,"内部异常",null);
    }

    public static Result faild(int  code,String msg,Object data){
        return  new Result(code,msg,data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
