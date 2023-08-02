package com.hellosts;

public class SuperNinja extends Ninja {
	private boolean isInvisible;
	private Integer damageMultiplier;
	private String typeOfMartialArt;
	
	
	
	
	
	
	public SuperNinja(boolean isInvisible, Integer damageMultiplier, String typeOfMartialArt) {
		super();
		this.isInvisible = isInvisible;
		this.damageMultiplier = damageMultiplier;
		this.typeOfMartialArt = typeOfMartialArt;
	}
	
	
	//GETTERS AND SETTERS
	public boolean isInvisible() {
		return isInvisible;
	}
	public void setInvisible(boolean isInvisible) {
		this.isInvisible = isInvisible;
	}
	public Integer getDamageMultiplier() {
		return damageMultiplier;
	}
	public void setDamageMultiplier(Integer damageMultiplier) {
		this.damageMultiplier = damageMultiplier;
	}
	public String getTypeOfMartialArt() {
		return typeOfMartialArt;
	}
	public void setTypeOfMartialArt(String typeOfMartialArt) {
		this.typeOfMartialArt = typeOfMartialArt;
	}
}
