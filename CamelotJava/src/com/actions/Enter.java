package com.actions;
import com.entities.Character;
import com.entities.Place;

public class Enter implements IAction{
	String name;
	Character c1;
	Place p1;
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
	
	public Enter(Character c1, Place p1, boolean b1) {
		this.c1 = c1;
		this.p1 = p1;
		this.b1 = b1;
	}

}
