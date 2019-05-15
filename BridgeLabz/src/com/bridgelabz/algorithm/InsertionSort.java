package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Reads in strings from standard input and prints them in sorted order.
Uses insertion sort.
**/
import java.util.InputMismatchException;
import java.util.Scanner;


public class InsertionSort {
public static void main(String[] args) {
	System.out.println("Enter No of Words for List :");
	Scanner sc=new Scanner(System.in);
	int n;
	while (true) {
		try {
			n = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Words");
			String wordList[]=new String[n];
			for(int i=0;i<n;i++)
				wordList[i]=sc.nextLine();
			Util.insertionSort(wordList);
			System.out.println("Sorted array is :");
			for(String k:wordList)
				System.out.print(k+" ");
			sc.close();
			break;

		} catch (InputMismatchException e) {
			System.out.println("Invalid Datatype,Enter integer value, so Re-enter:");
//			clears buffer
			sc.next();
		}
	}
}

}
