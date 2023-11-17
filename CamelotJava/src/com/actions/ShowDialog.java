package com.actions;

import com.entities.Furniture;

public class ShowDialog implements IAction{
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
