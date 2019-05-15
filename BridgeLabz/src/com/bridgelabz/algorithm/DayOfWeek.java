package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: To the Util Class add dayOfWeek static function that takes a date as input and
prints the day of the week that date falls on. Your program should take three
command­line arguments: m (month), d (day), and y (year). For m use 1 for January,
2 for February, and so forth. For output print 0 for Sunday, 1 for Monday, 2 for
Tuesday, and so forth.
**/
public class DayOfWeek {
public static void main(String[] args) {
	int month=Integer.parseInt(args[0]);
	int day=Integer.parseInt(args[1]);
	int year=Integer.parseInt(args[2]);
	int d=Util.dayOfWeek(month,day,year);
	String s[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	System.out.println(s[d]);
}
}