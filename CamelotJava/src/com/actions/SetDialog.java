package com.actions;
import com.entities.Furniture;

public class SetDialog implements IAction{
	
	//String name;
	String dialog;
	
	public SetDialog(String dialog) {
		this.dialog = dialog;
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
		return String.format("%s(%s)", getName(), dialog);
	}
}
