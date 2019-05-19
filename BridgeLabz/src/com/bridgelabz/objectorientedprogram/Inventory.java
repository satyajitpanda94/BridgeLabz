package com.bridgelabz.objectorientedprogram;

public class Inventory {
	private String name;
	private double weight;
	private double pricePerKg;

	public String getName() {
		return name;
	}

	public double getWeight() {
		return weight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setPricePerKg(double pricePerKg) {
		this.pricePerKg = pricePerKg;
	}

	public double getPricePerKg() {
		return pricePerKg;
	}

	public double getTotalPrice() {
		return this.pricePerKg * this.weight;
	}
}


