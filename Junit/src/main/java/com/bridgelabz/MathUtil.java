package com.bridgelabz;

public class MathUtil {
	private Calculator calculator;
	
	public MathUtil(Calculator calculator) {
		super();
		this.calculator = calculator;
	}
	public MathUtil() {
		super();
	}
	public int add(int a,int b) {
		return calculator.add(a,b);
//		return a+b;

	}
	public  double divide(int a,int b) {
		return calculator.devide(a, b);
	}
	public  int multiply(int a,int b) {
		return calculator.multiply(a, b);
	}
}
