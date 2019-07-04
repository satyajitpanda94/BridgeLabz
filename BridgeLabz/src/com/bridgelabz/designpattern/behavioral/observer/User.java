package com.bridgelabz.designpattern.behavioral.observer;

public class User {
public static void main(String[] args) {
	Subject subject=new Subject();
	Observers observers1=new Mobile1();
	Observers observers2=new Mobile2();
	System.out.println(observers1.getMessage());
	System.out.println(observers2.getMessage());
	subject.attach(observers1);
	subject.attach(observers2);
	System.out.println("Update Subject.");
	subject.setMessage("Updated Message.");
	System.out.println(observers1.getMessage());
	System.out.println(observers2.getMessage());
}
}
