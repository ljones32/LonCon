import java.util.HashMap;

public class ShortStory implements IStory{
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public enum NodeLabels{ AtForest, ForestBanditDialouge, AtCrossroads, AtStonepath, AtRuins, WitchDialouge, AtCity, AtCottage, WitchTalk, , AtDungeon, PracticeDarkMagic, EscapeFireDungeon, 
		MagicfightWitch, Winfight, Loosefight, DrinkHealingPotion, LockPickEscapeDungeon,  TakeScroll, BanditDialouge, TakeSword,  AtCastle, AtLibrary, GiveLovepotionToWitch,
		AtAlchemyshop, AlchemistDialouge, PoisonKing, PoisonWitch, KingDialouge, AcceptEvilCrown, AcceptGoodCrown }
	public enum ChoiceLabels{TalkToForestBandit, DrinkPotion, ReadBook, TakeSword, StealPoison, PayForPoison, TalkToWitch, TalkToBandit, TalkToKing, AcceptBanditQuest, DeclineBanditQuest, AcceptWitchQuest, DeclineWitchQuest, MagicFight, FistFight, SwordFight }
	public enum Cnames{ Player, Odin, Lilith, Kingarthur}
	public enum Pnames {Forest, Bridge, Ruins, CastleCrossroads, Dungeon, Cottage, AlchemyShop, GreatHall, Library, Hallway, Castlebedroom, Spookypath, City}
	public enum Inames {PurplePotion, Chest, EvilBook, Scroll, Sword, JewelKey, SpellBook, Altar, Skull, RedPotion}
	HashMap<Cnames, Character> clist = new HashMap<>();
	HashMap<Pnames, Place> plist = new HashMap<>();
	HashMap<Inames, Item> ilist = new HashMap<>();
	
	 
	
	public ShortStory() {
		getThings();
	}
	public void getThings() {
		clist.put(Cnames.Player, new Character(Cnames.Player.toString(), Character.BodyTypes.B, Character.Clothing.Peasant));
		clist.put(Cnames.Odin, new Character(Cnames.Odin.toString(), Character.BodyTypes.B, Character.Clothing.Bandit));
		clist.put(Cnames.Lilith, new Character(Cnames.Lilith.toString(), Character.BodyTypes.E, Character.Clothing.Witch));
		clist.put(Cnames.Kingarthur, new Character(Cnames.Kingarthur.toString(), Character.BodyTypes.H, Character.Clothing.King));
		plist.put(Pnames.Forest, new Place(Pnames.Forest.toString(), Place.Places.ForestPath));
		plist.put(Pnames.City, new Place(Pnames.City.toString(), Place.Places.City));
		plist.put(Pnames.Cottage, new Place(Pnames.Cottage.toString(), Place.Places.Cottage));
		plist.put(Pnames.CastleCrossroads, new Place(Pnames.CastleCrossroads.toString(), Place.Places.CastleCrossroads));
		plist.put(Pnames.Library, new Place(Pnames.Library.toString(), Place.Places.Library));
		plist.put(Pnames.Hallway, new Place(Pnames.Hallway.toString(), Place.Places.Hallway));
		plist.put(Pnames.GreatHall, new Place(Pnames.GreatHall.toString(), Place.Places.GreatHall));
		plist.put(Pnames.Ruins, new Place(Pnames.Ruins.toString(), Place.Places.Ruins));
		plist.put(Pnames.AlchemyShop, new Place(Pnames.AlchemyShop.toString(), Place.Places.AlchemyShop));
		plist.put(Pnames.Dungeon, new Place(Pnames.Dungeon.toString(), Place.Places.Dungeon));
		ilist.put(Inames.Chest, new Item(Inames.Chest.toString(), Item.Items.Chest));
		ilist.put(Inames.EvilBook, new Item(Inames.EvilBook.toString(), Item.Items.EvilBook));
		ilist.put(Inames.Scroll, new Item(Inames.Scroll.toString(), Item.Items.Scroll));
		ilist.put(Inames.PurplePotion, new Item(Inames.PurplePotion.toString(), Item.Items.PurplePotion));
		ilist.put(Inames.Sword, new Item(Inames.Sword.toString(), Item.Items.PurplePotion));
		ilist.put(Inames.SpellBook, new Item(Inames.SpellBook.toString(), Item.Items.SpellBook));
		ilist.put(Inames.JewelKey, new Item(Inames.JewelKey.toString(), Item.Items.JewelKey));
		ilist.put(Inames.RedPotion, new Item(Inames.RedPotion.toString(), Item.Items.RedPotion));
		ilist.put(Inames.Skull, new Item(Inames.Skull.toString(), Item.Items.Skull));
		
	}
		
	
		//chest = new Item(ThingNames.Chest,Items.Chest);
		//evilbook = new Item(ThingNames.Evilbook, Items.EvilBook);
	//	city = new Place(ThingNames.City, Places.City);
	//	door = new Item(ThingNames.Door, Items.LockedDoor);
//		
	//	bed = new Item(ThingNames.Bed, Items.Bed);
//		lilith = new Character(ThingNames.Lilith)
//		spookypath = new Place(ThingNames.Spookypath, Places.SpookyPath);
//		castlecrossroads = new Place(ThingNames.Castlecrossroads, Places.CastleCrossroads);
	//	castlebedroom = new Place(ThingNames.Castlebedroom, Places.CastleBedroom);
//		hallway = new Place(ThingNames.Hallway, Places.Hallway);
//		library = new Place(ThingNames.Library, Places.Library);
//		dungeon = new Place(ThingNames.Dungeon, Places.Dungeon);
	//	juulkey = new Item(ThingNames.Juulkey, Items.JewelKey);
	//	ruins = new Place(ThingNames.Ruins, Places.Ruins);
//		spellbook = new Item(ThingNames.Spellbook, Items.SpellBook);)
//		greathall = new Place(ThingNames.Greathall, Places.GreatHall);
	//	kingarthur = new Character(ThingNames.KingArthur);
	//	altar = new Item(ThingNames.Altar, Items.Altar);
//		scroll = new Item(ThingNames.Scroll, Items.Scroll);
//		sword = new Item(ThingNames.Sword, Items.Sword);
	
