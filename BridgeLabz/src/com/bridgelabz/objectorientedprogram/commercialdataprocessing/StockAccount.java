package com.bridgelabz.objectorientedprogram.commercialdataprocessing;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.bridgelabz.datastructure.Queue;
import com.bridgelabz.datastructure.Stack;
import com.bridgelabz.objectorientedprogram.JsonConversion;


public class StockAccount {
	private String accountNumber;
	private double accountBalance;
	private ArrayList<CompanyShares> companyShares=new ArrayList<CompanyShares>();
	
	LinkedList<CompanyShares> linkList=new LinkedList<CompanyShares>();
	Stack<String> stockSymbol=new Stack<String>();
	Stack<String> soldOrPurChased=new Stack<String>();
	Queue<String> dateAndTime=new Queue<String>();

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public ArrayList<CompanyShares> getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(ArrayList<CompanyShares> companyShares) {
		this.companyShares = companyShares;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double valueOf() {
		double totalValueOfAccount = this.accountBalance;
		int length=companyShares.size();
		for (int index=0;index<length;index++)
			totalValueOfAccount += (companyShares.get(index).getPricePerShare() * companyShares.get(index).getNumberOfShares());
		return totalValueOfAccount;
	}

	public void buy(int amount, String symbol) {
		String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/commercialdataprocessing/Stocks.json";
		StocksArr stock = JsonConversion.jsonToJava(new File(fileName), StocksArr.class);
		if (stock.sharePrice(symbol) * amount <= accountBalance) {
			CompanyShares share=new CompanyShares();
			share.setStockSymbol(symbol);
			stockSymbol.push(symbol);
			soldOrPurChased.push("purchased");
			share.setNumberOfShares(numOfstocksAfter(amount, symbol));
			share.setPricePerShare(stock.sharePrice(symbol));
			String date=""+new Date();
			share.setDateTimeOfTransaction(date);
			dateAndTime.enqueue(date);
			linkList.add(share);
			this.accountBalance-=(stock.sharePrice(symbol) * amount);
		} else
			System.out.println("Insufficient Balance to buy this stock.");
		stock.numberOfShares(symbol, amount*-1);
		try {
			FileWriter fw=new FileWriter(fileName);
			fw.write(JsonConversion.javaToJson(stock));
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int numberOfShares(String stockSymbol)
	{
		int shares=0;
		for(CompanyShares share:companyShares)
		{
			if(share.getStockSymbol().equalsIgnoreCase(stockSymbol))
			{
				shares=share.getNumberOfShares();
				break;
			}
		}
		return shares;
	}
	
	public void sell(int amount, String symbol)
	{
		String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/commercialdataprocessing/Stocks.json";
		StocksArr stock = JsonConversion.jsonToJava(new File(fileName), StocksArr.class);
//		System.out.println("\n...."+numberOfShares(symbol));
		if((numberOfShares(symbol)+amount)>=0)
		{
			this.accountBalance+=(stock.sharePrice(symbol) * amount);
			
			CompanyShares share=new CompanyShares();
			share.setStockSymbol(symbol);
			stockSymbol.push(symbol);
			soldOrPurChased.push("sold");
			share.setNumberOfShares(numOfstocksAfter(amount, symbol));
			share.setPricePerShare(stock.sharePrice(symbol));
			String date=""+new Date();
			share.setDateTimeOfTransaction(date);
			dateAndTime.enqueue(date);
			linkList.add(share);
			stock.numberOfShares(symbol, amount*-1);
			try {
				FileWriter fw=new FileWriter(fileName);
				fw.write(JsonConversion.javaToJson(stock));
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			System.out.println("You don't have sufficient amount of shares.");
		
	}


	public int numOfstocksAfter(int amount, String symbol) {
		int length=companyShares.size();
		for (int index=0;index<length;index++)
		{
			if (companyShares.get(index).getStockSymbol().equals(symbol)) {
				amount+=companyShares.get(index).getNumberOfShares();
				break;
			}
		}
		return amount;
	}
	public void update()
	{
		int l1=companyShares.size();
		int l=linkList.length;
		for(int index=0;index<l;index++)
		{
			CompanyShares temp=linkList.get(index);
			for(int innrIndex=0;innrIndex<l1;innrIndex++)
			{
				if(companyShares.get(innrIndex).getStockSymbol().equals(temp.getStockSymbol()))
				{
					companyShares.remove(innrIndex);
					l1--;
//					linkList.remove(index);
					break;
				}
			}
			companyShares.add(temp);
            l1++;
		}
	}
	public void save(String fileName)
	{
		try {
			update();
			FileWriter fileWriter = new FileWriter(new File(fileName));
			fileWriter.write(JsonConversion.javaToJson(this));
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void printReport()
	{
		String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/commercialdataprocessing/CompanySharesJson.json";
		StockAccount stock=JsonConversion.jsonToJava(new File(fileName), StockAccount.class);
		System.out.println(JsonConversion.javaToJson(stock));
		int l=stockSymbol.size();
		Stack<String> stockSymbol1=new Stack<String>();
		Stack<String> soldOrPurChased1=new Stack<String>();
		for(int i=0;i<l;i++)
		{
			stockSymbol1.push(stockSymbol.pop());
		    soldOrPurChased1.push(soldOrPurChased.pop());
		}
		for(int i=0;i<l;i++)
		{
			System.out.println(stockSymbol1.pop()+" is "+soldOrPurChased1.pop()+" on "+dateAndTime.dequeue());
		}
		
	}
	public void yourStocks()
	{
		for (CompanyShares companyShare:companyShares) {
			System.out.println(companyShare.getStockSymbol()+" : "+companyShare.getNumberOfShares());
		}
	}
}
