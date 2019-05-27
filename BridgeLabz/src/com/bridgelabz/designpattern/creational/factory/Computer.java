package com.bridgelabz.designpattern.creational.factory;

public abstract class Computer {
    protected String ram;
    protected String hardDisk;
    
    public abstract String getRam();
    public abstract String getHardDisk();
    
    @Override
    public String toString() {
	     return " RAM : " + getRam() + ", HardDisk : " + getHardDisk();
    }

}
