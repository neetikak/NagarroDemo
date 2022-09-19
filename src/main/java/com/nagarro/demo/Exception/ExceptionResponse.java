package com.nagarro.demo.Exception;

public class ExceptionResponse {
String errorCode;
String errorMessage;
public ExceptionResponse(String errorCode, String errorMessage) {
	super();
	this.errorCode = errorCode;
	this.errorMessage = errorMessage;
}
public ExceptionResponse() {
	super();
	// TODO Auto-generated constructor stub
}
public String getErrorCode() {
	return errorCode;
}
public void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}
}
