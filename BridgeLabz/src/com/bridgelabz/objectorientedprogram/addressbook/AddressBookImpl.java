package com.bridgelabz.objectorientedprogram.addressbook;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.bridgelabz.objectorientedprogram.JsonConversion;


public class AddressBookImpl implements AddressBook{
    private static PersonAddresses addresses;
	private static Scanner scanner=new Scanner(System.in);
	private static String firstName;
	private static String lastName;
	private static String street;
	private static String post;
	private static String city;
	private static String state;
	private static int zip;
	private static long mobile;
	private static String filePathName;

	@Override
	public void openAddressBook() {
		file();
        File file=new File(filePathName);
        if(file.length()!=0 && file.exists())
        {
        	addresses=JsonConversion.jsonToJava(file, PersonAddresses.class);
    		System.out.println("\nThis file consistes of address of :\n");
    		addresses.printPersonList();
        }
        else if(file.length()==0 && file.exists())
        {
        	System.out.println("File is empty.");
            addresses=new PersonAddresses();
            ArrayList<Person> list=new ArrayList<Person>();
			addresses.setAddressList(list);
        }
        else
        	System.out.println("File not Exist in Driver.");
	}

	public void file()
	{
		System.out.print("Enter File Name : ");	
        String fileName=scanner.nextLine();
        String filePath="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/addressbook";
        filePathName=filePath+"/"+fileName+".json";
	}
	
	@Override
	public void createAddressBook() throws IOException {
		file();
        File file=new File(filePathName);
        boolean checkFileCreation=file.createNewFile();
        if(checkFileCreation)
        	System.out.println("File is created.");
        else
        	System.out.println("File is already exist in folder,so can't create the file.");
        addresses=new PersonAddresses();
	}

	@Override
	public void addPerson() {
		System.out.print("Enter first name : ");
		firstName=scanner.nextLine();
		System.out.print("Enter last name : ");
		lastName=scanner.nextLine();		
		System.out.print("Enter street number & area : ");
		street=scanner.nextLine();
		System.out.print("Enter Post : ");
		post=scanner.nextLine();
		System.out.print("Enter city : ");
		city=scanner.nextLine();
		System.out.print("Enter state : ");
		state=scanner.nextLine();
		System.out.print("Enter zip code : ");
		zip=scanner.nextInt();
		System.out.print("Enter mobile number : ");
		mobile=scanner.nextLong();		
		
		Address address=new Address(street, post, city, state, zip);
		Person person=new Person(firstName, lastName, address, mobile);
		addresses.getAddressList().add(person);
		System.out.println("\nNow file consistes of address of :\n");
		addresses.printPersonList();
	}

	@Override
	public void editPerson() {
		System.out.println("\nFile contains address of :");
		addresses.printPersonList();
		System.out.print("\nEnter first name : ");
		firstName=scanner.nextLine();
		System.out.print("Enter last name : ");
		lastName=scanner.nextLine();		
				
		ArrayList<Person> persons=addresses.getAddressList();
		int count=0;
		for(Person person:persons)
		{
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
			{
				count++;
				System.out.print("Enter new street number & area : ");
				street=scanner.nextLine();
				System.out.print("Enter new Post : ");
				post=scanner.nextLine();
				System.out.print("Enter new city : ");
				city=scanner.nextLine();
				System.out.print("Enter new state : ");
				state=scanner.nextLine();
				System.out.print("Enter new zip code : ");
				zip=scanner.nextInt();
				System.out.print("Enter new mobile number : ");
				mobile=scanner.nextLong();
				Address address=new Address(street, post, city, state, zip);
				person.setAddress(address);
				person.setMobile(mobile);
				System.out.println("File is edited successfully.");
				System.out.println("Updated data is : ");
				addresses.showPersonData(firstName, lastName);
			}
			
		}
		if(count==0)
			System.out.println("Person doesn't exist in address book.");
	}

	

