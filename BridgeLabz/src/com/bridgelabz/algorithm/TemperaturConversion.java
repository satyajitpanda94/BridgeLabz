package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: To the Util Class add temperaturConversion static function, given the temperature
in fahrenheit as input outputs the temperature in Celsius or viceversa using the
formula.
**/
import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperaturConversion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter Temperature :");
				double temp = sc.nextDouble();
				System.out.println("Enter Unit - C for Celsius or F for Fahrenheit :");
				char unit = sc.next().charAt(0);
				Util.temperaturConversion(temp, unit);
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Enter,Enter Double type data :");
//			clears buffer
				sc.next();
			}
		}
	}
}