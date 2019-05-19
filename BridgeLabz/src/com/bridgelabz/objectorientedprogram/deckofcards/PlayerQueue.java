package com.bridgelabz.objectorientedprogram.deckofcards;

import java.util.Scanner;

import com.bridgelabz.datastructure.Queue;

public class PlayerQueue {
Queue<String> playerCardsList=new Queue<String>();
Queue<String> players=new Queue<String>();
private static String deckOfCards[][];
private int numOfPlayers;
private int numOfCards;
public PlayerQueue(int numOfPlayers, int numOfCards) {
	super();
	this.numOfPlayers = numOfPlayers;
	this.numOfCards = numOfCards;
}
private void setDeckOfCards()
{
	DeckOfCards deck=new DeckOfCards(numOfPlayers, numOfCards);
	deck.shuffleCards();
	deckOfCards=deck.distributeCards();
}

private int hashFunction(String cardName)
{
	String stringArray[]=cardName.split(" ");
	String firstWord=stringArray[0];
	int hashCode=0;
	if(firstWord.equals("Jack"))
		hashCode=11;
	else if(firstWord.equals("Queen"))
		hashCode=12;
	else if(firstWord.equals("King"))
		hashCode=13;
	else if(firstWord.equals("Ace"))
		hashCode=14;
	else
	    hashCode=Integer.parseInt(firstWord);
	
	return hashCode;
}
private void sortPlayerCards(String playerCards[])
{
	for(int index=0;index<numOfCards;index++)
	{
		for(int index2=index+1;index2<numOfCards;index2++)
		{
			if(hashFunction(playerCards[index])>hashFunction(playerCards[index2]))
			{
				String temp=playerCards[index];
				playerCards[index]=playerCards[index2];
				playerCards[index2]=temp;
			}
		}
	}
}

private void sortAndInsertToQueue()
{
//	Queue<String> playerCardsList2=new Queue<String>();
	for(int index1=0;index1<numOfPlayers;index1++)
	{
		String playerCards[]=new String[numOfCards];
		for(int index2=0;index2<numOfCards;index2++)
		{
			playerCards[index2]=deckOfCards[index1][index2];
		}
		sortPlayerCards(playerCards);
		for(int index3=0;index3<numOfCards;index3++)
		{
			this.playerCardsList.enqueue(playerCards[index3]);
		}
		this.players.enqueue("Player "+(index1+1));
	}	
}

public void printPlayerCards()
{
	setDeckOfCards();
	sortAndInsertToQueue();
	System.out.print(players.dequeue()+" : [ ");
	int length=numOfCards*numOfPlayers;
	for(int index=0;index<length;index++)
	{
		System.out.print(playerCardsList.dequeue()+", ");
		if(index%numOfCards==(numOfCards-1)&& index!=length-1)
		{
			System.out.print("]\n"+players.dequeue()+" : [ ");
		}
	}
	System.out.print("]");
}
public static void main(String[] args) {
	System.out.print("Enter Number Of Players : ");
	Scanner scanner=new Scanner(System.in);
	int numOfPlayers=scanner.nextInt();
	System.out.print("Enter Number Of Cards Per Player : ");
	int numOfCards=scanner.nextInt();
	
	PlayerQueue players=new PlayerQueue(numOfPlayers, numOfCards);
	players.printPlayerCards();
	scanner.close();
}
}
