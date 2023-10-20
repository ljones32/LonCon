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
		//evilbook = new Item(ThingNames.EvilBook, Items.EvilBook);
		//bridge = new Place(ThingNames.Bridge, Places.Bridge);
		city = new Place(ThingNames.City, Places.City);
		door = new Item(ThingNames.LockedDoor, Items.LockedDoor);
		cottage = new Place(ThingNames.Cottage, Items.Cottage);
		//lockpick = new Item(ThingNames.LockPick, Items.LockPick);
		bed = new Item(ThingNames.Bed, Items.Bed);
		lilith = new Character(ThingNames.Lilith)
		spookypath = new Place(ThingNames.SpookyPath, Places.SpookyPath);
		castlecrossroads = new Place(ThingNames.CastleCrossroads, Places.CastleCrossroads);
		castlebedroom = new Place(ThingNames.CastleBedroom, Places.CastleBedroom);
		hallway = new Place(ThingNames.Hallway, Places.Hallway);
		library = new Place(ThingNames.Library, Places.Library);
		dungeon = new Place(ThingNames.Dungeon, Places.Dungeon);
		//evilmagic = new Item(ThingNames.darkmagic, Items.darkmagic);
		//fire = new Effect(ThingNames.firespell, Effects.firespell);
		juulkey = new Item(ThingNames.JewelKey, Items.JewelKey);
		//lockchest = new Furniture(ThingNames.lockedchest);
		ruins = new Place(ThingNames.Ruins, Places.Ruins);
		spellbook = new Item(ThingNames.SpellBook, Items.SpellBook);
		altar = new furniture(ThingNames.Altar);
		//love = new Item(ThingNames.lovepotion);
		evilthrone = new Furniture(ThingNames.Throne)
		greathall = new Place(ThingNames.Greathall, Places.GreatHall);
		kingarthur = new Character(ThingNames.KingArthur);
		kingcrown = new Item(ThingNames.crown, Items.crown);
		
		
		
		
		
	}
		
	} 
}
