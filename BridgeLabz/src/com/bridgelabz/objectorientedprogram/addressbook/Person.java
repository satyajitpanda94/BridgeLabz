package com.bridgelabz.objectorientedprogram.addressbook;

public class Person {
private String firstName;
private String lastName;
private Address address;
private long mobile;
public Person() {}
public Person(String firstName, String lastName, Address address, long mobile) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.address = address;
	this.mobile = mobile;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
public long getMobile() {
	return mobile;
}
public void setMobile(long mobile) {
	this.mobile = mobile;
}
}
