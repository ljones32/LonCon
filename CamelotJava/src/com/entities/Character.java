package com.entities;

public class Character implements IEntity, IThing<com.entities.Character.BodyType> {

	private String name;
	BodyType b1;
	Clothing c1;
	Hairstyles h1;
	
	public enum BodyType{
		A, B, C, D, E, F, G, H;
	}
	
	public BodyType getTemplate() {
		return b1;
	}
	
	public String getName() {
		return name;
	}
	
	public enum Clothing 
		{Bandit, Beggar, LightArmour, HeavyArmour, Merchant, Noble, Peasant, Priest, Witch}
	public enum Hairstyles 
		{Long, Spiky, Short}
	
	public Character(String name) {
		this.name = name;
	}
	
	public Character(String name, BodyType b1) {
		this.name = name;
		this.b1 = b1;
	}
	
	public Character(String name, BodyType b1, Clothing c1) {
		this.name = name;
		this.b1 = b1;
		this.c1 = c1;
	}
	
	public Character(String name, BodyType b1, Clothing c1, Hairstyles h1) {
		this.name = name;
		this.b1 = b1;
		this.c1 = c1;
		this.h1 = h1;
	}
	
	public Clothing getClothing() {
		return c1;
	}
}
 