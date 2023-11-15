package com.actions;
import com.entities.Character;

public class Cast implements IAction{
	String name;
	Character c1;
	Character c2;
	String color;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Cast";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public Cast(Character c1, Character c2, String color) {
		this.c1 = c1;
		this.c2 = c2;
		this.color = color;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)",getName(), c1.getName(), c2.getName(), color);
	}

}
