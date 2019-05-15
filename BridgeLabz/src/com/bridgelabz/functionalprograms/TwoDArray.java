package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: A library for reading in 2D arrays of integers, doubles, or booleans from
standard input and printing them out to standard output.
**/
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TwoDArray {
public static void main(String[] args) {
	System.out.println("Enter 2D Array");
	Scanner sc=new Scanner(System.in);
	PrintWriter p=new PrintWriter(System.out);
	
	int m;
	while (true) {
		try {
			System.out.println("Enter rows:");
			m=sc.nextInt();
			System.out.println("Enter columns :");
			int n=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter datas to array :");
			Object ob[][]=new Object[m][n];
			
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					ob[i][j]=sc.next();
				}
			}	 
			System.out.println("Array is :");
			for(int i=0;i<m;i++)
			{
				for(int j=0;j<n;j++)
				{
					p.print(ob[i][j]+" ");;
				}
				p.println();
			}	 
			p.flush();
			p.close();
			sc.close();
			break;
		} catch (InputMismatchException e) {
			System.out.println("invalid Enter,Enter Integer type data.");
//			clears buffer
			sc.next();
		}
	
     }
}
}
