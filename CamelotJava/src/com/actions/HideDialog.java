package com.actions;

public class HideDialog implements IAction
{
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "HideDialog";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public HideDialog() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%s",getName());
	}

}
