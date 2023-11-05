package com.entities;

public class Place implements IThing<com.entities.Place.Places>{
	private String name;
	Places p1;
	
	public enum Places {
	AlchemyShop, Altar, Blacksmith, Bridge, Camp, CastleBedroom, CastleCrossroads, Chest, City, Cottage, Courtyard, DiningRoom, Dungeon, Farm, ForestPath, GreatHall, Hallway, Library, Port, Ruins, SpookyPath, SpookyCrossroads, Storage, Tavern }
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	@Override
	public Places getTemplate() {
		// TODO Auto-generated method stub
		return p1;
	}
	
	public Place(String name, Places p1) {
		this.name = name;
		this.p1 = p1;
	}
	
	

}