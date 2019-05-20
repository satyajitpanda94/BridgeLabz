package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


import com.bridgelabz.objectorientedprogram.JsonConversion;

public class User {
public static void main(String[] args) {
	System.out.println("What do you want to do, enter according to following information.");
	System.out.println("Enter 1 : To search Doctors by Name, Specialization.");
	System.out.println("Enter 2 : To search patient by name, mobile number.");
	System.out.println("Enter 3 : To take appointment.");
    @SuppressWarnings("resource")
	Scanner scanner= new Scanner(System.in);
    int switchCase=scanner.nextInt();
    switch (switchCase) {
	case 1:
		searchDoctor();
		break;
	case 2:
		searchPatient();
		break;
	case 3:
		takeAppointment();
		break;
	default:
		
	}
}

private static void takeAppointment() {
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
        System.out.println("Popular Doctor of clinique is : "+Clinique.popularDoctor());
        System.out.println("Popular Specialization Of Clinique is : "+Clinique.popularSpecialization());
	}
	else
		System.out.println("Doctor is not available on "+date);
		
}

private static String idCreator(PatientList patients) {
	ArrayList<Patient> patients2=patients.getPatients();
	return (patients2.size()+1)+"/"+LocalDate.now();
}

private static void searchPatient() {
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

private static void searchDoctor() {
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
