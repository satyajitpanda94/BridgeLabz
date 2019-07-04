package com.bridgelabz.designpattern.behavioral.observer;

public class Mobile1 implements Observers{
	private String message="Mobile1 : Not Updated";
	
	@Override
	public void update(String message) {
		this.message="Mobile1 : "+message;
	}
	
	public String getMessage()
	{
		return message;
	}
	
}
