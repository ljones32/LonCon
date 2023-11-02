import java.util.HashMap;
import com.storygraph.INode;
import com.storygraph.ActionMap;
import com.actions.ActionSequence;
import com.entities.*;
import com.entities.Character;
import com.playerInput.ActionChoice;
import com.actions.*;
import com.playerInput.*;
import com.storygraph.*;

public class ShortStory implements IStory{
	
	public INode getRoot() {
		return new Node("root");
	}
	
	public enum NodeLabels{ AtForest, FistFight, SwordFight, AgreetoFight, RejectFight, ForestBanditDialouge, DrinkPotion, ReadBook, AtSpookyroad, AtStonepath, At1stRuins, WitchDialouge, AtCity, AtCottage, WitchTalk, AcceptDarkQuest, RejectDarkQuest, AtDungeon, PracticeDarkMagic, EscapeFireDungeon, 
		MagicfightWitch, TakeSpellBook, Winfight, Loosefight, DrinkHealingPotion, LockPickEscapeDungeon,  TakeScroll, BanditDialouge, TakeSword,  AtCastle, AtLibrary, GiveLovepotionToWitch,
		AtAlchemyshop, AlchemistDialouge, PoisonKing, PoisonWitch, KingDialouge, AcceptEvilCrown, AcceptGoodCrown}
	public enum ChoiceLabels{ Leave, TalkToForestBandit, DrinkPotion, ReadBook, TakeSword, StealPoison, PayForPoison, TalkToWitch, TalkToBandit, TalkToKing, AcceptBanditQuest, DeclineBanditQuest, AcceptWitchQuest, DeclineWitchQuest, MagicFight} 
	public enum Cnames{ Player, Odin, Lilith, Kingarthur}
	public enum Pnames {Forest, Spookyroad, Ruins, CastleCrossroads, Dungeon, Cottage, AlchemyShop, GreatHall, Library, Hallway, Castlebedroom, City}
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
		plist.put(Pnames.Spookyroad, new Place(Pnames.Spookyroad.toString(), Place.Places.SpookyCrossroads));
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
		ilist.put(Inames.SpellBook, new Item(Inames.SpellBook.toString(), Item.Items.SpellBook));
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
		map.add(NodeLabels.DrinkPotion.toString(), getDrinkPotion());
		map.add(NodeLabels.ReadBook.toString(), getReadBook());
		map.add(NodeLabels.AtSpookyroad.toString(), getAtSpookyroad());
		map.add(NodeLabels.At1stRuins.toString(), getAt1stRuins());
		map.add(NodeLabels.WitchDialouge.toString(), getWitchDialouge());
		map.add(NodeLabels.AgreetoFight.toString(), getAgreetoFight());
		map.add(NodeLabels.FistFight.toString(), getFistFight());
		map.add(NodeLabels.SwordFight.toString(), getSwordFight());
		map.add(NodeLabels.RejectFight.toString(), getRejectFight());
		map.add(NodeLabels.AtCity.toString(), getAtCity());
		map.add(NodeLabels.TakeSpellBook.toString(), getTakeSpellBook());
		map.add(NodeLabels.AtCottage.toString(), getAtCottage());
		map.add(NodeLabels.WitchTalk.toString(), getWitchTalk());
		map.add(NodeLabels.AcceptDarkQuest.toString(), getAcceptDarkQuest());
		map.add(NodeLabels.RejectDarkQuest.toString(), getRejectDarkQuest());
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
		var evilbook = ilist.get(Inames.EvilBook);
		var lovepotion = ilist.get(Inames.PurplePotion);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var spookyroad = plist.get(Pnames.Spookyroad);
		var home = plist.get(Pnames.Cottage);
		var scroll = ilist.get(Inames.Scroll);
		var city = plist.get(Pnames.City);
		var dungeon = plist.get(Pnames.Dungeon);
		var castlebedroom = plist.get(Pnames.Castlebedroom);
		var spellbook = ilist.get(Inames.SpellBook);
		var sword = ilist.get(Inames.Sword);
		sequence.add(new Create<Item>(sword));
		sequence.add(new Create<Place>(home));
		sequence.add(new Create<Place>(dungeon));
		sequence.add(new Create<Place>(castlebedroom));
		sequence.add(new Create<Item>(spellbook));
		sequence.add(new Create<Item>(scroll));
		sequence.add(new Create<Place>(ruins));
		sequence.add(new Create<Character>(vlad));
		sequence.add(new Create<Character>(odin));
		sequence.add(new Create<Character>(lilith));
		sequence.add(new SetClothing(lilith));
		sequence.add(new setClothing(vlad));
		sequence.add(new setClothing(odin));
		sequence.add(new Create<Place>(city));
		sequence.add(new Create<Place>(forest));
		sequence.add(new Create<Place>(spookyroad));
		sequence.add(new Position(vlad, forest));
		sequence.add(new Position(odin, forest, "Well"));
		sequence.add(new Face(odin, vlad));
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Create<Item>(lovepotion));
		sequence.add(new Position(evilbook, forest, "DirtPile"));
		sequence.add(new Position(lovepotion, forest, "PathBlock"));
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
		sequence.add(new SetDialog("Do you want to Drink the Love Potion or read the Evil Book"));
		sequence.add(new SetDialog("Love Potion"));
		sequence.add(new SetDialog("Evil Book"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getDrinkPotion() {	
		var lovepotion = ilist.get(Inames.PurplePotion);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new Drink(vlad, lovepotion));
		return sequence;
	}
	private ActionSequence getReadBook() {
		var evilbook = ilist.get(Inames.EvilBook);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new Read(vlad, evilbook));	
		return sequence;
	}
	private ActionSequence getAtCity(){
		var vlad = clist.get(Cnames.Player);
		var forest = plist.get(Pnames.Forest);
		var city = plist.get(Pnames.City);
		var home = plist.get(Pnames.Cottage);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, forest.getFurniture("WestEnd"), true));	
		sequence.add(new Enter(vlad, city.getFurniture("NorthEnd"),true));
		sequence.add(new EnableInput());
		return sequence;
	}
	
	private ActionSequence getAtCottage() {
		var vlad = clist.get(Cnames.Player);
		var city = plist.get(Pnames.City);
		var home = plist.get(Pnames.Cottage);
		var dungeon = plist.get(Pnames.Dungeon);
		var castlebedroom = plist.get(Pnames.Castlebedroom);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		var vlad = clist.get(Cnames.Player);
		var home = plist.get(Pnames.Cottage);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, city.getFurniture("BlueHouseDoor"), true));
		sequence.add(new Enter(vlad, home.getFurniture("Door"), true));
		sequence.add(new Position(lilith, "Fireplace"));
		sequence.add(new Face(lilith, vlad));
		return sequence;
	}
	private ActionSequence getWitchTalk() {
		var lilith = clist.get(Cnames.Lilith);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(lilith));
		sequence.add(new SetDialog("I see you have found my book, you are the chosen one. If you successfuly complete it's tasks you can join the dark side and become Evil King"));
		sequence.add(new SetDialog("[Accept|I will Accept]"));
		sequence.add(new SetDialog("[Reject|No! I won't do it.]"));
		return sequence;
	}
	private ActionSequence getAcceptDarkQuest() {
		var vlad = clist.get(Cnames.Player);
		var hallway = plist.get(Pnames.Hallway);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new SetNarration("Splendid, you also will have access to special powers like teleportation and other magicks"));
		sequence.add(new ShowNarration());
		sequence.add(new Position(vlad, hallway));
		return sequence;
	}
	
	private ActionSequence getRejectDarkQuest() {
		var vlad = clist.get(Cnames.Player);
		var dungeon = plist.get(Pnames.Dungeon);
		var sequence = new ActionSequence();
		sequence.add(new Position(vlad, dungeon));	
		sequence.add(new SetNarration("You have been banished by Lilith!"));h
		sequence.add(new ShowNarration());
		}
	private ActionSequence getAtLibrary() {
		var vlad = clist.get(Cnames.Player);
		var library = plist.get(Pnames.Library);
		var hallway = plist.get(Pnames.Hallway);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, hallway.getFurniture("BackDoor"), true));
		sequence.add(new Enter(vlad, library.getFurniture("Door"), true));
		sequence.add(new EnableInput());	
		return sequence;
		}
	private ActionSequence getTakeSpellBook() {
		var spellbook = ilist.get(Inames.SpellBook);
		var vlad = clist.get(Cnames.Player);
		
		
		
	}
	private ActionSequence getAtSpookyroad() {
		var vlad = clist.get(Cnames.Player);
		var spookyroad = plist.get(Pnames.Spookyroad);
		var sequence = new ActionSequence();
		var forest = plist.get(Pnames.Forest);
		var ruins = plist.get(Pnames.Ruins);
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, forest.getFurniture("EastEnd"), true));
		sequence.add(new Enter(vlad, spookyroad.getFurniture("WestEnd"), true));
		sequence.add(new EnableInput());
		return sequence; 
	}
	private ActionSequence getAt1stRuins() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var city = plist.get(Pnames.City);
		var dungeon = plist.get(Pnames.Dungeon);
		var sword = ilist.get(Inames.Sword);
		var ruins = plist.get(Pnames.Ruins);
		var spookyroad = plist.get(Pnames.Spookyroad);
		var scroll = ilist.get(Inames.Scroll);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, spookyroad.getFurniture("EastEnd"), true));
		sequence.add(new Enter(vlad, ruins.getFurniture("Exit"), true));
		sequence.add(new Position(lilith, ruins, "Throne"));
		sequence.add(new EnableInput());
		sequence.add(new Face(lilith, vlad));
		return sequence;
	}
	private ActionSequence getWitchDialouge() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(lilith));
		sequence.add(new SetDialog("How dare you enter my realm? I Challenge you to a fight! "));
		sequence.add(new SetDialog("[Agree to fight|Game On!]"));
		sequence.add(new SetDialog("[Reject to Fight|Hell No!]"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getAgreetoFight() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("Will you fight with fists or draw a sword?"));
		sequence.add(new SetDialog("[Sword Fight|I choose the sword!]"));
		sequence.add(new SetDialog("[Fist Fight|I'll take you with my hands!]"));
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getRejectFight() {
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		return sequence;
	}
	private ActionSequence getSwordFight() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var ruins = plist.get(Pnames.Ruins);
		var sword = ilist.get(Inames.Sword);
		var sequence = new ActionSequence();
		sequence.add(new Position(sword, ruins, "Chest"));
		sequence.add(new Draw(vlad, sword));
		sequence.add(new Attack(vlad, lilith, true));
		sequence.add(new Die(lilith));
		return sequence;
	}
	private ActionSequence getFistFight() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		sequence.add(new Attack(vlad, lilith, false));
		sequence.add(new Draw(lilith, Blackflame));
		sequence.add(new Attack(lilith, vlad, true));
		return sequence;
	}

	
}
