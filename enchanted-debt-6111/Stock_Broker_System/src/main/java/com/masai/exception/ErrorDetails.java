package com.masai.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
private LocalDateTime timestamp;
private String msg;
private String details;

public LocalDateTime getTimestamp() {
	return timestamp;
}
public void setTimestamp(LocalDateTime timestamp) {
	this.timestamp = timestamp;
}
public String getMsg() {
	return msg;
}
public void setMsg(String msg) {
	this.msg = msg;
}
public String getDetails() {
	return details;
}
public void setDetails(String details) {
	this.details = details;
}
public ErrorDetails(LocalDateTime timestamp, String msg, String details) {
	super();
	this.timestamp = timestamp;
	this.msg = msg;
	this.details = details;
}
public ErrorDetails() {
	super();
}
@Override
public String toString() {
	return "ErrorDetails [timestamp=" + timestamp + ", msg=" + msg + ", details=" + details + "]";
}

}
