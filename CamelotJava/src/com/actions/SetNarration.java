package com.actions;

public class SetNarration implements IAction
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
		return false;
	}
	
	public SetNarration(String s1) {
		System.out.println(s1);
	}

}
