package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 29/04/2019
*
* Purpose: Write a Util Static Function to calculate monthlyPayment that reads in three
command­line arguments P, Y, and R and calculates the monthly payments you
would have to make over Y years to pay off a P principal loan amount at R per cent
interest compounded monthly.
**/

public class MonthlyPayment {
	public static void main(String[] args) {
		double principal = Double.parseDouble(args[0]);
		int year = Integer.parseInt(args[1]);
		double interest = Double.parseDouble(args[2]);
		Util.monthlyPayment(principal, year, interest);
	}
}