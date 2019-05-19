package com.bridgelabz.objectorientedprogram.deckofcards;

import java.util.Scanner;

public class Players {
private int numOfPlayers;
private int numOfCards;
public Players(int numOfPlayers, int numOfCards) {
	super();
	this.numOfPlayers = numOfPlayers;
	this.numOfCards = numOfCards;
}
public void printCards()
{
	DeckOfCards deckOfCards=new DeckOfCards(numOfPlayers, numOfCards);
	deckOfCards.shuffleCards();
	String cards[][]=deckOfCards.distributeCards();
	for(int index1=0;index1<numOfPlayers;index1++)
	{
		System.out.print("player "+(index1+1)+" : [ ");
		for(int index2=0;index2<numOfCards;index2++)
		{
			System.out.print(cards[index1][index2]+", ");
			
		}
		System.out.print("]\n");
	}
}
public static void main(String[] args) {
	System.out.print("Enter Number Of Players : ");
	Scanner scanner=new Scanner(System.in);
	int numOfPlayers=scanner.nextInt();
	System.out.print("Enter Number Of Cards Per Player : ");
	int numOfCards=scanner.nextInt();
	
	Players players=new Players(numOfPlayers, numOfCards);
	players.printCards();
	scanner.close();
}
}
