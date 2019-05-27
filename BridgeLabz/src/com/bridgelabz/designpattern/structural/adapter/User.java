package com.bridgelabz.designpattern.structural.adapter;

public class User {
public static void main(String[] args) {
	MediaPlayer mediaPlayer=new AudioPlayer();
	mediaPlayer.play("VLC", "far far away.vlc");
	mediaPlayer.play("mp3", "alone.mp3");
	mediaPlayer.play("mp4", "beyond the horizon.mp4");
	mediaPlayer.play("AVI", "Something.avi");
}
}
