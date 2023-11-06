package com.actions;
import com.entities.Character;
import com.entities.Furniture;

public class Enter implements IAction{
	String name;
	Character c1;
	Furniture f1;
	boolean b1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Enter";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Enter(Character c1, Furniture f1, boolean b1) {
		this.c1 = c1;
		this.f1 = f1;
		this.b1 = b1;
	}
	
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), c1.getName(), f1.getName(), b1);
	}

}
