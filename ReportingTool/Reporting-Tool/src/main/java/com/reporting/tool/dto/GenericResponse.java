package com.reporting.tool.dto;

public class GenericResponse {

	private MessageDto data = null;
	private Integer statusCode;
	private boolean success = false;
	private String message = null;
	private long timestamp = 0L;
	private String error;

	public GenericResponse() {
	}

	public GenericResponse(MessageDto data, Integer statusCode) {
		this.data = data;
		this.statusCode = statusCode;
	}

	public GenericResponse(MessageDto data, Integer status, String message) {
		this.data = data;
		this.statusCode = status;
		this.message = message;
	}

	public MessageDto getData() {
		return this.data;
	}

	public void setData(MessageDto messageDto) {
		this.data = messageDto;
	}

	public Integer getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "GenericResponse{" + "data=" + data + ", statusCode=" + statusCode + ", success=" + success
				+ ", message='" + message + '\'' + ", timestamp=" + timestamp + ", error='" + error + '\'' + '}';
	}
}
