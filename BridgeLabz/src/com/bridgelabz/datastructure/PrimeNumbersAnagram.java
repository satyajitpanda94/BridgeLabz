package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 07/05/2019
*
* Purpose: Extend the Prime Number Program and store only the numbers in that range that are
Anagrams. For e.g. 17 and 71 are both Prime and Anagrams in the 0 to 1000 range.
Further store in a 2D Array the numbers that are Anagram and numbers that are not
Anagram.
**/

import java.util.Arrays;

public class PrimeNumbersAnagram {
	public static int primeAnagram1D[];
	public static int primeAnagram2D[][];

	public static void main(String[] args) {
		findAnagram();
		print();
	}

	public static void findAnagram() {
		PrimeNumbers2D.createPrimeNumberInArray(0, 1000);
		int capacity = PrimeNumbers2D.primenum.length;

		int primeAnagram1[] = new int[capacity];
		primeAnagram1D = primeAnagram1;

		int primeAnagram2[][] = new int[2][capacity];
		primeAnagram2D = primeAnagram2;
		int a = 0, b = 0;
		for (int k = 0; k < PrimeNumbers2D.primenum.length; k++) {
			int count = 0;
			for (int l = k + 1; l < PrimeNumbers2D.primenum.length; l++) {
				if (isAnagram(PrimeNumbers2D.primenum[k], PrimeNumbers2D.primenum[l])
						&& PrimeNumbers2D.primenum[k] != 0) {
					if (count == 0) {
						primeAnagram1D[a] = PrimeNumbers2D.primenum[k];
						primeAnagram2D[0][a] = PrimeNumbers2D.primenum[k];
						a++;
					}
					primeAnagram1D[a] = PrimeNumbers2D.primenum[l];
					primeAnagram2D[0][a] = PrimeNumbers2D.primenum[l];
					PrimeNumbers2D.primenum[l] = 0;
					count++;
					a++;
				}
			}
			if (count > 0)
				continue;
			else if (PrimeNumbers2D.primenum[k] != 0) {
				primeAnagram2D[1][b] = PrimeNumbers2D.primenum[k];
				b++;
			} else
				continue;
		}

	}

	private static void print() {
		for (int k = 0; k < 2; k++) {
			if (k == 0)
				System.out.println("Anagram prime :");
			else
				System.out.println("Not Anagram :");

			for (int l = 0; l < PrimeNumbers2D.primenum.length; l++) {
				if (primeAnagram2D[k][l] != 0)
					System.out.print(primeAnagram2D[k][l] + " ");
			}
			System.out.println();
		}

	}

	public static boolean isAnagram(int k, int l) {
		String s1 = "" + k;
		String s2 = "" + l;
		char ch1[] = s1.toCharArray();
		char ch2[] = s2.toCharArray();
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		return String.valueOf(ch1).equals(String.valueOf(ch2));
	}
}
