package com.bridgelabz.designpattern.behavioral.visitor;

public class User {
	public static void main(String[] args) {

	      ComputerPart computer = new Computer();
	      computer.accept(new ComputerPartDisplayVisitor());
	   }
	}