package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Take a range of 0 ­ 1000 Numbers and find the Prime numbers in that range.
**/

import java.util.ArrayList;


public class PrimeNumbers {
public static void main(String[] args) {
	ArrayList<Integer> a=Util.primeNumber();
	System.out.println("Prime Numbers are : ");
	for(int i:a)
		System.out.print(i+" ");

}
}