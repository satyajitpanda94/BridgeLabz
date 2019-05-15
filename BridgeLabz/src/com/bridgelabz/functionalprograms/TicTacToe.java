package com.bridgelabz.functionalprograms;
/*
* created by: Satyajit Panda
* Date 10/04/2018
*
* Purpose: Write a Program to play a Cross Game or Tic­Tac­Toe Game. Player 1 is
the Computer and the Player 2 is the user. Player 1 take Random Cell that is the
Column and Row.
**/

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	static char c[][]=new char[3][3];
	static int z;
	
public static void main(String[] args) {
	for(int i=0;i<3;i++)
	{
		for(int j=0;j<3;j++)
		{
			c[i][j]='*';
		}
	}

	display();
	Scanner sc =new Scanner(System.in);
	System.out.println("Lets Start The Game.....");
	while(!win() && !lose() && !draw())
	{
		playerEnter(sc);
		computerEnter();
		display();
	}
	if(win())
		System.out.println("YOU WON");
	else if(lose())
		System.out.println("YOU LOST");
	else
		System.out.println("MATCH DRAWN");
	sc.close();
}

public static boolean draw() {
	if(z==9)
		return true;
	else
	    return false;
}

public static boolean lose() {
	return result('o');
}

public static boolean win() {
	return result('x');
}
public static boolean result(char d) {
	for(int i=0;i<3;i++)
	{
		if((c[i][0]==d && c[i][1]==d && c[i][2]==d)||(c[0][i]==d && c[1][i]==d && c[2][i]==d) || (c[0][0]==d && c[1][1]==d && c[2][2]==d)||(c[0][2]==d && c[1][1]==d && c[2][0]==d))
			return true;
	}
	return false;
}

private static void display() {
	for(int i=0;i<3;i++)
    {
		 for(int j=0;j<3;j++)
		 {
			 System.out.print(c[i][j]+" ");
		 }
		 System.out.println();
	}	
}

private static void computerEnter() {
	if(z<9) {
	Random r=new Random();
	int row=r.nextInt(3);
	int col=r.nextInt(3);
	while(c[row][col]=='x'||c[row][col]=='o')
	{
		row=r.nextInt(3);
		col=r.nextInt(3);
	}
	c[row][col]='o';
	z++;
	}
	else 
		return;
}

private static void playerEnter(Scanner sc) {
	System.out.println("Your Term...");
	int row;
	while (true) {
		try {
			System.out.println("Enter Row :");
			row=sc.nextInt();
			System.out.println("Enter Column :");
			int col=sc.nextInt();
			while(c[row][col]=='x'||c[row][col]=='o')
			{
				System.out.println("Already Occupied : Re-enter");
				row=sc.nextInt();
				col=sc.nextInt();
			}
			c[row][col]='x';
			z++;
			break;
		} catch (InputMismatchException e) {
			System.out.println("Invalid Enter,Enter Integer type data :");
//			clears buffer
			sc.next();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid Enter,Enterrd data can't be lesser than 0 or greater than 2.");
//			clears buffer
			sc.nextLine();
		}
		
	}
	
}
}