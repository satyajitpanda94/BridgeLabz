package com.bridgelabz.objectorientedprogram.addressbook;

public class Address {
private String streetNum;
private String post;
private String city;
private String state;
private int zip;
public Address() {}
public Address(String streetNum, String post, String city, String state, int zip) {
	super();
	this.streetNum = streetNum;
	this.post = post;
	this.city = city;
	this.state = state;
	this.zip = zip;
}
public String getStreetNum() {
	return streetNum;
}
public void setStreetNum(String streetNum) {
	this.streetNum = streetNum;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getZip() {
	return zip;
}
public void setZip(int zip) {
	this.zip = zip;
}
}
