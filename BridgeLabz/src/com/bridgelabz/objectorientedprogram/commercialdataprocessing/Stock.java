package com.bridgelabz.objectorientedprogram.commercialdataprocessing;

public class Stock {
	private String stockSymbol;
	private double pricePerShare;
	private int numberOfShares;

	public String getStockSymbol() {
		return stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}

	public double getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(double pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public int getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

}
class StocksArr {
	Stock stocks[];

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	public double sharePrice(String stockSymbol)
	{
		double sharePrice=0.0;
		for(Stock stock:stocks)
		{
			if(stock.getStockSymbol().equals(stockSymbol))
			{
				sharePrice=stock.getPricePerShare();
				break;
			}
		}
		return sharePrice;
	}
	

	public void numberOfShares(String stockSymbol,int amount)
	{
		for(Stock stock:stocks)
		{
			if(stock.getStockSymbol().equals(stockSymbol))
			{
				stock.setNumberOfShares(stock.getNumberOfShares()+amount);;;
				break;
			}
		}
	}

	
}
