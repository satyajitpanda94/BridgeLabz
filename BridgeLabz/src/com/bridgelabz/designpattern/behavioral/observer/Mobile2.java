package com.bridgelabz.designpattern.behavioral.observer;

public class Mobile2 implements Observers {
private String message="Mobile2 : Not Updated";
	
    @Override
	public void update(String message) {
		this.message="Mobile2 : "+message;
	}
	
	public String getMessage()
	{
		return message;
	}
}
