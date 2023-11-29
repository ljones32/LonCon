package com.actions;

import com.entities.Character;
public class Revive implements IAction{
	String name;
	Character c1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Revive";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	public Revive(Character c1) {
		this.c1 = c1;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)",getName(), c1.getName());
	}
}
