package com.actions;

public class SetNarration implements IAction
{
	//String name;
	String text;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "SetNarration";
	}

	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public SetNarration(String s1) {
		text = s1;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), text);
	}

}
