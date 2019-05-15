package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Extend the above program to find the prime numbers that are Anagram and
Palindrome.
**/


import java.util.ArrayList;


public class PrimeNumberWithAnagramAndPalindrome {
public static void main(String[] args) {
	ArrayList<Integer> a=Util.palindromePrime(Util.primeNumber());
	ArrayList<Integer> b=Util.anagramPrime(Util.primeNumber());
	System.out.println("Palindrome Prime Numbers are :");
	for(int j:a)
	{
		System.out.print(j+" ");
	}
	System.out.println("\nAnagram Prime Numbers are :");
	for(int k:b)
	{
		System.out.print(k+" ");
	}
}

}