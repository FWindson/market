package com.market.vo;

public class PageDataModel {
	
	public static int SUCCESS = 200;
	public static int FAILED = 400;

	private int status;
	private String message;
	private int totalPage;
	private Object result;

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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public static PageDataModel buildSuccess(int totalPage,Object list) {
		PageDataModel pageDataModel = new PageDataModel();
		pageDataModel.status = SUCCESS;
		pageDataModel.setTotalPage(totalPage);
		pageDataModel.setResult(list);
		return pageDataModel;
	}
	
	public static PageDataModel buildFailed(String message) {
		PageDataModel pageDataModel = new PageDataModel();
		pageDataModel.status = FAILED;
		pageDataModel.setMessage(message);
		return pageDataModel;
	}
	
}
