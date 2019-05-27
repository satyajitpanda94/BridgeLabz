package com.bridgelabz.objectorientedprogram.addressbook;

import java.util.ArrayList;

public class PersonAddresses {
private ArrayList<Person> addressList;

public ArrayList<Person> getAddressList() {
	return addressList;
}

public void setAddressList(ArrayList<Person> addressList) {
	this.addressList = addressList;
}


public void printPersonList()
{
	for(Person person:addressList)
	{
		System.out.println(person.getFirstName()+" "+person.getLastName());
	}
}
public void printPersonWithZipList()
{
	for(Person person:addressList)
	{
		System.out.println(person.getFirstName()+" "+person.getLastName()+" : "+person.getAddress().getZip());
	}
}
public void showPersonData(String firstname,String lastName)
{
	for(Person person:addressList)
	{
		if(person.getFirstName().equalsIgnoreCase(firstname)&&person.getLastName().equalsIgnoreCase(lastName))
		{
			System.out.println("Street : "+person.getAddress().getStreetNum()+"\nPost : "+person.getAddress().getPost()
					+"\nCity : "+person.getAddress().getCity()+"\nState : "+person.getAddress().getState()
					+"\nZip Code : "+person.getAddress().getZip()+"\nMobile : "+person.getMobile());
		}
		
	}
}
}
