package com.bridgelabz.designpattern.structural.adapter;

public class AudioPlayer implements MediaPlayer {

	@Override
	public void play(String mediaType, String mediaFile) {
         if(mediaType.equalsIgnoreCase("mp3"))
        	 System.out.println("Playing mp3 file. File : "+mediaFile);
         else if(mediaType.equalsIgnoreCase("vlc")||mediaType.equalsIgnoreCase("mp4"))
         {
        	 MediaAdapter mediaAdapter=new MediaAdapter();
        	 mediaAdapter.play(mediaType, mediaFile);
         }
         else 
        	 System.out.println(mediaType+" format not supported.");
	}

}
