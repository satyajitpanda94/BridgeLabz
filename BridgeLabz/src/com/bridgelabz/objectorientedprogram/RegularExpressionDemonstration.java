package com.bridgelabz.objectorientedprogram;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionDemonstration {
public static void main(String[] args) throws FileNotFoundException {
	Scanner sca=new Scanner(new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/RegexTextFile"));
	String massage="";
	while(sca.hasNext())
	    massage=massage+" "+sca.nextLine();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter Your Name, Phone Number, Present Date.");
	String name=sc.nextLine();
	String phno=sc.nextLine();
	String date=sc.nextLine();
	massage = regexReplace(massage, "<<name>>",name.split(" ")[0]);
	massage = regexReplace(massage, "<<full name>>",name);
	massage = regexReplace(massage, "x{10}",phno);
	massage = regexReplace(massage, "XX/XX/XXXX",date);
	System.out.println(massage);
	sc.close();
	sca.close();
}
public static String regexReplace(String massage,String stringToBeReplaced, String replaceString)
{
	Pattern replace=Pattern.compile(stringToBeReplaced);
	Matcher regexMatch=replace.matcher(massage);
	return regexMatch .replaceAll(replaceString);
}
}
