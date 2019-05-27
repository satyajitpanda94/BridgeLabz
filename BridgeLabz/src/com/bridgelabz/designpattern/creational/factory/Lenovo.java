package com.bridgelabz.designpattern.creational.factory;

public class Lenovo extends Computer{
    
	public Lenovo(String ram, String hardDisk) {
		super();
		this.ram = ram;
		this.hardDisk = hardDisk;
	}

	@Override
	public String getRam() {
		return ram;
	}

	@Override
	public String getHardDisk() {
		return hardDisk;
	}
 
}
