package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: One string is an anagram of another if the second is simply a
rearrangement of the first. For example, 'heart' and 'earth' are anagrams...
**/
import java.util.Scanner;

public class AnagramDetection {
public static void main(String[] args) {
	System.out.println("Enter Two Strings : ");
	Scanner sc= new Scanner(System.in);
	String s1=sc.nextLine();
	String s2=sc.nextLine();
	if(Util.anagram(s1,s2))
		System.out.println("Two strings are anagram.");
	else
		System.out.println("Two strings are not anagram.");
	sc.close();
}
}