	@Override
	public void deletePerson() {
		System.out.print("Enter first name : ");
		firstName=scanner.nextLine();
		System.out.print("Enter last name : ");
		lastName=scanner.nextLine();	
		ArrayList<Person> persons=addresses.getAddressList();
		int count=0;
		for(Person person:persons)
		{
			if(person.getFirstName().equalsIgnoreCase(firstName) && person.getLastName().equalsIgnoreCase(lastName))
			{
				count++;
				addresses.getAddressList().remove(person);
				System.out.println("Person is deleted successfully.");
				System.out.println("\nNow file consistes of address of :\n");
	    		addresses.printPersonList();
				break;
			}
		}
		if(count==0)
			System.out.println("Person doesn't exist in address book.");

	}

	@Override
	public void sortByName() {
		ArrayList<Person> list=addresses.getAddressList();
		for(int index1=0;index1<list.size();index1++)
		{ 
			String personName=list.get(index1).getFirstName()+" "+list.get(index1).getLastName();
			for(int index2=0;index2<list.size();index2++)
			{
				String personName2=list.get(index2).getFirstName()+" "+list.get(index2).getLastName();
				if(personName.compareTo(personName2)<0)
				{
					Person person1=list.get(index1);
					Person person2=list.get(index2);
					addresses.getAddressList().remove(index1);
					addresses.getAddressList().add(index1, person2);
					addresses.getAddressList().remove(index2);
					addresses.getAddressList().add(index2, person1);
				}

			}
		}
		System.out.println("\nNow sorted file consistes of address of :\n");
		addresses.printPersonList();
	}

	@Override
	public void sortByZip() {
		ArrayList<Person> list=addresses.getAddressList();
		for(int index1=0;index1<list.size();index1++)
		{ 
			int zip1=list.get(index1).getAddress().getZip();
			for(int index2=0;index2<list.size();index2++)
			{
				int zip2=list.get(index2).getAddress().getZip();
				if(zip1<zip2)
				{
					Person person1=list.get(index1);
					Person person2=list.get(index2);
					addresses.getAddressList().remove(index1);
					addresses.getAddressList().add(index1, person2);
					addresses.getAddressList().remove(index2);
					addresses.getAddressList().add(index2, person1);
				}

			}
		}
		System.out.println("\nNow sorted file consistes of address of :\n");
		addresses.printPersonWithZipList();;
	}

	@Override
	public void saveAddressBook() {
		
	    FileWriter fWrite;
		try {
			fWrite = new FileWriter(new File(filePathName));
			fWrite.write(JsonConversion.javaToJson(addresses));
			System.out.println("File is saved.");
	    	fWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveAsAddressBook() {
		String fileName="";
		boolean x=true;
		System.out.println("Enter file format to save - .java or .txt");
		while(x)
		{
			String switchCase=scanner.nextLine();
			switch (switchCase) {
			case ".txt":
				fileName=filePathName.replace(".json", ".txt");
				x=false;
				break;
			case ".java":
				fileName=filePathName.replace(".json", ".java");
				x=false;
				break;
			default:
				System.out.print("Invalid file format.So re-enter : ");
			}
		}
		
	    FileWriter fWrite;
		try {
			fWrite = new FileWriter(new File(fileName));
			fWrite.write(JsonConversion.javaToJson(addresses));
	    	fWrite.close();
	    	System.out.println("File is saved.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean quitProgram() {
        return false;
	}
	public void switchCaseImpl() throws IOException
	{
		System.out.println("\nWhat do you want to do.");
		System.out.println(
				"1-add\n2-edit\n3-delete\n4-sort by name\n5-sort by zip\n6-save\n7-save as\n8-quite program\n");
		boolean x = true;
		while(x) {
			System.out.print("\nEnter your choice : ");
			int switchCase = scanner.nextInt();
			scanner.nextLine();
			switch (switchCase) {
			case 1:
				addPerson();
				break;
			case 2:
				editPerson();
				break;
			case 3:
				deletePerson();
				break;
			case 4:
				sortByName();
				break;
			case 5:
				sortByZip();
				break;
			case 6:
				saveAddressBook();
				break;
			case 7:
				saveAsAddressBook();
				break;
			case 8:
				x = quitProgram();
				break;
			default:
				System.out.println("Invalid Enter");
			}
		}
	}
	
}
