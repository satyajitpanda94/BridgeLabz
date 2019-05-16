package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 30/04/2019
*
* Purpose: Write a static function toBinary that outputs the binary (base 2) representation of
the decimal number typed as the input. It is based on decomposing the number into
a sum of powers of 2.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class ToBinary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter number :");
				int num = sc.nextInt();
				String binary = Util.toBinary(num);
				binary = Util.binaryPadding(binary);
				String binary1 = binary.substring(0, 8) + " " + binary.substring(8, 16) + " " + binary.substring(16, 24)
						+ " " + binary.substring(24);
				System.out.println(binary1);
				sc.close();
				break;

			} catch (InputMismatchException e) {
				System.out.println("Invalid Datatype, Enter Integer Type Data,so Re-enter:");
//			clears buffer
				sc.next();
			}

		}

	}
}