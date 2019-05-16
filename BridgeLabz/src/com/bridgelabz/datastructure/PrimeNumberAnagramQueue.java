package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 07/05/2019
*
* Purpose: Add the Prime Numbers that are Anagram in the Range of 0 ­ 1000 in a Queue using
the Linked List and Print the Anagrams from the Queue. Note no Collection Library
can be used.
**/

public class PrimeNumberAnagramQueue {
	public static void main(String[] args) {
		PrimeNumbersAnagram.findAnagram();
		Queue<Integer> q = new Queue<>();
		for (int i : PrimeNumbersAnagram.primeAnagram1D) {
			if (i != 0) {
				q.enqueue(i);
			}

		}
		System.out.println("Anagram prime no in between 0 to 1000 are :");
		int l = q.size();
		for (int k = 0; k < l; k++)
			System.out.print(q.dequeue() + " ");
	}
}
