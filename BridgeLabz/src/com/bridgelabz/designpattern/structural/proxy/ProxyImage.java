package com.bridgelabz.designpattern.structural.proxy;

public class ProxyImage implements Image {
	private Image realImage;
	private String image;
	
	public ProxyImage(String image) {
		super();
		this.image = image;
	}

	@Override
	public void dishPlay() {
		if(realImage==null)
			realImage=new RealImage(image);
		realImage.dishPlay();
	}

}
