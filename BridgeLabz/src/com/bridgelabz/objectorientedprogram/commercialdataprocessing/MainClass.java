package com.bridgelabz.objectorientedprogram.commercialdataprocessing;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.bridgelabz.objectorientedprogram.JsonConversion;

public class MainClass {
public static void main(String[] args) {
	String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/commercialdataprocessing/CompanySharesJson.json";
	try {
		StockAccount stockAccount=JsonConversion.jsonToJava(new File(fileName), StockAccount.class);
		System.out.println("Your shares are :");
		stockAccount.yourStocks();
		Scanner scanner=new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter Stock Symbol to buy or sell : ");
			String stockSymbol=scanner.nextLine();
			System.out.print("Enter Number of shares to buy or sell (for sell enter -ve number) : ");
			int amount=scanner.nextInt();
			scanner.nextLine();
			if(amount>0)
			{
				stockAccount.buy(amount, stockSymbol);
			}
			else
			{
				stockAccount.sell(amount, stockSymbol);
			}
			stockAccount.save(fileName);
			stockAccount.printReport();
			System.out.println("Total value of Stock Account is : "+stockAccount.valueOf());
            System.out.println("Do you Want to Buy or Sell More Shares, write yes/no.");
            String yesOrNo=scanner.nextLine();
            if(yesOrNo.equals("no"))
            	break;
		}	
		scanner.close();
		
	} catch(InputMismatchException inputmismatch)
	{
		System.out.println("You Entered Invalid Data Type, Please Enter Integer Value for Number of Shares.");
	}
}
}
