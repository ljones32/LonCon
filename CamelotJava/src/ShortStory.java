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
		var forest = plist.get(Pnames.Forest);
		var odin = clist.get(Cnames.Odin); 
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith); 
		var city = plist.get(Pnames.City);
		var spookyroad = plist.get(Pnames.Spookyroad); 
		var cottage = plist.get(Pnames.Cottage);
		var dungeon = plist.get(Pnames.Dungeon);
		
		var BecomeNewWitchKingNode = new Node(NodeLabels.BecomeNewWitchKing.toString());
			
		
		var WinFight2ndTimeNode = new Node(NodeLabels.WinFight2ndTime.toString());
		WinFight2ndTimeNode.addChild(new ActionChoice(ChoiceLabels.AcceptECrown.toString(),
			vlad,
			ActionChoice.Icons.crown,
			"Vlad is now the Evil King",
			true),
			BecomeNewWitchKingNode);
		
		var LoseFightNode = new Node(NodeLabels.Loosefight.toString());
		LoseFightNode.addChild(new ActionChoice(ChoiceLabels.DrinkPotion.toString(),
			vlad,
			ActionChoice.Icons.healingpotion,
			"Drink Healing Potion",
			true),
			WinFight2ndTimeNode);
		
		var WinFightNode = new Node(NodeLabels.Winfight.toString());
		WinFightNode.addChild(new ActionChoice(ChoiceLabels.AcceptECrown.toString(),
			vlad,
			ActionChoice.Icons.crown,
			"Vlad is now the Evil King",
			true),
			LoseFightNode);
		
		var RejectFightNode = new Node(NodeLabels.RejectFight.toString());
		RejectFightNode.addChild(new SelectionChoice(ChoiceLabels.Reject.toString()), WinFightNode);
		
		var fistfight = new Node(NodeLabels.FistFight.toString());
		var swordFight = new Node(NodeLabels.SwordFight.toString());
		var AgreetoFightNode = new Node(NodeLabels.AgreetoFight.toString());
	
		AgreetoFightNode.addChild(new ActionChoice(ChoiceLabels.FistFight.toString(),
			lilith,
			ActionChoice.Icons.fist,
			"Hit lilith",
			false),
			RejectFightNode);
		
		AgreetoFightNode.addChild(new SelectionChoice(ChoiceLabels.SwordFight.toString()), RejectFightNode);
		var WitchDialouge = new Node(NodeLabels.WitchDialouge.toString());
		WitchDialouge.addChild(new SelectionChoice(ChoiceLabels.TalkToWitch.toString()), new Node(NodeLabels.AgreetoFight.toString()));
		var atLibraryNode = new Node(NodeLabels.AtLibrary.toString());
		var WitchTalk = new Node(NodeLabels.WitchTalk.toString());
		
		
		var kingDialouge = new Node(NodeLabels.KingDialouge.toString());
		kingDialouge.addChild(new SelectionChoice(ChoiceLabels.TalktoKing.toString()), new Node(NodeLabels.BecomeNewKing.toString()));
	
		var AcceptGoodCrownNode = new Node(NodeLabels.AcceptGoodCrown.toString());
		AcceptGoodCrownNode.addChild(new ActionChoice(ChoiceLabels.TalktoKing.toString(),
				vlad, ActionChoice.Icons.talk,
				"Talk to King Arthur",
				true),
				kingDialouge);
		var AcceptEvilCrownNode = new Node(NodeLabels.BecomeEvilKing.toString());
		
		var FinalFightlilithNode = new Node(NodeLabels.FinalFightLilith.toString());
		FinalFightlilithNode.addChild(new SelectionChoice(ChoiceLabels.AcceptECrown.toString()),
				AcceptEvilCrownNode);
		FinalFightlilithNode.addChild(new SelectionChoice(ChoiceLabels.AcceptGCrown.toString()),
				AcceptGoodCrownNode);
		
		var RevengeNode = new Node(NodeLabels.GoToRuinsForRevenge.toString());
		RevengeNode.addChild(new ActionChoice(ChoiceLabels.Fight.toString(),
				vlad,
				ActionChoice.Icons.hurt,
				"Attack Lilith",
				true),
				FinalFightlilithNode);
		var AcceptDarkQuestNode = new Node(NodeLabels.AcceptDarkQuest.toString());
		AcceptDarkQuestNode.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),
				cottage.getFurniture("Door"),
				ActionChoice.Icons.exit,
				"Leave the house",
				true),
				atLibraryNode);
		var RejectDarkQuestNode = new Node(NodeLabels.RejectDarkQuest.toString());
		RejectDarkQuestNode.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),
				dungeon.getFurniture("Door"),
				ActionChoice.Icons.exit,
				"Leave the dungeon",
				true),
				RevengeNode);
		WitchTalk.addChild(new SelectionChoice(ChoiceLabels.Accept.toString()), 
				AcceptDarkQuestNode);
		WitchTalk.addChild(new SelectionChoice(ChoiceLabels.Reject.toString()),
				RejectDarkQuestNode);
		var atCottageNode = new Node(NodeLabels.AtCottage.toString());
		atCottageNode.addChild(new ActionChoice(ChoiceLabels.Talk2Witch.toString(),
				vlad,
				ActionChoice.Icons.talk,
				"Talk to Lilith",
				true),
				WitchTalk);
				
		var atCityNode = new Node(NodeLabels.AtCity.toString());
		atCityNode.addChild(new ActionChoice(ChoiceLabels.Enter.toString(),
				vlad,
				ActionChoice.Icons.enter,
				"Enter House",
				true),
				atCottageNode);
		var at1stRuins = new Node(NodeLabels.At1stRuins.toString());
		at1stRuins.addChild(new ActionChoice(ChoiceLabels.TalkToWitch.toString(),
				vlad,
				ActionChoice.Icons.talk,
				"Talk to Lilith",
				true),
				WitchDialouge);
		var atSpookyroad = new Node(NodeLabels.AtSpookyRoad.toString());
		atSpookyroad.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),
				spookyroad.getFurniture("WestEnd"),
				ActionChoice.Icons.exit,
				"Leave the spooky path",
				true), 
				at1stRuins);
		var DrinkPotion = new Node(NodeLabels.DrinkPotion.toString());
		DrinkPotion.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),
				forest.getFurniture("WestEnd"),
				ActionChoice.Icons.exit,
				"Leave the forest",
				true),
				atSpookyroad);
		var TakeBook = new Node(NodeLabels.TakeBook.toString());
		TakeBook.addChild(new ActionChoice(ChoiceLabels.Leave.toString(),
				forest.getFurniture("EastEnd"),
				ActionChoice.Icons.exit,
				"Leave the forest",
				true),
				atCityNode);
		var ForestBanditDialouge = new Node(NodeLabels.ForestBanditDialouge.toString());
		ForestBanditDialouge.addChild(new SelectionChoice(ChoiceLabels.DrinkPotion.toString()), 
				DrinkPotion);
		ForestBanditDialouge.addChild(new SelectionChoice(ChoiceLabels.TakeBook.toString()),
				TakeBook);	
		var atForestNode = new Node(NodeLabels.AtForest.toString());
		atForestNode.addChild(new ActionChoice(ChoiceLabels.TalkToBandit.toString(),
				odin,
				ActionChoice.Icons.talk,
				"Talk to odin",
				true),
				ForestBanditDialouge);
		return atForestNode; 
		
	}

	private enum NodeLabels{ AtForest, BecomeNewKing, ForestBanditDialouge, AtCrossroads, AtStonepath, AtRuins, WitchDialouge, AtCity, AtCottage, WitchTalk, AtDungeon, PracticeDarkMagic, EscapeFireDungeon, 
		MagicfightWitch, Winfight, Loosefight, DrinkHealingPotion, LockPickEscapeDungeon,  TakeScroll, BanditDialouge, TakeSword,  AtCastle, AtLibrary, GiveLovepotionToWitch,
		AtAlchemyshop, AlchemistDialouge, PoisonKing, PoisonWitch, KingDialouge, AcceptEvilCrown, AcceptGoodCrown, FinalFightLilith, BecomeEvilKing, WinFight2ndTime, DrinkPotion, ReadBook, AtSpookyRoad, At1stRuins, AgreetoFight, FistFight, SwordFight, RejectFight, TakeSpellBook, AcceptDarkQuest, RejectDarkQuest, GoToRuinsForRevenge, EscapeDungeon, BecomeNewWitchKing, GiveBookToLilith, TakeBook }
	public enum ChoiceLabels{Accept, Reject, Leave, AcceptECrown, AcceptGCrown, TalktoKing, Enter, TalkToForestBandit, DrinkPotion, TakeBook, TakeSword, StealPoison, PayForPoison, TalkToWitch, Talk2Witch, TalkToBandit, Fight, TalkToKing, AcceptBanditQuest, DeclineBanditQuest, AcceptWitchQuest, DeclineWitchQuest, MagicFight, FistFight, SwordFight }
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
		clist.put(Cnames.Player, new Character(Cnames.Player.toString(), Character.BodyType.B, Character.Clothing.Peasant));
		clist.put(Cnames.Odin, new Character(Cnames.Odin.toString(), Character.BodyType.B, Character.Clothing.Bandit));
		clist.put(Cnames.Lilith, new Character(Cnames.Lilith.toString(), Character.BodyType.E, Character.Clothing.Witch));
		clist.put(Cnames.Kingarthur, new Character(Cnames.Kingarthur.toString(), Character.BodyType.H, Character.Clothing.King));
		plist.put(Pnames.Forest, new Place(Pnames.Forest.toString(), Place.Places.ForestPath));
		plist.put(Pnames.Spookyroad, new Place(Pnames.Spookyroad.toString(), Place.Places.SpookyCrossroads));
		plist.put(Pnames.City, new Place(Pnames.City.toString(), Place.Places.City));
		ilist.put(Inames.RedPotion, new Item(Inames.RedPotion.toString(), Item.Items.RedPotion));
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
		map.add(NodeLabels.AtSpookyRoad.toString(), getAtSpookyroad());
		map.add(NodeLabels.At1stRuins.toString(), getAt1stRuins());
		map.add(NodeLabels.TakeBook.toString(), getTakeBook());
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
		map.add(NodeLabels.GoToRuinsForRevenge.toString(), getGoToRuinsForRevenge());
		//map.add(NodeLabels.EscapeDungeon.toString(), getEscapeDungeon());
		//map.add(NodeLabels.MagicfightWitch.toString(), getMagicfightWitch());
		//map.add(NodeLabels.Winfight.toString(), getWinfight());
		//map.add(NodeLabels.Loosefight.toString(), getLoosefight());
		map.add(NodeLabels.FinalFightLilith.toString(), getFinalFightLilith());
		//map.add(NodeLabels.DrinkHealingPotion.toString(), getDrinkHealingPotion());
		//map.add(NodeLabels.LockPickEscapeDungeon.toString(), getLockPickEscapeDungeon());
		map.add(NodeLabels.WinFight2ndTime.toString(), getWinFight2ndTime());
		//map.add(NodeLabels.TakeScroll.toString(), getTakeScroll());
		//map.add(NodeLabels.TakeSword.toString(), getTakeSword());
		//map.add(NodeLabels.BanditDialouge.toString(), getBanditDialouge());
		//map.add(NodeLabels.AtCastle.toString(), getAtCastle());
		map.add(NodeLabels.AtLibrary.toString(), getAtLibrary());
		//map.add(NodeLabels.GiveLovepotionToWitch.toString(), getGiveLovepotionToWitch());
		map.add(NodeLabels.BecomeNewWitchKing.toString(), getBecomeNewWitchKing());
		//map.add(NodeLabels.AtAlchemyshop.toString(), getAtAlchemyShop());
		//map.add(NodeLabels.AlchemistDialouge.toString(), getAlchemistDialouge());
		map.add(NodeLabels.GiveBookToLilith.toString(), getGiveBookToLilith());
		//map.add(NodeLabels.PoisonKing.toString(), getPoisonKing());
		//map.add(NodeLabels.PoisonWitch.toString(), getPoisonWitch());
		map.add(NodeLabels.BecomeEvilKing.toString(), getBecomeEvilKing());
		map.add(NodeLabels.KingDialouge.toString(), getKingDialouge());
		//map.add(NodeLabels.AcceptEvilCrown.toString(), getAcceptEvilCrown());
		map.add(NodeLabels.BecomeNewKing.toString(), getBecomeNewKing());
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
		var healingpotion = ilist.get(Inames.RedPotion);
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
		sequence.add(new Create<Item>(healingpotion));
		sequence.add(new Create<Character>(lilith));
		sequence.add(new SetClothing(lilith));
		sequence.add(new SetClothing(vlad));
		sequence.add(new SetClothing(odin));
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
		sequence.add(new ShowMenu(true));
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getForestBanditDialouge() {
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var sequence = new ActionSequence();
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(odin));
		sequence.add(new SetNarration("Talk to the Bandit Odin to Begin your Journey"));
		sequence.add(new ShowNarration());
		sequence.add(new SetDialog("Do you want to Drink the Love Potion or read the Evil Book"));
		sequence.add(new SetDialog("Love Potion"));
		sequence.add(new SetDialog("Evil Book"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getDrinkPotion() {	
		var lovepotion = ilist.get(Inames.PurplePotion);
		var vlad = clist.get(Cnames.Player);
		var forest = plist.get(Pnames.Forest);
		var sequence = new ActionSequence();
		sequence.add(new Create<Item>(lovepotion));
		sequence.add(new Position(lovepotion, forest, "PathBlock"));
		sequence.add(new HideDialog());
		sequence.add(new Take(vlad, lovepotion));
		sequence.add(new Drink(vlad));
		return sequence;
	}
	private ActionSequence getTakeBook() {
		var evilbook = ilist.get(Inames.EvilBook);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new Take(vlad, evilbook));	
		return sequence;
	}
	private ActionSequence getAtCity(){
		var vlad = clist.get(Cnames.Player);
		var forest = plist.get(Pnames.Forest);
		var city = plist.get(Pnames.City);
		var home = plist.get(Pnames.Cottage);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, forest.getFurniture("Exit"), true));	
		sequence.add(new Enter(vlad, city.getFurniture("city"), true));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getAtCottage() {
		var vlad = clist.get(Cnames.Player);
		var city = plist.get(Pnames.City);
		var home = plist.get(Pnames.Cottage);
		var dungeon = plist.get(Pnames.Dungeon);
		var castlebedroom = plist.get(Pnames.Castlebedroom);
		var lilith = clist.get(Cnames.Lilith);
		//var vlad = clist.get(Cnames.Player);
		//var home = plist.get(Pnames.Cottage);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, city.getFurniture("city"), true));
		sequence.add(new Enter(vlad, home.getFurniture("home"), true));
		sequence.add(new Position(lilith, home, "Fireplace"));
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
		sequence.add(new SetNarration("Splendid, Go to the library and bring me the spell book. You also will have access to special powers like teleportation and other magicks"));
		sequence.add(new ShowNarration());
		sequence.add(new Position(vlad, hallway));
		return sequence;
	}
	
	private ActionSequence getRejectDarkQuest() {
		var vlad = clist.get(Cnames.Player);
		var dungeon = plist.get(Pnames.Dungeon);
		var sequence = new ActionSequence();
		sequence.add(new Position(vlad, dungeon, "CellDoor"));	
		sequence.add(new SetNarration("You have been banished by Lilith!"));
		sequence.add(new ShowNarration());
		return sequence;
		}
	//private ActionSequence getEscapeDungeon() {
		//var vlad = clist.get(Cnames.Player);
		//var dungeon = plist.get(Pnames.Dungeon);
		//var sequence = new ActionSequence();
		//sequence.add(new Cast(vlad, door, red));
		//sequence.add(new SetNarration("Your powers are growing! Go to the ruins, defeat the witch and become the new king!"));
		//return sequence;
	//}
	private ActionSequence getGoToRuinsForRevenge() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		//sequence.add(new HideNarration());
		sequence.add(new Face(lilith, ruins.getFurniture("Altar")));
		//sequence.add(new DisableEffect(vlad, Blackflame));
		sequence.add(new Position(vlad, ruins));	
		sequence.add(new Position(lilith, ruins));
		return sequence;
	}
	private ActionSequence getFinalFightLilith() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var sword = ilist.get(Inames.Sword);
		var sequence = new ActionSequence();
		sequence.add(new Position(sword, ruins, "Chest"));
		sequence.add(new Take(vlad, sword, ruins.getFurniture("Chest")));
		//sequence.add(new EnableIcon("SwordAttack", sword, lilith, "Attack Lilith!", true));
		sequence.add(new Die(lilith));
		sequence.add(new SetNarration("You have defeated Lilith! Do you want to become King of Good or King of Evil?"));
		sequence.add(new SetDialog("[Accept Good Crown|I want to become King of Good]"));
		sequence.add(new SetDialog("[Accept Evil Crown|I want to become King of Evil]"));
		sequence.add(new ShowDialog());
		sequence.add(new ShowNarration());
		return sequence;
	}
	private ActionSequence getAcceptGoodCrown() {
		var vlad = clist.get(Cnames.Player);
		var castle = plist.get(Pnames.GreatHall);
		var king = clist.get(Cnames.Kingarthur);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new HideNarration());
		sequence.add(new Position(vlad, castle));
		sequence.add(new Position(king, castle, "Throne"));
		sequence.add(new Face(vlad, king));
		return sequence;
		}
	private ActionSequence getKingDialouge() {
		var vlad = clist.get(Cnames.Player);
		var king = clist.get(Cnames.Kingarthur);
		var sequence = new ActionSequence();
		sequence.add(new SetDialog("You have Defeated Lilith! I hereby declare you new king of LonConTopia!"));
		sequence.add(new SetRight(vlad));
		sequence.add(new SetLeft(king));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getBecomeNewKing() {
		var vlad = clist.get(Cnames.Player);
		var castle = plist.get(Pnames.GreatHall);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Position(vlad, castle, "Throne"));
		sequence.add(new SetNarration("And you lived happily ever after as king of LonConTopia!"));
		sequence.add(new ShowNarration());
		return sequence;
	}
	private ActionSequence getAtLibrary() {
		var vlad = clist.get(Cnames.Player);
		var library = plist.get(Pnames.Library);
		var hallway = plist.get(Pnames.Hallway);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Exit(vlad, hallway.getFurniture("BackDoor"), true));
		sequence.add(new Enter(vlad, library.getFurniture("Door"), true));
		sequence.add(new EnableInput(true));	
		return sequence;
		}
	private ActionSequence getTakeSpellBook() {
		var spellbook = ilist.get(Inames.SpellBook);
		var vlad = clist.get(Cnames.Player);
		var library = plist.get(Pnames.Library);
		var sequence = new ActionSequence();
		sequence.add(new Take(vlad, spellbook));
		sequence.add(new Pocket(vlad, spellbook));
		return sequence;
		
	}
	private ActionSequence getGiveBookToLilith() {
		var spellbook = ilist.get(Inames.SpellBook);
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		sequence.add(new Position(vlad, ruins));
		sequence.add(new Position(lilith, ruins));
		sequence.add(new Unpocket(vlad, spellbook));
		sequence.add(new Give(vlad, spellbook, lilith));
		return sequence;
	}
	private ActionSequence getBecomeEvilKing() {
		var ruins = plist.get(Pnames.Ruins);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new Position(vlad, ruins, "Throne"));
		sequence.add(new SetNarration("And you lived evilily ever after as new King!"));
		return sequence;
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
		sequence.add(new EnableInput(true));
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
		sequence.add(new EnableInput(true));
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
		sequence.add(new Take(vlad, sword, ruins.getFurniture("Chest")));
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
		sequence.add(new Cast(lilith, vlad, "red"));
		sequence.add(new Attack(lilith, vlad, true));
		return sequence;
	}
	private ActionSequence getWinFight() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		sequence.add(new SetNarration("You have defeated lilith! You are the new Evil King! The End."));
		sequence.add(new ShowNarration());
		sequence.add(new Position(vlad, ruins, "Throne"));
		return sequence;
	}
	private ActionSequence getLooseFight() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var healingpotion = ilist.get(Inames.RedPotion);
		var sequence = new ActionSequence();
		sequence.add(new Position(healingpotion, ruins, "Altar"));
		sequence.add(new Take(vlad, healingpotion, ruins.getFurniture("Altar")));
		sequence.add(new Drink(vlad));
		return sequence;
	}
	private ActionSequence getWinFight2ndTime() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		sequence.add(new Cast(vlad, lilith, "red"));
		sequence.add(new Attack(vlad, lilith, true));
		sequence.add(new Die(lilith));
		return sequence;
	}
	private ActionSequence getBecomeNewWitchKing() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		sequence.add(new SetNarration("You have defeated lilith! You are the new Evil King! The End:)"));
		sequence.add(new ShowNarration());
		sequence.add(new Position(vlad, ruins, "Throne"));
		return sequence;
	}
	
	

	
}
