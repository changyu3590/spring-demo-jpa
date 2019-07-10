package com.example.demo.dto;
import java.io.Serializable;
/**
 * @Author: ChangYu
 * @Version 1.0
 */
public class GeneralResponseDto implements Serializable {
	
	private int code;
	private String returnMsg;
	private Object data;
    private GeneralResponseDto(int code, String returnMsg, Object data) {
        super();
        this.code = code;
        this.returnMsg = returnMsg;
        this.data=data;
    }

	public  static GeneralResponseDto addSuccess(Object data,String role){
        return new GeneralResponseDto(1,role,data);
    }
    public  static GeneralResponseDto addSuccess(Object data){
        return new GeneralResponseDto(1,"success",data);
    }
    public  static GeneralResponseDto addSuccess(){
        return new GeneralResponseDto(1,"success",null);
    }
    public  static GeneralResponseDto addError(int code, String returnMsg){
        return new GeneralResponseDto(-1,returnMsg,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }


}
