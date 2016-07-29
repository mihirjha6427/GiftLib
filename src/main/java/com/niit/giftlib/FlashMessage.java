package com.niit.giftlib;

public class FlashMessage {
private String message;
private Status status;




public FlashMessage(String message, Status status) {
	super();
	this.message = message;
	this.status = status;
}




public String getMessage() {
	return message;
}




public Status getStatus() {
	return status;
}




public static enum Status{
	SUCCESS,FAILURE
}
}
