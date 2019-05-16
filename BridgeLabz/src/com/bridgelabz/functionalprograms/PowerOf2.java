package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 10/04/2019
*
* Purpose: This program takes a command­line argument N and prints a table of the
powers of 2 that are less than or equal to 2^N.
**/

public class PowerOf2 {
	public static void main(String[] args) {
		int powerValueN;
		try {
			powerValueN = Integer.parseInt(args[0]);
			if (powerValueN >= 0 && powerValueN < 31) {
				power(powerValueN);
			} else
				System.out.println(
						"Power Value N should be greater than and equals to 0 and less than 31.\nSo change value of N.");

		} catch (NumberFormatException e) {
			System.out.println("Invalid datatype, so re-enter.");
		}

	}

	public static void power(int powerValueN) {
		for (int i = 0; i <= powerValueN; i++) {
			System.out.println("2^" + i + " = " + (int) Math.pow(2, i));
		}

	}
}
