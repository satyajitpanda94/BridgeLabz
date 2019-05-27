package com.bridgelabz.designpattern.structural.proxy;

public class RealImage implements Image {
private String image;

public RealImage(String image) {
	super();
	this.image=image;
	loadImage(image);
}

private void loadImage(String image) {
    System.out.println("Loading....."+image);	
}

@Override
public void dishPlay() {
    System.out.println("Image : "+image);	
}
}
