package com.bridgelabz.designpattern.creational.Prototype;

import java.util.ArrayList;

public class Employees implements Cloneable {
	private ArrayList<String> employees;
    
	public ArrayList<String> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<String> employees) {
		this.employees = employees;
	}
	public Object clone() throws CloneNotSupportedException {
		Employees emp=(Employees) super.clone();
		ArrayList<String> temp=new ArrayList<String>();
		for(String employee:this.getEmployees())
			temp.add(employee);
		emp.setEmployees(temp);
		return emp;
	}
}
