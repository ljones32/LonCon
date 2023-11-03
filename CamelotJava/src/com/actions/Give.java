package com.actions;
import com.entities.Character;
import com.entities.Item;

public class Give implements IAction
{
	Character character1;
	Character character2;
	Item item;
	
	public Give(Character character1, Item item, Character character2) {
		this.character1 = character1;
		this.character2 = character2;
		this.item = item;
	}
	
	@Override
	public String getName() {
		return "Give";
	}
	
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s, %s)", getName(), character1.getName(), character2.getName(), item.getName());
	}
}
