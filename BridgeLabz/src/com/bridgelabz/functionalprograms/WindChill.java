package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 26/04/2019
*
* Purpose: Write a program WindChill.java that takes two double command­line arguments t
and v and prints the wind chill. Use Math.pow(a, b) to compute ab.
**/

public class WindChill {
	public static void main(String[] args) {
		double temp = Double.parseDouble(args[0]);
		double windSpeed = Double.parseDouble(args[1]);
		if (temp > 50 || windSpeed > 120 || windSpeed < 3)
			System.out.println(
					"Entered temperature is larger than 50,\nOr Wind Speed is larger than 120 or lesser than 3.\nSo Re-enter the value");
		else {
			double windChill = 35.74 + (0.6215 * temp) + (((0.4275 * temp) - 35.75) * Math.pow(windSpeed, 0.16));
			System.out.println("Effective temperature (the wind chill) is : " + windChill);
		}
	}
}
