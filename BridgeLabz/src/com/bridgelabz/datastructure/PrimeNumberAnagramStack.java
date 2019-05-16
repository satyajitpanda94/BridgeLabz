package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 07/05/2019
*
* Purpose: Add the Prime Numbers that are Anagram in the Range of 0 ­ 1000 in a Stack using
the Linked List and Print the Anagrams in the Reverse Order. Note no Collection
Library can be used.
**/

public class PrimeNumberAnagramStack {
	public static void main(String[] args) {
		PrimeNumbersAnagram.findAnagram();
		Stack<Integer> st = new Stack<>();
		for (int i : PrimeNumbersAnagram.primeAnagram1D) {
			if (i != 0) {
				st.push(i);
			}

		}

		System.out.println("Anagram prime no in between 0 to 1000 in reverse order are :");
		int l = st.size();
		for (int k = 0; k < l; k++)
			System.out.print(st.pop() + " ");
	}
}
