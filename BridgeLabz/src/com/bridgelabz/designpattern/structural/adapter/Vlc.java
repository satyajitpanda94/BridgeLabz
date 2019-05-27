package com.bridgelabz.designpattern.structural.adapter;

public class Vlc implements AdvancedMediaPlayer{

	@Override
	public void play(String mediaFile) {
		System.out.println("Playing vlc media file. File : "+mediaFile);
	}

}
