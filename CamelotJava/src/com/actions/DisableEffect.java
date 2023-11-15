package com.actions;
import com.entities.IEntity;
public class DisableEffect implements IAction{
	String name;
	IEntity e1;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "DisableEffect";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public DisableEffect(String name) {
		this.name = name;
	}
	
	public DisableEffect(String name, IEntity e1) {
		this.name = name;
		this.e1 = e1;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)",getName(), name, e1.getName());
	}

}
