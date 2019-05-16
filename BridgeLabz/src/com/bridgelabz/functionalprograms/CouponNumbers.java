package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 24/04/2019
*
* Purpose: Given N distinct Coupon Numbers, how many random numbers do you
need to generate distinct coupon number? This program simulates this random
process.
**/

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CouponNumbers {
	public static void main(String[] args) {
		System.out.println("Enter N distinct Coupon Numbers");
		Scanner sc = new Scanner(System.in);
		int n;
		while (true) {
			try {
				n = sc.nextInt();
				ArrayList<Integer> al = new ArrayList<>();

				int noOfRandomNumber = 0;
				while (al.size() < n) {
					int z = getCoupon(n + 1);
					if (!al.contains(z))
						al.add(z);
					noOfRandomNumber++;
				}
				System.out.println(
						"Total random number needed to have all " + n + " distinct numbers is :" + noOfRandomNumber);
				for (int j = 0; j < al.size(); j++)
					System.out.print(al.get(j) + " ");
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter, Enter Integer type data :");
//				clears buffer
				sc.nextLine();
			}
		}

	}

	public static int getCoupon(int n) {
		Random r = new Random();
		r.nextInt(n);
		return r.nextInt(n);
	}

}
