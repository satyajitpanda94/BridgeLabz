package com.bridgelabz.datastructure;
/*
* created by: Satyajit Panda
* Date 07/05/2019
*
* Purpose: Take a range of 0 ­ 1000 Numbers and find the Prime numbers in that range. Store
the prime numbers in a 2D Array, the first dimension represents the range 0-100,
100-200, and so on. While the second dimension represents the prime numbers in
that range.
**/

public class PrimeNumbers2D {
	static int capacityPrimeNum = 10;
	static int primenum[] = new int[capacityPrimeNum];
	static int capacity = 10;
	static int prime2D[][] = new int[10][capacity];

	public static void main(String[] args) {
		createPrimeNumberInArray(0, 1000);
		printPrime();
	}

	public static void createPrimeNumberInArray(int k, int l) {
		int index = 0;
		for (int i = k + 2; i <= l; i++) {
			if (isPrime(i)) {
				if (index == capacityPrimeNum) {
					expand1D();
				}
				primenum[index] = i;
				index++;
			}

		}
		storePrimeIn2D();

	}

	private static void storePrimeIn2D() {
		int indexRow = 0, indexCol = 0;
		int index1D = 0, k = 100;
		for (int i = 0; i < primenum.length; i++) {
			if (indexCol == capacity) {
				expand();
			}

			if (primenum[index1D] >= k) {
				indexRow++;
				indexCol = 0;
				k += 100;
			}
			prime2D[indexRow][indexCol] = primenum[index1D];
			indexCol++;
			index1D++;
		}

	}

	private static void expand1D() {
		capacityPrimeNum = (capacityPrimeNum * 3) / 2;
		int prime2[] = new int[capacityPrimeNum];
		for (int i = 0; i < primenum.length; i++) {
			prime2[i] = primenum[i];
		}
		primenum = prime2;
		prime2 = null;

	}

	private static boolean isPrime(int i) {
		int count = 0;
		for (int j = 2; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				count++;
				break;
			}
		}
		if (count == 0)
			return true;
		else
			return false;

	}

	private static void printPrime() {
		int l = 0;
		for (int i = 0; i < 10; i++) {
			System.out.print(l + "-" + (l + 100) + " : ");
			for (int j = 0; j < capacity; j++) {
				if (prime2D[i][j] == 0)
					System.out.print("  ");
				else
					System.out.print(prime2D[i][j] + " ");
			}
			System.out.println();
			l += 100;
		}

	}

	private static void expand() {
		int cap = capacity;
		capacity = (capacity * 3) / 2;
		int prime2[][] = new int[10][capacity];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < cap; j++)
				prime2[i][j] = prime2D[i][j];
		}
		prime2D = prime2;
		prime2 = null;

	}
}
