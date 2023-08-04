package com.ZooKeeper;

public class Bat extends Mammal {
	
	public Bat() {
		super(300);
	}
	
	public void fly(){
		this.setEnergyLevel(this.getEnergyLevel()-50);
	}
	
	public void eatHumans(){
		this.setEnergyLevel(this.getEnergyLevel()+25);
	} 
	
	public void attackTown() {
		this.setEnergyLevel(this.getEnergyLevel()-100);
	}

}
