package com.bridgelabz.designpattern.creational.singletone;

public class ThreadSafeSingleton {
private static ThreadSafeSingleton instance;
private ThreadSafeSingleton() {}
public static ThreadSafeSingleton getInstance()
{
	synchronized (ThreadSafeSingleton.class) {
		instance=new ThreadSafeSingleton();
	}
	return instance;
}
public void message(String string)
{
	System.out.println(string+" : I am in ThreadSafe singleton.");
}
}
