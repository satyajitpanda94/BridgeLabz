package com.bridgelabz.datastructure;
/*
* created by: Satyajit Panda
* Date 06/05/2019
*
* Purpose: Find number of possible binary search tree, by taking number of nodes.
**/

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfBinarySearchTree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter Number of Nodes of binary tree : ");
				int n = sc.nextInt();
				while (n < 1) {
					System.out.print("Invalid Enter, re-enter.");
					n = sc.nextInt();
				}

				System.out.println(countBST(n));
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter, Enter Integer type data :");
//			clears buffer
				sc.nextLine();
			}
		}
	}

	private static int countBST(int n) {
		int G[] = new int[n + 1];
		G[0] = G[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				G[i] += G[j] * G[i - j - 1];
			}
		}
		return G[n];

	}

}
