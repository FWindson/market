package com.market.vo;

/**
 * Api接口请求结果类
 * 
 * @author asus
 *
 */
public class ResponseModel {

	public final static int SUCCESS = 200;
	public final static int FAILED = 400;

	private int status;
	private String message;
	private Object result;

	public ResponseModel(int status, String message, Object result) {
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public static int getSuccess() {
		return SUCCESS;
	}

	public static int getFailed() {
		return FAILED;
	}

	public static ResponseModel buildSuccess(Object data) {
		return new ResponseModel(SUCCESS, "", data);
	}

	public static ResponseModel buildFailed(String message) {
		return new ResponseModel(FAILED, message, null);
	}

}
