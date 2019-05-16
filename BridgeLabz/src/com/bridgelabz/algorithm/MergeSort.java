package com.bridgelabz.algorithm;

/*
* created by: Satyajit Panda
* Date 30/04/2019
*
* Purpose: Write a program with Static Functions to do Merge Sort of list of
Strings.
**/
import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		String s[] = { "hvhvd", "yfys", "tsu", "suyyi", "jsy", "tsu", "ad", "dh" };
		System.out.println(Arrays.toString(s));
		mergeSort(s, 0, s.length - 1);
		System.out.println(Arrays.toString(s));
	}

	private static void mergeSort(String[] s, int beg, int end) {
		if (beg < end) {
			int mid = (beg + end) / 2;
			mergeSort(s, beg, mid);
			mergeSort(s, mid + 1, end);
			merge(s, beg, mid, end);
		}

	}

	private static void merge(String[] s, int beg, int mid, int end) {
		int leftArrayLength = mid - beg + 1;
		int rightArrayLength = end - mid;

		String leftArray[] = new String[leftArrayLength];
		String rightArray[] = new String[rightArrayLength];

		for (int i = 0; i < leftArrayLength; i++)
			leftArray[i] = s[beg + i];
		for (int j = 0; j < rightArrayLength; j++)
			rightArray[j] = s[mid + 1 + j];

		int i = 0, j = 0;
		int k = beg;

		while (i < leftArrayLength && j < rightArrayLength) {
			if (leftArray[i].compareTo(rightArray[j]) > 0) {
				s[k] = rightArray[j];
				j++;
			} else {
				s[k] = leftArray[i];
				i++;
			}
			k++;
		}

		while (i < leftArrayLength) {
			s[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightArrayLength) {
			s[k] = rightArray[j];
			j++;
			k++;
		}

	}
}