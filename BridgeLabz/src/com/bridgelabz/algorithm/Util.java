package com.bridgelabz.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Util {
public static boolean anagram(String s1,String s2)
{
	char[] c1=s1.toCharArray();
	char[] c2=s2.toCharArray();
	Arrays.sort(c1);
	Arrays.sort(c2);
	String s3=String.valueOf(c1);
	String s4=String.valueOf(c2);
	if(s3.equals(s4))
		return true;
	else
		return false;
}
public static ArrayList<Integer> primeNumber()
{
	ArrayList<Integer> a=new ArrayList<>();
	for(int i=0;i<=1000;i++)
	{
		int z=0;
		for(int j=2;j<=Math.sqrt(i);j++)
		{
			if(i%j==0)
			{
				z++;
				break;
			}
		}
		if(z==0 &&(i!=0) && i!=1)
			a.add(i);
	}
	return a;
}
public static int vandingMachine(int m,int l,int a[])
{
	if(m==0)
		return 0;
	int z=0;
	if(m/a[l]!=0)
	{
		z=m/a[l];
		System.out.println(a[l]+" rupee notes : "+z);
		m=m%a[l];
	}
	return z+vandingMachine(m, l-1, a);
}
public static int dayOfWeek(int month, int day, int year) {
	int y=year-(14-month)/12;
	int x=y+(y/4)-(y/100)+(y/400);
	int m=month+12*((14-month)/12)-2;
	int d=(day+x+((31*m)/12))%7;
	return d;
}
public static void temperaturConversion(double temp, char unit) {
	if(unit=='F')
	{
		double t=((temp-32)*5.0)/9;
		System.out.println("Temparature in Fahrenheit is :"+temp+"\n"+"Temparature in Celsius is :"+t);
	}
	else
	{
		double t=((temp*9.0)/5)+32;
		System.out.println("Temparature in Celsius is :"+temp+"\n"+"Temparature in Fahrenheit is :"+t);
	}
	
}
public static void monthlyPayment(double principal, int year, double interest) {
	int n=12*year;
	double r=interest/(12*100);
	double payment=(principal*r)/(1-Math.pow(1+r, -n));
	System.out.println("Your monthly payment would be : "+payment);
	
}
public static double sqrt(double num) {
	double epsilon=1e-15;
	double t=num;
	while(Math.abs(t-num/t)>epsilon*t)
	{
		t=(num/t+t)/2.0;
	}
	return t;
}
public static String toBinary(int num) {
	StringBuffer s=new StringBuffer();
	while(num>0)
	{
		s=s.append(num%2);
		num=num/2;
	}
	String s1=""+s.reverse();
	return s1;
}
public static void findYourNumber(Scanner sc, int[] a, int n) {
	int first=0,last=a.length-1;
	while(n>=1 && first<=last)
	{
		int mid=(first+last)/2;
		System.out.println("Is your number present between "+first+" & "+mid+", Enter yes or no.");
		String s=sc.nextLine();
		if(s.equals("no"))
		{
			first=mid+1;
		}
		else
			last=mid-1;
		n--;
	}
		System.out.println("Number is : "+first);
	
}
public static ArrayList<Integer> anagramPrime(ArrayList<Integer> primeNumber) {
	ArrayList<Integer> al=new ArrayList<>();
	for(int i:primeNumber)
	{
		int z=0;
		for(int j:primeNumber)
		{
			if(i==j)
				continue;
			String s1=""+i;
			String s2=""+j;
			if(Util.anagram(s1, s2)&& !al.contains(j))
			{
				z++;
				al.add(j);
			}
			
		}
		if(z>0 && !al.contains(i))
			al.add(i);
	}
	return al;
}

public static ArrayList<Integer> palindromePrime(ArrayList<Integer> primeNumber) {
	ArrayList<Integer> al=new ArrayList<>();
	for(int i:primeNumber)
	{
		int rev=0;
		int i1=i;
		while(i1>0)
		{
			rev=rev*10+(i1%10);
			i1=i1/10;
		}
		if(i==rev)
			al.add(i);
	}
	return al;
}

public static int binarySearchWord(String[] s1, String string) {
	int start=0,end=s1.length-1;
	while(start<=end)
	{
		int mid=start+(end-start)/2;
		if(s1[mid].equals(string))
			return mid;
		else if(string.compareTo(s1[mid])>0)
			start=mid+1;
		else
			end=mid-1;
	}
	return -1;
}
public static void insertionSort(String[] wordList) {
	for(int i=1;i<wordList.length;i++)
	{
		String key=wordList[i];
		int j=i-1;
		while(j>=0 && wordList[j].compareTo(key)>0)
		{
			wordList[j+1]=wordList[j];
			j--;
		}
		wordList[j+1]=key;
	}
}
public static void bubbleSort(int[] intList) {
	for(int i=0;i<intList.length;i++)
	{
		for(int j=i;j<intList.length;j++)
		{
			if(intList[i]>intList[j])
			{
				int temp=intList[i];
				intList[i]=intList[j];
				intList[j]=temp;
			}
		}
	}
	System.out.println("Sorted array is :");
	for(int k:intList)
		System.out.print(k+" ");
}
public static String binaryPadding(String binary) {
	String s2="00000000000000000000000000000000";
	binary=s2.substring(binary.length())+binary;
	return binary;
}
public static void findDecimal(String nb) {
	long z = Long.parseLong(nb);
	System.out.println(z);
	long num = 0;
	int i = 0;
	while (z > 0) {
		num = (int) (num + (z % 10) * Math.pow(2, i));
		i++;
		z = z / 10;
	}
	System.out.println("Number is : " + num);
}

public static String swapNibbles(String binary) {
	int z = 8;
	String s3 = "";
	while (z > 0) {
		String s1 = binary.substring(z * 4 - 4, z * 4);
		String s2 = binary.substring(z * 4 - 8, z * 4 - 4);
		s3 = s1 + s2 + s3;
		z -= 2;
	}
	return s3;
}

}
