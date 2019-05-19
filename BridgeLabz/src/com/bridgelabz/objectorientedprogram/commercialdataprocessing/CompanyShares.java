package com.bridgelabz.objectorientedprogram.commercialdataprocessing;

public class CompanyShares {
private String stockSymbol;
private int numberOfShares;
private double pricePerShare;
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
public double getPricePerShare() {
	return pricePerShare;
}
public void setPricePerShare(double pricePerShare) {
	this.pricePerShare = pricePerShare;
}
public String getDateTimeOfTransaction() {
	return dateTimeOfTransaction;
}
public void setDateTimeOfTransaction(String dateTimeOfTransaction) {
	this.dateTimeOfTransaction = dateTimeOfTransaction;
}
}
