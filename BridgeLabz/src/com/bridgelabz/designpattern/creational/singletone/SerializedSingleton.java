package com.bridgelabz.designpattern.creational.singletone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializedSingleton implements Serializable {

private static final long serialVersionUID = 1L;
private SerializedSingleton() {}
private static class Helper{
	private static final SerializedSingleton instance=new SerializedSingleton();
}

public static SerializedSingleton getInstance()
{
	return Helper.instance;
}


public static void main(String[] args) {
	SerializedSingleton serializedSingleton=SerializedSingleton.getInstance();
	
	String fileName="/home/admin1/eclipse-workspace/BridgeLabz/src/com/bridgelabz/designpattern/creational/singletone/serializeFile.txt";
	try {
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream(fileName));
		objectOutputStream.writeObject(serializedSingleton);
		objectOutputStream.close();
		
		ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(fileName));
		SerializedSingleton serializedSingleton2=(SerializedSingleton) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(serializedSingleton.hashCode());
		System.out.println(serializedSingleton2.hashCode());
	} catch (IOException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
