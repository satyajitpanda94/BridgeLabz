package com.bridgelabz.designpattern.creational.factory;

public class User {
public static void main(String[] args) {
	Computer hp=FactoryClass.getComputer("hp", "8 GB", "1 TB");
	Computer lenovo=FactoryClass.getComputer("lenovo", "8 GB", "2 TB");
	
	System.out.println("HP : "+hp);
	System.out.println("Lenovo : "+lenovo);
}
}
