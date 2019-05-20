package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.util.ArrayList;

public class DoctorsList {
private	String availability;
ArrayList<Doctor> doctors=new ArrayList<Doctor>();

public ArrayList<Doctor> getDoctors() {
	return doctors;
}

public void setDoctors(ArrayList<Doctor> doctorsList) {
	this.doctors = doctorsList;
}
public String searchDoctor(String name, String specialization)
{
	String doctorDetails="";
	for(Doctor doctor:doctors)
	{
		if(doctor.getName().equalsIgnoreCase(name) && doctor.getSpecialization().equalsIgnoreCase(specialization))
		{
			doctorDetails=doctor.toString();
			break;
		}
	}
	return doctorDetails;
}
public String doctorsId(String name,String specialization)
{
	String doctorId=null;
	for(Doctor doctor:doctors)
	{
		if(doctor.getName().equalsIgnoreCase(name) && doctor.getSpecialization().equalsIgnoreCase(specialization))
		{
			doctorId=doctor.getId();
			break;
		}
	}
	return doctorId;
}
public String availabilityOfDoctor(String name, String specialization)
{
	for(Doctor doctor:doctors)
	{
		if(doctor.getName().equalsIgnoreCase(name) && doctor.getSpecialization().equalsIgnoreCase(specialization))
		{
			availability=doctor.getAvailability();
			break;
		}
	}
	return availability;
}

}
