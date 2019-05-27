package com.bridgelabz.designpattern.creational.singletone;

public class Lazy {
private static Lazy instance;
private Lazy() {}
public static Lazy getLazy() {
	if(instance==null)
	   instance=new Lazy();
	return instance;
}
public void message(String string)
{
    System.out.println(string+" : I am in Lazy initialiazation.");
}
}
