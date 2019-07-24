package com.bridgelabz.Demoq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


public class Bike implements Vehicle{
	private java.util.List<Object> l;

	
	public void setL(java.util.List<Object> l) {
		this.l = l;
	}


	public void run() {
		// TODO Auto-generated method stub
		System.out.println(l);
		System.out.println(l.get(0));
		System.out.println("Bike is running...");
	}

}
