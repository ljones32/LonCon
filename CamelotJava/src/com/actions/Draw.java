package com.actions;
import com.entities.Character;
import com.entities.Item;

public class Draw implements IAction{
	String name;
	Character c1;
	Item i1;
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
	
	public Draw(Character c1, Item i1) {
		this.c1 = c1;
		this.i1 = i1;
	}
}
