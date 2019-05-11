package oop;

import java.io.File;

public class StockReport {
	public static void main(String[] args) {

		StockArray sa = JsonUnit.jsonToJava(
				new File("/home/admin1/eclipse-workspace/BridgeLabz/src/oop/stockJsonFile.json"), StockArray.class);
		System.out.println(JsonUnit.javaToJson(sa) + "\nTotal value of Stock : " + sa.calTotalValue());

	}
}

class StockArray {
	Stock stock[];

	public Stock[] getStock() {
		return stock;
	}

	public void setStock(Stock[] stock) {
		this.stock = stock;
	}

	public double calTotalValue() {
		double total = 0.0;
		for (Stock i : stock) {
			total += i.getValueOfEachStock();
		}
		return total;
	}

}

class Stock {
	private String stockName;
	private int numberOfShares;
	private double sharePrice;

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

	public double getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(double sharePrice) {
		this.sharePrice = sharePrice;
	}

	public double getValueOfEachStock() {
		return numberOfShares * sharePrice;
	}
}
