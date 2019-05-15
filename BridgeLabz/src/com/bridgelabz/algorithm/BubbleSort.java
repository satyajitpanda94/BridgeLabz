package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Reads in integers prints them in sorted order using Bubble Sort
**/
import java.util.InputMismatchException;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter no of integers to be entered by you :");
				int n = sc.nextInt();
				System.out.println("Enter integers :");
				int intList[] = new int[n];
				for (int i = 0; i < n; i++)
					intList[i] = sc.nextInt();
				Util.bubbleSort(intList);
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Invalid Enter,Enter Integer type data :");
//			clears buffer
				sc.next();
			}

		}
	}
}