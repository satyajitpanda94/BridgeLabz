package com.bridgelabz.functionalprograms;

/*
* created by: Satyajit Panda
* Date 25/04/2019
*
* Purpose: Gambler
   Desc ­> Simulates a gambler who start with $stake and place fair $1 bets until
   he/she goes broke (i.e. has no money) or reach $goal. Keeps track of the number of
   times he/she wins and the number of bets he/she makes. Run the experiment N
   times, averages the results, and prints them out.
   I/P ­> $Stake, $Goal and Number of times
   Logic ­> Play till the gambler is broke or has won
   O/P ­> Print Number of Wins and Percentage of Win and Loss.
**/
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gambler {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int stake;
		while (true) {
			try {
				System.out.println("Enter Stake :");
				stake = sc.nextInt();
				System.out.println("Enter Goal :");
				int goal = sc.nextInt();
				while (goal <= stake) {
					System.out.println("Goal can't be lesser than or equal to stake, so re-enter.");
					goal = sc.nextInt();
				}
				System.out.println("Enter Number Of Times You Want To Play :");
				int n = sc.nextInt();
				int win = 0;
				for (int i = 1; i <= n; i++) {
					int stakeForBid = stake;
					while (stakeForBid > 0 && stakeForBid < goal) {
						if (Math.random() > 0.5)
							stakeForBid++;
						else
							stakeForBid--;
					}
					if (stakeForBid == goal)
						win++;
				}
				double percentOfWin = (win * 100.0) / n;
				double percentOfLoss = 100.0 - percentOfWin;
				System.out.println("%age of win : " + percentOfWin + " & no of wins : " + win);
				System.out.println("%age of loss : " + percentOfLoss);
				sc.close();
				break;
			} catch (InputMismatchException e) {
				System.out.println("invalid Enter,Enter Integer type data :");
//				clears buffer
				sc.nextLine();
			}
		}

	}
}
