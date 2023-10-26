package camelot;

public class ShortStory {
	public interface IStory {
		ActionMap getMap();
		INode getRoot();
		void getThings();
	}
	public INode getRoot() {
		return new Node("root");
	}
	public void getThings() {
		vlad = new Character(ThingNames.Vlad);
		forest = new Place(ThingNames.ForestPath, Places.ForestPath);
		chest = new Item(ThingNames.Chest,Items.Chest);
		evilbook = new Item(ThingNames.EvilBook, Items.EvilBook);
		city = new Place(ThingNames.City, Places.City);
		door = new Item(ThingNames.LockedDoor, Items.LockedDoor);
		cottage = new Place(ThingNames.Cottage, Items.Cottage);
		bed = new Item(ThingNames.Bed, Items.Bed);
		lilith = new Character(ThingNames.Lilith)
		spookypath = new Place(ThingNames.SpookyPath, Places.SpookyPath);
		castlecrossroads = new Place(ThingNames.CastleCrossroads, Places.CastleCrossroads);
		castlebedroom = new Place(ThingNames.CastleBedroom, Places.CastleBedroom);
		hallway = new Place(ThingNames.Hallway, Places.Hallway);
		library = new Place(ThingNames.Library, Places.Library);
		dungeon = new Place(ThingNames.Dungeon, Places.Dungeon);
		juulkey = new Item(ThingNames.JewelKey, Items.JewelKey);
		ruins = new Place(ThingNames.Ruins, Places.Ruins);
		spellbook = new Item(ThingNames.SpellBook, Items.SpellBook);
		altar = new furniture(ThingNames.Altar);
		evilthrone = new Furniture(ThingNames.Throne)
		greathall = new Place(ThingNames.Greathall, Places.GreatHall);
		kingarthur = new Character(ThingNames.KingArthur);
		kingcrown = new Item(ThingNames.crown, Items.crown);
		altar = new Item(ThingNames.Altar, Items.Altar);
		scroll = new Item(ThingNames.Scroll, Items.Scroll);
		sword = new Item(ThingNames.Sword, Items.Sword);
		odin = new Character(ThingNames.Odin);
		alchemyshop = new Place(ThingNames.AlchemyShop, Places.AlchemyShop);
		lockeddoor = new Item(ThingNames.LockedDoor, Items.LockedDoor);
		throne = new Item(ThingNames.Throne, Items.Throne);
		poison = new Item(ThingNames.Poison, Items.Poison);
		spellbook = new Item(ThingNames.SpellBook, Items.SpellBook);
		greathall = new Place(ThingNames.GreatHall, Places.GreatHall);
		skull = new Item(ThingNames.Skull, Items.Skull);
		
		
		
		
		
	}
	private ActionSequence getInitSequence() {
		var sequence = new ActionSequence();
		sequence.combineWith(new CharacterCreation(vlad));
		sequence.add(new Create<Place>(forest));
		sequence.add(new Position(vlad, forest));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Create<Item>(lovepotion));
		sequence.add(new Position(evilbook, forest, "DirtPile"));
		sequence.add(new SetCameraFocus(vlad));
		sequence.add(new ShowMenu(true));
		
		return sequence;
	}
		
	} 
}
