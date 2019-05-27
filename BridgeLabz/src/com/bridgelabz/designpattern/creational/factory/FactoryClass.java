package com.bridgelabz.designpattern.creational.factory;

public class FactoryClass {
public static Computer getComputer(String type,String ram,String hardDisk)
{
	if("hp".equalsIgnoreCase(type))
		return new Hp(ram, hardDisk);
	else if("lenovo".equalsIgnoreCase(type))
		return new Lenovo(ram, hardDisk);
	else
		return null;
}
}
