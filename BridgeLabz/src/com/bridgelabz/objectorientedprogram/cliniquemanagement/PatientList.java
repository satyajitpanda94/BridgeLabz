package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.util.ArrayList;

public class PatientList {
ArrayList<Patient> patients=new ArrayList<Patient>();

public ArrayList<Patient> getPatients() {
	return patients;
}

public void setPatients(ArrayList<Patient> patients) {
	this.patients = patients;
}
public String searchPatient(String name, String mobileNumber)
{
	String patientDetails="";
	for(Patient patient:patients)
	{
		if(patient.getName().equalsIgnoreCase(name) && patient.getMobileNumber().equalsIgnoreCase(mobileNumber))
		{
			patientDetails=patient.toString();
			break;
		}
	}
	return patientDetails;
}

public String patientId(String name,String mobileNumber)
{
	String patientId=null;
	for(Patient patient:patients)
	{
		if(patient.getName().equalsIgnoreCase(name) && patient.getMobileNumber().equalsIgnoreCase(mobileNumber))
		{
			patientId=patient.getId();
			break;
		}
	}
	return patientId;
}
public void addPatient(Patient patient)
{
	patients.add(patient);
}
}
