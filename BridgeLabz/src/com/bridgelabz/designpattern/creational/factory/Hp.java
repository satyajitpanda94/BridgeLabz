package com.bridgelabz.designpattern.creational.factory;

public class Hp extends Computer {
    
	public Hp(String ram, String hardDisk) {
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
