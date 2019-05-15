package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Write static function to return all permutation of a String.
**/

import java.util.ArrayList;
import java.util.Scanner;

public class Permutation {
	static ArrayList<String> al=new ArrayList<>();
	
	public static void main(String[] args) {
		System.out.println("Enter String :");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		permutation(s,0,s.length()-1);
		System.out.println(al.toString());
		System.out.println(al.size());
		sc.close();
	}

	private static void permutation(String s, int i, int j) {
		if(i==j && !al.contains(s))
			al.add(s);
		for(int k=i;k<=j;k++)
		{
			s=swap(s,i,k);
			permutation(s, i+1, j);
			s=swap(s, i, k);
			
		}
		
	}

	private static String swap(String s, int i, int k) {
		char c[]=s.toCharArray();
		char temp=c[i];
		c[i]=c[k];
		c[k]=temp;
		
		return String.valueOf(c);
	}

}
