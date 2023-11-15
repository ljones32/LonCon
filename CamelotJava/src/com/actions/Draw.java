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
		return "Draw";
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
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)",getName(), c1.getName(), i1.getName());
	}
}
