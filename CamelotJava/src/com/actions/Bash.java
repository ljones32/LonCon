package com.actions;
import com.entities.Character;

public class Bash implements IAction{
	String name;
	Character c1;
	Character c2;
	boolean b1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Bash";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Bash(Character c1, Character c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	public Bash(Character c1, Character c2, boolean b1) {
		this.c1 = c1;
		this.c2 = c2;
		this.b1 = b1;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)",getName(), c1.getName(), c2.getName(), b1);
	}
}
