package com.actions;
import com.entities.Character;

public class Drink implements IAction
{
	Character c1;
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Drink(Character c1) {
		this.c1 = c1;
	}

}
