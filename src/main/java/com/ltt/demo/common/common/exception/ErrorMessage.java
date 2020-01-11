package com.ltt.demo.common.common.exception;




import com.ltt.demo.common.common.bean.Result;

import java.io.Serializable;

/**
 * 系统异常通用返回结构
 */
public class ErrorMessage<T> extends Result<T> implements Serializable {

	private static final long serialVersionUID = 2092911638692333548L;
	/**
	 * Http状态码
	 */
	private int statusCode;
	/**
	 * 错误代码
	 */
	private int errorCode;

	/**
	 * 无参构造
	 */
	public ErrorMessage() {}

	/**
	 * 有参构造器
	 *
	 * @param statusCode http状态码
	 * @param errorCode  异常代码
	 * @param message    错误描述
	 */
	public ErrorMessage(int statusCode, int errorCode, String message) {
		this.statusCode = statusCode;
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", message=" + message + "]" + super.toString();
	}

}
