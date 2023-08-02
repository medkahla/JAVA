package com.hellosts;

public class TestNina {

	public static void main(String[] args) {
		Ninja ninja1 = new Ninja(200, "Naruto", 20, true);
		Ninja ninja2 = new Ninja();
		
		ninja1.displayStats();
		ninja2.displayStats();

	}

}
