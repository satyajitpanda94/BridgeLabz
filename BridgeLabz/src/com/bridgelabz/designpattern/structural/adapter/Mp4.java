package com.bridgelabz.designpattern.structural.adapter;

public class Mp4 implements AdvancedMediaPlayer {

	@Override
	public void play(String mediaFile) {
		System.out.println("Playing mp4 media file. File : "+mediaFile);
	}

}
