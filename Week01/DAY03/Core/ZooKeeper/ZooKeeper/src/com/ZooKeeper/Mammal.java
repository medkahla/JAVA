package com.ZooKeeper;

public class Mammal {

	private Integer energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public Mammal(int energy) {
		this.energyLevel = energy;
	}

	public Integer displayEnergyLevel() {
		System.out.println("Current energy level: "+this.energyLevel);
		return this.energyLevel;
	}

	public Integer getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(Integer energyLevel) {
		this.energyLevel = energyLevel;
	}
	
}
