package com.actions;

import com.entities.Character;
import com.entities.Character.Hairstyles;

public class SetHairStyle implements IAction
{
	@Override
	public boolean getShouldWait() {
		return false;
	}
	
	/**
	 * @return SetClothing
	 */
	@Override
	public String getName() {
		return "SetHairStyle";
	}
	
	private Character character;
	/**
	 * Changes the outfit of a character to the outfit that was set when creating that character.
	 * If no outfit was set, the default outfit is Peasant.
	 * @param character The outfit of this character will change to their original outfit
	 */
	public SetHairStyle(Character character) {
		this.character=character;
		this.h1 = character.getHairStyle();
	}
	private Hairstyles h1;
	/**
	 * Changes the outfit of a character to another outfit
	 * @param character The outfit of this character will change
	 * @param clothing The new outfit of the character
	 */
	public SetHairStyle(Character character, Hairstyles h1) {
		this.character=character;
		this.h1=h1;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s(%s, %s)", getName(), character.getName(), h1.toString());
	}


}
