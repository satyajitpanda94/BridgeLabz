package com.bridgelabz.designpattern.creational.singletone;

public class User {
	public static void main(String[] args) throws CloneNotSupportedException {
	EagerInitialization eager=EagerInitialization.getInstance();
	eager.message("eager");
	
	StaticBlockInitialization stat=StaticBlockInitialization.getInstance();
	stat.message("stat");
	
	Lazy lazy=Lazy.getLazy();
	lazy.message("lazy");
	
	ThreadSafeSingleton threadSafe=ThreadSafeSingleton.getInstance();
	threadSafe.message("threadSafe");
	
	BillPughSingleton biilPugh=BillPughSingleton.getInstance();
	biilPugh.message("biilPugh");

	EnumSingleton enumSingleton=EnumSingleton.INSTANCE;
	enumSingleton.message("enumSingleton");
	}
}