	//	alchemyshop = new Place(ThingNames.Alchemyshop, Places.AlchemyShop);
	//	lockeddoor = new Item(ThingNames.Lockeddoor, Items.LockedDoor);
	//	throne = new Item(ThingNames.Throne, Items.Throne);
	//	poison = new Item(ThingNames.Poison, Items.Poison);
	//	skull = new Item(ThingNames.Skull, Items.Skull);
		
		
	@Override
	public ActionMap getMap() {
		var map = new ActionMap();
		map.add(NodeLabels.AtForest.toString(), getAtForest());
		map.add(NodeLabels.ForestBanditDialouge.toString(), getForestBanditDialouge());
		map.add(NodeLabels.AtCrossroads.toString(), getAtCrossroads());
		map.add(NodeLabels.AtStonepath.toString(), getAtStonepath());
		map.add(NodeLabels.AtRuins.toString(), getAtRuins());
		map.add(NodeLabels.WitchDialouge.toString(), getWitchDialouge());
		map.add(NodeLabels.AtCity.toString(), getAtCity());
		map.add(NodeLabels.AtCottage.toString(), getAtCottage());
		map.add(NodeLabels.WitchTalk.toString(), getWitchTalk());
		map.add(NodeLabels.AtDungeon.toString(), getAtDungeon());
		map.add(NodeLabels.EscapeFireDungeon.toString(), getEscapeFireDungeon());
		map.add(NodeLabels.MagicfightWitch.toString(), getMagicfightWitch());
		map.add(NodeLabels.Winfight.toString(), getWinfight());
		map.add(NodeLabels.Loosefight.toString(), getLoosefight());
		map.add(NodeLabels.DrinkHealingPotion.toString(), getDrinkHealingPotion());
		map.add(NodeLabels.LockPickEscapeDungeon.toString(), getLockPickEscapeDungeon());
		map.add(NodeLabels.TakeScroll.toString(), getTakeScroll());
		map.add(NodeLabels.TakeSword.toString(), getTakeSword());
		map.add(NodeLabels.BanditDialouge.toString(), getBanditDialouge());
		map.add(NodeLabels.AtCastle.toString(), getAtCastle());
		map.add(NodeLabels.AtLibrary.toString(), getAtLibrary());
		map.add(NodeLabels.GiveLovepotionToWitch.toString(), getGiveLovepotionToWitch());
		map.add(NodeLabels.AtAlchemyshop.toString(), getAtAlchemyShop());
		map.add(NodeLabels.AlchemistDialouge.toString(), getAlchemistDialouge());
		map.add(NodeLabels.PoisonKing.toString(), getPoisonKing());
		map.add(NodeLabels.PoisonWitch.toString(), getPoisonWitch());
		map.add(NodeLabels.KingDialouge.toString(), getKingDialouge());
		map.add(NodeLabels.AcceptEvilCrown.toString(), getAcceptEvilCrown());
		map.add(NodeLabels.AcceptGoodCrown.toString(), getAcceptGoodCrown());
		return map;
		
	}
	private ActionSequence getAtForest() {
		var sequence = new ActionSequence();
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var forest = plist.get(Pnames.Forest);
		var evilbook = ilist.get(Inames.Evilbook);
		var lovepotion = ilist.get(Inames.PurplePotion);
		sequence.add(new Create<Character>(vlad));
		sequence.add(new Create<Character>(odin));
		sequence.add(new setClothing(vlad));
		sequence.add(new setClothing(odin));
		sequence.add(new Create<Place>(forest));
		sequence.add(new Create<Place>(bridge));
		sequence.add(new Position(vlad, forest));
		sequence.add(new Position(odin, forest, "Well"));
		sequence.add(new Face(odin, vlad));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Create<Item>(lovepotion));
		sequence.add(new Position(evilbook, forest, "DirtPile"));
		sequence.add(new Position(lovepotion, forest, "PathBlock"));)
		sequence.add(new SetCameraFocus(vlad));
		sequence.add(new ShowMenu());
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput());
		return sequence;
	}
	private ActionSequence getForestBanditDialouge() {
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var sequence = new ActionSequence();
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(odin));
		sequence.add(new SetDialog("Do you want to Drink the Potion or read the Evil Book"));
		sequence.add(new SetDialog("Love Potion"));
		sequence.add(new SetDialog("Evil Book"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence DrinkPotion() {	
		var lovepotion = ilist.get(Inames.PurplePotion);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new Drink(vlad, lovepotion));
		sequence.add
		
		
	}
}
