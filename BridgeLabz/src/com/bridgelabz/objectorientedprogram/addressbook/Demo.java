package com.bridgelabz.objectorientedprogram.addressbook;

import java.util.Scanner;

public class Demo {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println(
			"1-create address book\n2-open address book\n3-add\n4-edit\n5-delete\n6-sort by name\n7-sort by zip\n8-save\n9-save as\n10-quite program\n");
	boolean x = true;
	while(x) {
		System.out.println("\nEnter your choice.\n");
		int switchCase = sc.nextInt();
		sc.nextLine();
		switch (switchCase) {
		case 1:
			System.out.println("1");;
			break;
		case 2:
			System.out.println("2");;
			break;
		case 3:
			System.out.println("3");;
			break;
		case 4:
			System.out.println("4");;
			break;
		case 5:
			System.out.println("5");;
			break;
		case 6:
			System.out.println("6");;
			break;
		case 7:
			System.out.println("7");;
			break;
		case 8:
			System.out.println("8");;
			break;
		case 9:
			System.out.println("9");;
			break;
		case 10:
			x=false;
			System.out.println("10");;
			break;
		default:
			System.out.println("Invalid Enter");
		}
	}
	sc.close();
}

}
