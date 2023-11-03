package com.entities;

public class Furniture implements IEntity 
{
	String f1;
	
	
	Furniture(String f1){
		this.f1 = f1;
	}
	
	public String getName() {
		return f1;
	}
	
}
