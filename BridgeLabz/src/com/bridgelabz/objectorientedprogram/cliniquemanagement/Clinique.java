package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

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

public static void takeAppointment() {
	@SuppressWarnings("resource")
	Scanner scanner=new Scanner(System.in);
	System.out.print("\nEnter doctor Name : ");
	String doctorName=scanner.nextLine();
	System.out.print("Enter doctor Specialization : ");
	String specialization=scanner.nextLine();
	System.out.print("Enter Date : ");
	String date=scanner.nextLine();
	
	File fileDoctors=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/DoctorsJson.json");
	DoctorsList doctors=JsonConversion.jsonToJava(fileDoctors, DoctorsList.class);
	
	File fileAppointment=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/Doctor'sAppointmentJson.json");
	AppointmentList appointments=JsonConversion.jsonToJava(fileAppointment, AppointmentList.class);
	if(appointments.checkAvailabilityOfDoctor(doctorName, specialization,date))
	{
		System.out.println("Doctor is Available.");
		System.out.print("Enter Patient Name : ");
		String patientName=scanner.nextLine();
		System.out.print("Enter Patient Mobile number : ");
		String mobileNumber=scanner.nextLine();
		File filePatients=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/PatientsJson.json");
	    PatientList patients=JsonConversion.jsonToJava(filePatients, PatientList.class);
	    String patientId=null; 
	    if(patients.searchPatient(patientName, mobileNumber).equals(""))
	    {
	    	System.out.println("New Patient.");
	    	System.out.print("Enter Patient age :");
	    	int age=scanner.nextInt();
	    	patientId=idCreator(patients);
	    	Patient patient=new Patient();
	    	patient.setName(patientName);
	    	patient.setMobileNumber(mobileNumber);
	    	patient.setId(patientId);
	    	patient.setAge(age);
	    	patients.addPatient(patient);
	    	FileWriter fWrite;
			try {
				fWrite = new FileWriter(filePatients);
				fWrite.write(JsonConversion.javaToJson(patients));
		    	fWrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    else
	    	patientId=patients.patientId(patientName, mobileNumber);
	    
	    Appointment appointment=new Appointment();
	    appointment.setPatientId(patientId);
	    appointment.setDate(date);
	    appointment.setPatientName(patientName);
	    appointment.setDoctorName(doctorName);
	    appointment.setDoctorId(doctors.doctorsId(doctorName, specialization));
	    appointment.setAvailability(doctors.availabilityOfDoctor(doctorName, specialization));
	    appointments.addAppointment(appointment);
	    FileWriter fWrite;
		try {
			fWrite = new FileWriter(fileAppointment);
			fWrite.write(JsonConversion.javaToJson(appointments));
	    	fWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\nAppointment done successfully.");
		System.out.println("\nDoctor Name : "+doctorName+",\nDoctor Id : "+doctors.doctorsId(doctorName, specialization)+
				",\nPatient Name : "+patientName+",\nPatient Mobile Number : "+mobileNumber+
				",\nPatient Id : "+patientId+",\nDate of Appointment : "+date+",Appointment At : "+doctors.availabilityOfDoctor(doctorName, specialization));
        System.out.println("Popular Doctor of clinique is : "+popularDoctor());
        System.out.println("Popular Specialization Of Clinique is : "+popularSpecialization());
	}
	else
		System.out.println("Doctor is not available on "+date);
		
}

private static String idCreator(PatientList patients) {
	ArrayList<Patient> patients2=patients.getPatients();
	return (patients2.size()+1)+"/"+LocalDate.now();
}

public static void searchPatient() {
	@SuppressWarnings("resource")
	Scanner scanner=new Scanner(System.in);
	System.out.print("\nEnter Patient Name : ");
	String name=scanner.nextLine();
	System.out.print("Enter Patient Mobile number : ");
	String mobileNumber=scanner.nextLine();
	System.out.print("Enter Date : ");
	String date=scanner.nextLine();
	
	File filePatients=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/PatientsJson.json");
    PatientList patient=JsonConversion.jsonToJava(filePatients, PatientList.class);
    if(!patient.searchPatient(name, mobileNumber).equals(""))
    {
    	System.out.println(patient.searchPatient(name, mobileNumber));
        File fileAppointment=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/Doctor'sAppointmentJson.json");
        AppointmentList appointment=JsonConversion.jsonToJava(fileAppointment, AppointmentList.class);
        if(appointment.checkAppointmentOfpatient(name, mobileNumber,date))
        	System.out.println("\nAppointment is on : "+date+"\nDoctor name : "+appointment.doctorname()+"\nAvailability at : "+appointment.availability());
        else
        	System.out.println("\nAppointment is not on : "+date);
    }
    else
    	System.out.println("\nNo such patient present in our clinique.");
    
    }

public static void searchDoctor() {
	@SuppressWarnings("resource")
	Scanner scanner=new Scanner(System.in);
	System.out.print("\nEnter doctor Name : ");
	String name=scanner.nextLine();
	System.out.print("Enter doctor Specialization : ");
	String specialization=scanner.nextLine();
	System.out.print("Enter Date : ");
	String date=scanner.nextLine();
	
	File fileDoctors=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/DoctorsJson.json");
	DoctorsList doctor=JsonConversion.jsonToJava(fileDoctors, DoctorsList.class);
	if(!doctor.searchDoctor(name,specialization).equals(""))
	{
		System.out.println(doctor.searchDoctor(name,specialization));
		File fileAppointment=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/Doctor'sAppointmentJson.json");
		AppointmentList appointment=JsonConversion.jsonToJava(fileAppointment, AppointmentList.class);
		if(appointment.checkAvailabilityOfDoctor(name, specialization,date))
			System.out.println("\nDoctor is available on : "+date);
		else
			System.out.println("\nDoctor is not available on : "+date);
	}
	else
		System.out.println("\nNo such doctor present in our clinique.");
	
	
}
}

