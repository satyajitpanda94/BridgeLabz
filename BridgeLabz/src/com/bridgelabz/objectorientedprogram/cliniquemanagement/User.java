package com.bridgelabz.objectorientedprogram.cliniquemanagement;


import java.util.Scanner;



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
		Clinique.searchDoctor();
		break;
	case 2:
		Clinique.searchPatient();
		break;
	case 3:
		Clinique.takeAppointment();
		break;
	default:
		
	}
}
}
