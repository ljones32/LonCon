package com.actions;
import com.entities.Character;
public class Die implements IAction{
	String name;
	Character c1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Die";
	}

	@Override
	public boolean getShouldWait() {
		return true;
	}
	public Die(Character c1) {
		this.c1 = c1;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s)",getName(), c1.getName());
	}
}
