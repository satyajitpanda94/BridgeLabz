package com.bridgelabz.designpattern.structural.proxy;

public class User {
public static void main(String[] args) {
	Image image=new ProxyImage("Morning Beauty.jpg");
	image.dishPlay();
	System.out.println();
	image.dishPlay();
	System.out.println();
	Image image2=new ProxyImage("Hearts.jpg");
	image2.dishPlay();
}
}
