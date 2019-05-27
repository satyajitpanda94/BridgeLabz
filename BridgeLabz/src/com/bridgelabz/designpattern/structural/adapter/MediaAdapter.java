package com.bridgelabz.designpattern.structural.adapter;

public class MediaAdapter implements MediaPlayer {

	@Override
	public void play(String mediaType, String mediaFile) {
		AdvancedMediaPlayer advancedMediaPlayer;
		if(mediaType.equalsIgnoreCase("vlc"))
		{
			advancedMediaPlayer=new Vlc();
			advancedMediaPlayer.play(mediaFile);
		}
		else
		{
			advancedMediaPlayer=new Mp4();
			advancedMediaPlayer.play(mediaFile);
		}
	}

}
