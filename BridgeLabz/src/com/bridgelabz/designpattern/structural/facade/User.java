package com.bridgelabz.designpattern.structural.facade;

public class User {
	public static void main(String[] args) {
		ShapeFacade shape=new ShapeFacade();
		shape.drawRectangle();
		shape.drawTriangle();
		shape.drawSquare();
	}
}
