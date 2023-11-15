package com.actions;

public class SetDialog implements IAction{
	
	//String name;
	String text;
	public SetDialog(String s1) {
		text = s1;;
	}
	public String getName() {
		return "SetDialog";
	}
	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String toString() {
		return String.format("%s(%s)", getName(), text);
	}
}
