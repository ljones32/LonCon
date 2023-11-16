package com.actions;

public class ShowDialog implements IAction
{
	String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "ShowDialog";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s()",getName());
	}

}
