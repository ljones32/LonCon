package com.entities;

import java.util.Hashtable;
import java.util.Optional;
public class Things {
	public enum ThingNames{ player, Forest, Chest, Evilbook, City, Cottage, Lilith, Spookypath, Castlecrossroads, Castlebedroom, Hallway, Library, Dungeon, Juulkey, Ruins, Spellbook, Greathall, KingArthur, Altar, Scroll, Sword, Odin, Alchemyshop, Skull } 
	private static Hashtable<ThingNames, IThing<?>> list=new Hashtable<>();
	public static boolean add(ThingNames name, IThing<?> thing) {
		if(list.containsKey(name)) {
			return false;
		}
		list.put(name, thing);
		return true;
	}
	
	public static Optional<IThing<?>> get(ThingNames name) {
		return Optional.ofNullable(list.get(name));
	}
}