package com.actions;

public class HideNarration implements IAction{
	String name;
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

	public HideNarration() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%s()",getName());
	}
}
