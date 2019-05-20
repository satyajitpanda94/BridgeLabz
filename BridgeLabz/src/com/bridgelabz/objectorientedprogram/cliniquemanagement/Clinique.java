package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


import com.bridgelabz.objectorientedprogram.JsonConversion;

public class Clinique {
public static String popularDoctor()
{
	String popularDoctor="";

	File fileAppointment=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/Doctor'sAppointmentJson.json");
    AppointmentList appointments=JsonConversion.jsonToJava(fileAppointment, AppointmentList.class);
    
    File fileDoctors=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/DoctorsJson.json");
	DoctorsList doctors=JsonConversion.jsonToJava(fileDoctors, DoctorsList.class);
	
	ArrayList<Appointment> appointment2=appointments.getAppointments();
	ArrayList<Doctor> doctors2=doctors.getDoctors();
	int count1=0;
	for(Doctor doctor:doctors2)
	{
		int count2=0;
		for(Appointment appointment:appointment2)
		{
			if(appointment.getDoctorId().equalsIgnoreCase(doctor.getId()))
			{
				count2++;
			}
		}
		if(count1<count2)
		{
			popularDoctor=doctor.getName();
			count1=count2;
		}
	}
	return popularDoctor;
}
public static String popularSpecialization()
{
	HashMap<String, Integer> specialization=new HashMap<String, Integer>();
	
	File fileAppointment=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/Doctor'sAppointmentJson.json");
    AppointmentList appointments=JsonConversion.jsonToJava(fileAppointment, AppointmentList.class);
    
    File fileDoctors=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/DoctorsJson.json");
	DoctorsList doctors=JsonConversion.jsonToJava(fileDoctors, DoctorsList.class);
	
	ArrayList<Appointment> appointment2=appointments.getAppointments();
	ArrayList<Doctor> doctors2=doctors.getDoctors();
	
	for(Doctor doctor:doctors2)
	{
		int count=0;
		String docSpecialn=doctor.getSpecialization();
		for(Appointment appointment:appointment2)
		{
			if(appointment.getDoctorId().equalsIgnoreCase(doctor.getId()))
			{
				count++;
			}
		}
		if(!specialization.containsKey(docSpecialn))
		{
			specialization.put(docSpecialn, count);
		}
		else
		{
			specialization.put(docSpecialn, count+specialization.get(docSpecialn));
		}
	}
	int max=0;
	String popularSpecialization="";
	for(String specnIndex:specialization.keySet())
	{
		if(max<specialization.get(specnIndex))
		{
			max=specialization.get(specnIndex);
			popularSpecialization=specnIndex;
		}
	}
	return popularSpecialization;
}
}
