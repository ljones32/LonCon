package com.actions;
import com.entities.Character;
import com.entities.Item;

public class Pocket implements IAction
{
	Character character;
	Item item;
	
	public Pocket(Character character, Item item) {
		this.character = character;
		this.item = item;
	}
	
	@Override
	public String getName() {
		return "Pocket";
	}
	
	@Override
	public boolean getShouldWait() {
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), item.getName());
	}
	
}
