package com.hellosts;

public class Ninja {
	//MEMBERS VARIABLES
	private int health;
	private String name;
	private int power;
	private boolean graduated;
	
	//CLASS VARIABLES
	private static int nbrOfNinjas = 0;
	public static int getNbrOfNinjas() {
		return nbrOfNinjas;
	}
	public static void setNbrOfNinjas(int nbrOfNinjas) {
		Ninja.nbrOfNinjas = nbrOfNinjas;
	}
	
	//CONSTRUCTOR
	public Ninja() {
		this.health = 120;
		this.name = "unknow";
		this.power = 10;
		this.graduated = false;
		nbrOfNinjas += 1;
		
	}
	public Ninja(int health, String name, int power, boolean graduated) {
		this.health = health;
		this.name = name;
		this.power = power;
		this.graduated = graduated;
		nbrOfNinjas += 1;
	}
	public void displayStats() {
		System.out.println(this.name);
		System.out.println(this.health);
		System.out.println(this.power);
		System.out.println(this.graduated);
	}
	
	//GETTERS AND SETTERS
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
}
