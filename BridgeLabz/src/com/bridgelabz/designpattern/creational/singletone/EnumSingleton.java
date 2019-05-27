package com.bridgelabz.designpattern.creational.singletone;

public enum EnumSingleton {
    INSTANCE;
public void message(String string) {
	System.out.println(string+" : I am in EnumSingleton.");
}
}
