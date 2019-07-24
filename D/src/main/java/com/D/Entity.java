package com.D;

public class Entity {
	private int j;
	private String k;

	public Entity() {
	}

	public Entity(int j, String k) {
		super();
		this.j = j;
		this.k = k;
	}

	public String getK() {
		return k;
	}

	public void setK(String k) {
		this.k = k;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public void show() {
		System.out.println("I am in Entity...");
	}
}
