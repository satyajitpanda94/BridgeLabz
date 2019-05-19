package com.bridgelabz.objectorientedprogram.deckofcards;

import java.util.Random;

public class DeckOfCards {
private String cardSuits[]= {"Clubs","Diamonds","Hearts","Spades"};
private String cardRank[]= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
private String deckOfCards[]=new String[52];
private int numberOfPlayers;
private int numberOfCards;
public DeckOfCards(int numberOfPlayers, int numberOfCards) {
	super();
	this.numberOfPlayers = numberOfPlayers;
	this.numberOfCards = numberOfCards;
}
private void setCards()
{
	int indexOfSuits=0;
	int indexOfCardRank=0;
	for(int index=0;index<52;index++)
	{
		deckOfCards[index]=cardRank[indexOfCardRank]+" of "+cardSuits[indexOfSuits];
		indexOfCardRank++;
		if(indexOfCardRank==13)
		{
			indexOfSuits++;
			indexOfCardRank=0;
		}
	}
}
public void shuffleCards()
{
	setCards();
	Random random=new Random();
	for(int index1=0;index1<deckOfCards.length;index1++)
	{
		int index=random.nextInt(52);
		String temp=deckOfCards[index];
		deckOfCards[index]=deckOfCards[index1];
		deckOfCards[index1]=temp;
	}
}
public String[][] distributeCards()
{
	String distributedCard[][]=new String[numberOfPlayers][numberOfCards];
	int cardIndex=0;
	for(int index1=0;index1<numberOfPlayers;index1++)
	{
		for(int index2=0;index2<numberOfCards;index2++)
		{
			distributedCard[index1][index2]=deckOfCards[cardIndex];
			cardIndex++;
		}
	}
	return distributedCard;
}
}
