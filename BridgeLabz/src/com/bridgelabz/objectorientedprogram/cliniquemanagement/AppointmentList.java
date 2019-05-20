package com.bridgelabz.objectorientedprogram.cliniquemanagement;

import java.io.File;
import java.util.ArrayList;

import com.bridgelabz.objectorientedprogram.JsonConversion;

public class AppointmentList {
	private String doctorname;
	private String availability;
	
	ArrayList<Appointment> appointments=new ArrayList<Appointment>();

	public String doctorname() {
		return doctorname;
	}

	public String availability() {
		return availability;
	}

	public ArrayList<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(ArrayList<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public boolean checkAppointmentOfpatient(String name,String mobileNumber,String date)
	{
		String id=findPatientId(name, mobileNumber);
		for(Appointment appoint:appointments)
		{
			if(appoint.getPatientId().equals(id)&& appoint.getDate().equals(date))
			{
				availability=appoint.getAvailability();
				doctorname=appoint.getDoctorName();
				return true;
			}
		}
		return false;
	}

	public boolean checkAvailabilityOfDoctor(String name,String specialiazation,String date)
	{
		String id=findDoctorsId(name, specialiazation);
		int count=0;
		for(Appointment appoint:appointments)
		{
			if(appoint.getPatientId().equals(id)&& appoint.getDate().equals(date))
				count++;
		}
		if(count==5)
			return false;
		return true;
	}
	
	private String findDoctorsId(String name,String specialiazation)
	{
		File fileDoctors=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/DoctorsJson.json");
		DoctorsList doctor=JsonConversion.jsonToJava(fileDoctors, DoctorsList.class);
		return doctor.doctorsId(name, specialiazation);
	}
	private String findPatientId(String name,String mobileNumber)
	{
		File filePatients=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/cliniquemanagement/PatientsJson.json");
	    PatientList patient=JsonConversion.jsonToJava(filePatients, PatientList.class);
	    return patient.patientId(name, mobileNumber);
	}
	public void addAppointment(Appointment appointment)
	{
		appointments.add(appointment);
	}
	
}
class Appointment{
	private String doctorId;
	private String doctorName;
	private String patientName;
	private String patientId;
	private String date;
	private String availability;
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
		
}

