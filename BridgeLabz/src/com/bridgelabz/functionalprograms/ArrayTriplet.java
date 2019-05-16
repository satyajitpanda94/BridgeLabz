package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 24/04/2019
*
* Purpose: A program with cubic running time. Read in N integers and counts the
number of triples that sum to exactly 0.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArrayTriplet {
	public static void main(String[] args) {
		System.out.println("Enter Number Of Integer in Array :");
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				n = sc.nextInt();
				int arr[] = new int[n];

				System.out.println("Enter values to array :");
				for (int l = 0; l < arr.length; l++)
					arr[l] = sc.nextInt();

				int noOfTriplets = 0;
				for (int i = 0; i < arr.length; i++) {
					for (int j = i + 1; j < arr.length; j++) {
						for (int k = j + 1; k < arr.length; k++) {
							if (arr[i] + arr[j] + arr[k] == 0) {
								System.out.print(" ( " + arr[i] + ", " + arr[j] + ", " + arr[k] + " ) ");
								noOfTriplets++;
							}
						}
					}
				}
				if (noOfTriplets == 0)
					System.out.println("No such triplet present.");
				else
					System.out.println("\nTotal no of tiplets : " + noOfTriplets);
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter,Enter Integer type data :");
//			clears buffer
				sc.next();
			}
		}

	}
}