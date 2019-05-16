package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 29/04/2019
*
* Purpose: takes a command­line argument N, asks you to think of a number
between 0 and N­1, where N = 2^n, and always guesses the answer with n
questions.
**/
import java.util.Scanner;

public class FindYourNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(args[0]);
		int n = (int) Math.sqrt(N);
		System.out.println("Think a Number between 0 and " + (N - 1));
		int a[] = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = i;
		Util.findYourNumber(sc, a, n);

	}
}