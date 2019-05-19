package com.bridgelabz.objectorientedprogram;

import java.io.File;

import com.bridgelabz.objectorientedprogram.commercialdataprocessing.CompanyShares;
import com.bridgelabz.objectorientedprogram.commercialdataprocessing.LinkedList;

public class Demo
{
	public static void main(String[] args) {
		String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/objectorientedprogram/commercialdataprocessing/CompanySharesJson.json";

		InventoryList1 invenObj = JsonConversion.jsonToJava(new File(fileName), InventoryList1.class);
		System.out.println(JsonConversion.javaToJson(invenObj));
	}
}
class InventoryList1 {
	String accountNumber;
	double accountBalance;
	LinkedList<CompanyShares> companyShares=new LinkedList<>();
    
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

	public LinkedList<CompanyShares> getCompanyShares() {
		return companyShares;
	}

	public void setCompanyShares(LinkedList<CompanyShares> companyShares) {
		this.companyShares = companyShares;
	}
	
}