package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 29/04/2018
*
* Purpose: a. Desc ­> Create Utility Class having following static methods
binarySearch method for integer
binarySearch method for String
insertionSort method for integer
insertionSort method for String
bubbleSort method for integer
bubbleSort method for String
b. I/P ­> Write main function to call the utility function
c. Logic ­> Check using Stopwatch the Elapsed Time for every method call
d. O/P ­> Output the Search and Sorted List. More importantly print elapsed time
performance in descending order
**/

import java.util.Collections;
import java.util.TreeMap;

public class Utility {
	public static void main(String[] args) {
		TreeMap<Long, String> lhm = new TreeMap<>(Collections.reverseOrder());

		int a[] = { 25, 65, 42, 13, 27, 86, 45 };
		int b[] = { 25, 65, 42, 13, 27, 86, 45 };
		String s[] = { "sdf", "gfhhf", "fyu", "dghj", "dhx", "sdf" };
		String k[] = { "sdf", "gfhhf", "fyu", "dghj", "dhx", "sdf" };

		printArray(a);
		long startTime = System.nanoTime();
		bubbleSortInt(a);
		long endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "BubbleSortInt");
		System.out.println();

		printArray(s);
		startTime = System.nanoTime();
		bubbleSortString(s);
		endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "BubbleSortString");
		System.out.println();

		printArray(b);
		startTime = System.nanoTime();
		insertionSortInt(b);
		endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "InsertionSortInt");
		System.out.println();

		printArray(k);
		startTime = System.nanoTime();
		insertionSortString(k);
		endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "InsertionSortString");
		System.out.println();

		printArray(a);
		startTime = System.nanoTime();
		int bsi = binarySearchInt(a, 86);
		endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "BinarySearchInt");
		if (bsi == -1)
			System.out.println("Number not present in array.");
		else
			System.out.println("Index no of Number is : " + bsi + "\n");

		printArray(s);
		startTime = System.nanoTime();
		int bss = binarySearchString(s, "fyu");
		endTime = System.nanoTime();
		lhm.put(stopWatch(startTime, endTime), "BinarySearchString");
		if (bss == -1)
			System.out.println("String not present in array.");
		else
			System.out.println("Index no of String is : " + bss);

		System.out.println(lhm.toString());
	}

	private static Long stopWatch(long startTime, long endTime) {
		return endTime - startTime;

	}

	private static int binarySearchString(String[] si, String string) {
		int start = 0, end = si.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (si[mid].equals(string))
				return mid;
			else if (si[mid].compareTo(string) < 0)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private static int binarySearchInt(int[] b, int i) {
		int start = 0, end = b.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (b[mid] == i)
				return mid;
			else if (b[mid] < i)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private static void insertionSortString(String[] si) {
		for (int i = 1; i < si.length; i++) {
			String k = si[i];
			int j = i - 1;
			while (j >= 0 && si[j].compareTo(k) > 0) {
				si[j + 1] = si[j];
				j--;
			}
			si[j + 1] = k;
		}
		printArray(si);
	}

	private static void insertionSortInt(int[] b) {
		for (int i = 1; i < b.length; i++) {
			int k = b[i];
			int j = i - 1;
			while (j >= 0 && b[j] > k) {
				b[j + 1] = b[j];
				j--;
			}
			b[j + 1] = k;
		}
		printArray(b);
	}

	private static void bubbleSortString(String[] s) {
		for (int i = 0; i < s.length; i++) {
			for (int j = i; j < s.length; j++) {
				if (s[i].compareTo(s[j]) > 0) {
					String temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
		}
		printArray(s);
	}

	private static void bubbleSortInt(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		printArray(a);
	}

	public static void printArray(int[] x) {
		for (int i : x)
			System.out.print(i + " ");
		System.out.println();
	}

	public static void printArray(String[] x) {
		for (String i : x)
			System.out.print(i + " ");
		System.out.println();
	}
}