package functionalPrograms;

/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: User Input and Replace String Template “Hello <<UserName>>, How are you?”
**/

import java.util.Scanner;

public class ReplaceStringTemplate {
	public static void main(String[] args) {
		String template = "Hello <<UserName>>, How are you?";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name :");
		String name = sc.nextLine();
		template = template.replace("<<UserName>>", name);
		sc.close();
		System.out.println(template);
	}
}
