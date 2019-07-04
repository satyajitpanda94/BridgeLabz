package com.bridgelabz.designpattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private List<Observers> observers = new ArrayList<Observers>();
	private String message;

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
		notifyAllObservers();
	}

	public void attach(Observers observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observers observer : observers) {
			observer.update(message);
		}
	}
}
