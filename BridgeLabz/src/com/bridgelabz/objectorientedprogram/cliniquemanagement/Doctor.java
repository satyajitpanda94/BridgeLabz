package com.bridgelabz.objectorientedprogram.cliniquemanagement;

public class Doctor extends Person{
private String specialization;
private String availability;
public String getSpecialization() {
	return specialization;
}
public void setSpecialization(String specialization) {
	this.specialization = specialization;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
@Override
public String toString() {
	return "Doctor Name : "+getName()+",\nId : "+getId()+",\nspecialization : " + specialization + ",\nAvailability : " + availability ;
}



}
