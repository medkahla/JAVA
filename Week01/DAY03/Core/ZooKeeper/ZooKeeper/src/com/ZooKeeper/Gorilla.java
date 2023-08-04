package com.ZooKeeper;

public class Gorilla extends Mammal {

	public Gorilla() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void throwThings(){
		System.out.println("Watch your head, the Gorilla throw something!");
		this.setEnergyLevel(this.getEnergyLevel()-5);
	}
	
	public void eatBanans() {
		System.out.println("Well... It's YUM!!");
		this.setEnergyLevel(this.getEnergyLevel()+10);
	}
	
	public void climb(){
		System.out.println("Climbing those trees is exhausting!");
		this.setEnergyLevel(this.getEnergyLevel()-10);
	}

}
