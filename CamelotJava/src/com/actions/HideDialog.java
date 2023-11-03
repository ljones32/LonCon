package com.actions;

public class HideDialog implements IAction
{
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public HideDialog() {
		
	}

}
