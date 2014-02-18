/**
 * 
 */
package com.monitor.app.result;

/**
 * @author Administrator
 * 
 */
public class ServiceResult {

	private boolean success;
	private String msg;
	private String code;
	private Object module;

	public ServiceResult(boolean success){
		this.success = success;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getModule() {
		return module;
	}

	public void setModule(Object module) {
		this.module = module;
	}

}
