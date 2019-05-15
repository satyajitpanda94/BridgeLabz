package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Write a Stopwatch Program for measuring the time that elapses between
the start and end clicks.
**/

import java.util.Scanner;

public class StopWatch {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter 'START' to start the StopWatch");
	String s=sc.next();
	long startStopWatch=0,stopStopWatch = 0;
	if(s.equals("START"))
		startStopWatch=System.currentTimeMillis();
	System.out.println("Wait for some time and Enter 'STOP' to stop the StopWatch");
	s=sc.next();
	if(s.equals("STOP"))
		stopStopWatch=System.currentTimeMillis();
	int timeElapsed=(int) ((stopStopWatch-startStopWatch));
	int hour=timeElapsed/3600000;
	timeElapsed=timeElapsed%3600000;
	int min=timeElapsed/60000;
	timeElapsed=timeElapsed%60000;
	int sec=timeElapsed/1000;
	timeElapsed=timeElapsed%1000;
	System.out.println(hour+" : "+min+" : "+sec+" : "+timeElapsed);
	sc.close();
}
}
