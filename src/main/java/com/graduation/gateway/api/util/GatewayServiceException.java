

package com.graduation.gateway.api.util;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

/**
 * @author: mmy
 * @date: 2018/12/14
 * @description: gateway服务异常
 */
public class GatewayServiceException extends Exception {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -9085646291636250231L;
	/**
	 * 异常描述时用到的格式化参数
	 */
	public Object[] params;
	/**
	 * 异常编号
	 */
	private String errorCode;
	/**
	 * 用户自定义异常描述信息
	 */
	private List<String> errorMessages;
	private int status;
	/**
	 * 额外信息,前端用
	 */
	private Object additional;

	public GatewayServiceException() {
	}

	public GatewayServiceException(Exception ex) {
		super(ex);
	}

	public GatewayServiceException(String errorCode, String errorMessage) {
		this(errorCode, errorMessage, -1);
	}

	public GatewayServiceException(String errorCode, List<String> errorMessages) {
		this(errorCode, errorMessages, -1, null, null);
	}

	public GatewayServiceException(String errorCode, String errorMessage, Object[] params) {
		this(errorCode, errorMessage, -1, params);
	}

	public GatewayServiceException(String errorCode, String errorMessage, int status) {
		this(errorCode, Arrays.asList(errorMessage), -1, null, null);
	}

	public GatewayServiceException(String errorCode, String errorMessage, int status, Object[] params) {
		this(errorCode, Arrays.asList(String.format(errorMessage, params)), -1, params, null);
	}

	public GatewayServiceException(String errorCode, String errorMessage, Object[] params, Object additional) {
		this(errorCode, Arrays.asList(String.format(errorMessage, params)), -1, params, additional);
	}

	public GatewayServiceException(String errorCode, String errorMessage, Object additional) {
		this(errorCode, Arrays.asList(errorMessage), -1, null, additional);
	}

	public GatewayServiceException(String errorCode, List<String> errorMessages, int status, Object[] params,
			Object additional) {
		this.errorCode = errorCode;
		this.errorMessages = errorMessages;
		this.status = status;
		this.params = params;
		this.additional = additional;
		if (StringUtils.isBlank(this.errorCode)) {
			this.errorCode = getClass().getSimpleName();
		}
	}

	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append("ErrorCode: " + errorCode);
		sb.append(", ErrorMessages: " + errorMessages);
		sb.append(", Status: " + status);
		return sb.toString();
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public List<String> getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Object getAdditional() {
		return additional;
	}

	public void setAdditional(Object additional) {
		this.additional = additional;
	}


}
