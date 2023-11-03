package com.actions;

public class SetDialog implements IAction{
	
	String name;
	public SetDialog(String s1) {
		System.out.println(s1);
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean getShouldWait() {
		// TODO Auto-generated method stub
		return true;
	}
}
