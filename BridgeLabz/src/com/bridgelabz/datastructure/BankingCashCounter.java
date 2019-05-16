package com.bridgelabz.datastructure;

/*
* created by: Satyajit Panda
* Date 04/05/2019
*
* Purpose: Create a Program which creates Banking Cash Counter where people
come in to deposit Cash and withdraw Cash. Have an input panel to add people
to Queue to either deposit or withdraw money and dequeue the people. Maintain
the Cash Balance.
**/
import java.util.Scanner;

public class BankingCashCounter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double cashOfBank = 50000;
		System.out.println("Enter number of people in the queue :");
		int n = sc.nextInt();
		sc.nextLine();
		Queue<String> nameList = new Queue<>();
		Queue<Double> cashList = new Queue<>();

		for (int i = 0; i < n; i++) {
			if (cashList.peek() != null) {
				if (cashList.peek() * -1 <= cashOfBank) {
					cashOfBank = cashOfBank + cashList.peek();
					String name = nameList.dequeue();
					cashList.dequeue();
					System.out.println(name + " thank you for giving us opportunity to serve you.");
					System.out.println("Now bank has balance : " + cashOfBank);
				}

			}

			System.out.println("Enter name of person :");
			String name = sc.nextLine();
			System.out.println("Enter money for withdraw or diposit(enter -ve value for withdraw).");
			double cash = sc.nextDouble();
			sc.nextLine();
			if (cash < 0 && (cash * -1) > cashOfBank) {
				System.out.println(name + " please wait for some time.");
				nameList.enqueue(name);
				cashList.enqueue(cash);
			} else {
				cashOfBank = cashOfBank + cash;
				System.out.println(name + " thank you for giving us opportunity to serve you.");
			}

			System.out.println("Now bank has balance : " + cashOfBank);
		}
		Queue<String> nameList2 = new Queue<>();
		Queue<Double> cashList2 = new Queue<>();
		int lenth = nameList.size();
		while (lenth > 0) {
			String name = nameList.dequeue();
			double cash = cashList.dequeue();

			if ((cash * -1) > cashOfBank) {
				nameList2.enqueue(name);
				cashList2.enqueue(cash);
			} else {
				System.out.println(name + " thank you for giving us opportunity to serve you.");
				cashOfBank = cashOfBank + cash;
				System.out.println("Now bank has balance : " + cashOfBank);
			}

			lenth--;
		}
		if (nameList2.size() > 0) {
			System.out.print(nameList2);
			System.out.println(" left without withdrawing money, as bank has in-sufficient balance.");
		} else
			System.out.println("Queue is balanced.No One left without withdrawing money.");

		sc.close();
	}
}