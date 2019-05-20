package com.bridgelabz.objectorientedprogram.cliniquemanagement;

public class Patient extends Person {
private String mobileNumber;
private int age;

public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
@Override
public String toString() {
	return "Patient Name : "+getName()+",\nId : "+getId()+",\nMobileNumber : " + mobileNumber+",\nAge : "+age;
}

}
