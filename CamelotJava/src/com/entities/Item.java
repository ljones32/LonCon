package com.entities;

public class Item implements IEntity, IThing<com.entities.Item.Items>
{
	Items i1;
	private String name;
	
	
	public enum Items 
		{Apple, Bag, BlueBook, BlueCloth, BluePotion, Bottle, Bread, ChickenLeg, Compass, Cup, EvilBook, GoldCup, GreenBook, GreenKey, GreenPotion, Hammer, Helmet, InkandQuill, JewelKey, LitTorch, Lock, MagnifyingGlass, OpenScroll, PurpleBook, PurpleCloth, PurpleKey, PurplePotion, Rags, RedBook, RedCloth, RedKey, RedPotion, Scroll, Skull, SpellBook, Sword, Torch}

	@Override
	public Items getTemplate() {
		// TODO Auto-generated method stub
		return i1;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public Item(String name, Items i1) {
		this.name = name;
		this.i1 = i1;
	}
	
	
	

}
