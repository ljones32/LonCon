package com.actions;
import com.entities.Character;
import com.entities.Item;
import com.entities.Place;

public class Drink implements IAction
{
	Character c1;
	Item i1;
	Place p1;
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Drink";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Drink(Character c1) {
		this.c1 = c1;
	}
	public Drink(Character c1, Item i1, Place p1, String name) {
		this.c1 = c1;
		this.i1 = i1;
		this.name = name;
		this.p1 = p1;
	}
	public Drink(Character c1, Item i1, Place p1) {
		this.c1 = c1;
		this.i1 = i1;
		this.p1 = p1;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)",getName(), c1.getName());
	}

}
