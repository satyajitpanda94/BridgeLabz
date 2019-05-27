package com.bridgelabz.designpattern.creational.singletone;


public class StaticBlockInitialization {
private static StaticBlockInitialization instance;
static {
	try {
		instance=new StaticBlockInitialization();
	}
	catch(Exception e){
		throw new RuntimeException("Exception occured in creating instance.");
	}
}
private StaticBlockInitialization() {}
public static StaticBlockInitialization getInstance() {
	return instance;
}
public void message(String string)
{
	System.out.println(string+" : I am in static block initialization.");
}
}
