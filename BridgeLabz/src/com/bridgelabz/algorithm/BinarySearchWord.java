package com.bridgelabz.algorithm;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Read in a list of words from File. Then prompt the user to enter a word to
search the list. The program reports if the search word is found in the list.
**/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchWord {
public static void main(String[] args) throws FileNotFoundException  {
	File f=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/algorithm/BinarySearch Word Text file");
		Scanner sc=new Scanner(f);
		String s=sc.nextLine();
		String s1[]=s.split(",");
		Arrays.sort(s1);
		for(String s2:s1)
			System.out.print(s2+" ");
		System.out.println("\nEnter Word to search :");
		Scanner sc1=new Scanner(System.in);
		String word=sc1.nextLine();
		int bsw=Util.binarySearchWord(s1,word);
		 if(bsw==-1)
			 System.out.println("Word is not present in array.");
		 else
			 System.out.println("Index no is :"+bsw);
		sc.close();
		sc1.close();
	
	
}

}
