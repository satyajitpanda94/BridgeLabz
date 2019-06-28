package com.bridgelabz;

public class Person {
String name;
private String mail;
private String phone;
private String password;
public Person() {}
public Person(String name, String mail, String phone, String password) {
	super();
	this.name = name;
	this.mail = mail;
	this.phone = phone;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
