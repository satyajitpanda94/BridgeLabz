package com.bridgelabz.designpattern.structural.facade;

public class ShapeFacade {
	private Shape rectangle;
	private Shape triangle;
	private Shape square;
	
	public ShapeFacade() {
		super();
		rectangle=new Rectangle();
		triangle=new Triangle();
		square=new Square();
	}
	
	public void drawRectangle()
	{
		rectangle.draw();
	}
	public void drawTriangle()
	{
		triangle.draw();
	}
	public void drawSquare()
	{
		square.draw();
	}
}
