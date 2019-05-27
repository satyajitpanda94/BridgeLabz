package com.bridgelabz.designpattern.creational.Prototype;

import java.util.ArrayList;
import java.util.Arrays;

public class User {
public static void main(String[] args) throws CloneNotSupportedException {
	String emplArray[]= {"Samir","Kamal","Kapil","Sashi"};
	ArrayList<String> empList=new ArrayList<String>(Arrays.asList(emplArray));
	Employees employees=new Employees();
	employees.setEmployees(empList);
	
	Employees employees2=(Employees) employees.clone();
	Employees employees3=(Employees) employees.clone();
	
	ArrayList<String> empList2=employees2.getEmployees();
	empList2.add("Kalu");
	ArrayList<String> empList3=employees3.getEmployees();
	empList3.remove("Kamal");
	System.out.println(employees.getEmployees());
	System.out.println(empList2);
	System.out.println(empList3);
}
}
