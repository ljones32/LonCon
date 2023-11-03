package com.actions;
import com.entities.Character;
import com.entities.IEntity;

public class Face implements IAction{
	Character c1;
	IEntity e1;
	
	public Face(Character c1, IEntity e1) {
		this.c1 = c1;
		this.e1 = e1;
	}
	
	@Override
	public String getName() {
		return "Face";
	}
	
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), c1.getName(), e1.getName());
	}
}
