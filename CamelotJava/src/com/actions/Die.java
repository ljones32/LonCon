package com.actions;
import com.entities.Character;
public class Die implements IAction{
	String name;
	Character c1;
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
	public Die(Character c1) {
		this.c1 = c1;
	}
}
