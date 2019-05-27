package com.bridgelabz.objectorientedprogram.addressbook;

import java.io.IOException;
import java.util.Scanner;

public class User {

	
	public static void main(String[] args) throws IOException {
		
		AddressBookImpl addressBookImpl = new AddressBookImpl();
		Scanner scanner=new Scanner(System.in);
		System.out.println("1-create address book\n2-open address book");
		System.out.print("\nEnter your choice : ");
		int switchCase = scanner.nextInt();
		scanner.nextLine();
		switch (switchCase) {
		case 1:
			addressBookImpl.createAddressBook();
			addressBookImpl.switchCaseImpl();
			break;
		case 2:
			addressBookImpl.openAddressBook();
			addressBookImpl.switchCaseImpl();
			break;
		
		default:
			System.out.println("Invalid Enter");
		}
		System.out.println("Program terminated successfully.");
		scanner.close();
	}
}
