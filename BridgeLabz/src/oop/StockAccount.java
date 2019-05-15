package oop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

interface StockAccountInterface
{
	public void stockAccount(String fileName);
	public double valueOf();
	public void buy(int ammount,String symbol);
	public void sell(int ammount,String symbol);
	public void save(String fileName);
	public void printReport();
}
public class StockAccount implements StockAccountInterface {

	String accountNumber;
	double accountBalance;
	ArrayList<Stock> sharesList=new ArrayList<Stock>();
	
	public static void main(String[] args) {
		String fileStockUser="/home/admin1/eclipse-workspace/BridgeLabz/src/oop/StockUser.json";
		
		StockAccount account=new StockAccount();
		account.stockAccount(fileStockUser);
		
	}
	
	@Override
	public void stockAccount(String fileName) {
		File file=new File(fileName);
		User user=JsonUtil.jsonToJava(file, User.class);
		
		
	}

	@Override
	public double valueOf() {
		
		return accountBalance;
	}

	@Override
	public void buy(int ammount, String symbol) {
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("/home/admin1/eclipse-workspace/BridgeLabz/src/oop/stockJsonFile.json"); 
		try {
			JsonNode rootNode=mapper.readTree(file);
			JsonNode stock=rootNode.path("stock");
			Iterator<JsonNode> iterator=stock.getElements();
			while(iterator.hasNext())
			{
				JsonNode stockNode=iterator.next();
				if(stockNode.path("stockName").asText().equals(symbol) && stockNode.path("sharePrice").asDouble()<=ammount)
				{
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void sell(int ammount, String symbol) {
		
		
	}

	@Override
	public void save(String fileName) {
		
		
	}

	@Override
	public void printReport() {
		
		
	}

}
class User
{
	private String accountNumber;
	private double accountBalance;
	private Share share[];
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Share[] getShare() {
		return share;
	}
	public void setShare(Share[] share) {
		this.share = share;
	}
}
class Share
{
	private String stockName;
	private int numberOfShares;
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
}

class CompanyShares
{
	private String stockSymbol;
	private int numberOfShares;
	private double sharePrice;
	private String dateTimeOfTransaction;
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getNumberOfShares() {
		return numberOfShares;
	}
	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}
	public double getSharePrice() {
		return sharePrice;
	}
	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}
	public String getDateTimeOfTransaction() {
		return dateTimeOfTransaction;
	}
	public void setDateTimeOfTransaction(String dateTimeOfTransaction) {
		this.dateTimeOfTransaction = dateTimeOfTransaction;
	}
	
}