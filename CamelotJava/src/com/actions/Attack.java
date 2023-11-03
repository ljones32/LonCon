package com.actions;
import com.entities.Character;


public class Attack implements IAction{
	String name;
	Character c1;
	Character c2;
	boolean b1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Attack(Character c1, Character c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public Attack(Character c1, Character c2, boolean b1) {
		this.c1 = c1;
		this.c2 = c2;
		this.b1 = b1;
	}
}
