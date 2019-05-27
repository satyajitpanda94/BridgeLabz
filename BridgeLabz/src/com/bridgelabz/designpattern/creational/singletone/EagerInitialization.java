package com.bridgelabz.designpattern.creational.singletone;

public class EagerInitialization{
	private static final EagerInitialization instance=new EagerInitialization();
	private EagerInitialization() {}
	public static EagerInitialization getInstance()
	{
		return instance;
	}
	public void message(String string)
	{
		System.out.println(string+" : I am in eager initialization.");
	}
}