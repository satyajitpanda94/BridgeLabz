package com.bridgelabz.designpattern.creational.singletone;

public class BillPughSingleton {
private static class HelperBillPughSingleton{
	private static final BillPughSingleton instance=new BillPughSingleton();	
}
private BillPughSingleton() {}
public static BillPughSingleton getInstance()
{
	return HelperBillPughSingleton.instance;
}
public void message(String string)
{
	System.out.println(string+" : I am in Bill pugh Singleton.");
}
}
