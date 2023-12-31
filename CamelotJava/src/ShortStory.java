import java.util.HashMap;

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
		var library = plist.get(Pnames.Library);
		var greenbook = ilist.get(Inames.GreenBook);
		var spookyroad = plist.get(Pnames.SpookyPath); 
		var hallway = plist.get(Pnames.Hallway);
		var cottage = plist.get(Pnames.Cottage);
		var dungeon = plist.get(Pnames.Dungeon);
		var ruins = plist.get(Pnames.Ruins);
		var knight = clist.get(Cnames.Knight);
		var Become = new Node(NodeLabels.BecomeEvilKing.toString());
		var give = new Node(NodeLabels.GiveBookToLilith.toString());
		give.addChild(new SelectionChoice(ChoiceLabels.Talk2Witch.toString()),
				Become);
		
		var WinFightNode = new Node(NodeLabels.Winfight.toString());
		var takeSpellBook = new Node(NodeLabels.TakeSpellBook.toString());
		takeSpellBook.addChild(new ActionChoice(ChoiceLabels.TakeBook.toString(),
				vlad,
				ActionChoice.Icons.talk,
				"Talk to lilith",
				true),
				give);
		//var RejectFightNode = new Node(NodeLabels.RejectFight.toString());
		
		
		var fistfight = new Node(NodeLabels.FistFight.toString());
	
		var swordFight = new Node(NodeLabels.SwordFight.toString());
		swordFight.addChild(new SelectionChoice(ChoiceLabels.Winfight.toString()),
			WinFightNode);
		
		//var AgreetoFightNode = new Node(NodeLabels.AgreetoFight.toString());

		
		var WitchDialouge= new Node(NodeLabels.WitchDialouge.toString());
		WitchDialouge.addChild(new SelectionChoice(ChoiceLabels.SwordFight.toString()),
			swordFight); 
		WitchDialouge.addChild(new SelectionChoice(ChoiceLabels.FistFight.toString()),
			fistfight);
		
				
		var WitchTalk = new Node(NodeLabels.WitchTalk.toString());
		
		
		var kingDialouge = new Node(NodeLabels.KingDialouge.toString());
		//kingDialouge.addChild(new SelectionChoice(ChoiceLabels.TalktoKing.toString()), new Node(NodeLabels.BecomeNewKing.toString()));
	
		var AcceptGoodCrownNode1 = new Node(NodeLabels.AcceptGoodCrown.toString());
		AcceptGoodCrownNode1.addChild(new SelectionChoice(ChoiceLabels.AcceptGCrown.toString()),
				kingDialouge);
		var AcceptEvilCrownNode1 = new Node(NodeLabels.BecomeEvilKing.toString());
		
		var FinalFightlilithNode = new Node(NodeLabels.FinalFightLilith.toString());
		FinalFightlilithNode.addChild(new SelectionChoice(ChoiceLabels.AcceptECrown.toString()),
				AcceptEvilCrownNode1);
		FinalFightlilithNode.addChild(new SelectionChoice(ChoiceLabels.AcceptGCrown.toString()),
				AcceptGoodCrownNode1);
		
		var RevengeNode = new Node(NodeLabels.GoToRuinsForRevenge.toString());
		RevengeNode.addChild(new ActionChoice(ChoiceLabels.Fight.toString(),
				vlad,
				ActionChoice.Icons.hurt,
				"Attack Lilith",
				true),
				FinalFightlilithNode);
		var AcceptDarkQuestNode = new Node(NodeLabels.AcceptDarkQuest.toString());
		AcceptDarkQuestNode.addChild(new ActionChoice(ChoiceLabels.Enter.toString(),
				hallway.getFurniture("BackDoor"),
				ActionChoice.Icons.door,
				"Enter The Library",
				true),
				takeSpellBook);
		var RejectDarkQuestNode = new Node(NodeLabels.RejectDarkQuest.toString());
		RejectDarkQuestNode.addChild(new ActionChoice(ChoiceLabels.Enter.toString(),
				dungeon.getFurniture("Door"),
				ActionChoice.Icons.door,
				"Leave The Dungeon",
				true),
				RevengeNode);
		WitchTalk.addChild(new SelectionChoice(ChoiceLabels.Accept.toString()), 
				AcceptDarkQuestNode);
		WitchTalk.addChild(new SelectionChoice(ChoiceLabels.Reject.toString()),
				RejectDarkQuestNode);
		var atCottageNode = new Node(NodeLabels.AtCottage.toString());
		atCottageNode.addChild(new ActionChoice(ChoiceLabels.Talk2Witch.toString(),
				lilith,
				ActionChoice.Icons.talk,
				"Talk to Lilith",
				true),
				WitchTalk);
		var get1stKnightDialog = new Node(NodeLabels.stKnightDialog.toString());
		get1stKnightDialog.addChild(new ActionChoice(ChoiceLabels.TalktoKnight.toString(),
				knight,
				ActionChoice.Icons.talk,
				"Talk to the Knight",
				true),
				atCottageNode);
				
		var at1stRuins = new Node(NodeLabels.At1stRuins.toString());
		at1stRuins.addChild(new ActionChoice(ChoiceLabels.TalkToWitch.toString(),
				lilith,
				ActionChoice.Icons.talk,
				"Talk to Lilith",
				true),
				WitchDialouge);
		var DrinkPotion = new Node(NodeLabels.DrinkPotion.toString());
		DrinkPotion.addChild(new PositionChoice(
				vlad,
				spookyroad.getFurniture("EastEnd"),
				PositionChoice.Condition.arrived),
				at1stRuins);
		var TakeBook = new Node(NodeLabels.TakeBook.toString());
		TakeBook.addChild(new ActionChoice(ChoiceLabels.Enter.toString(),
				city.getFurniture("RedHouseDoor"),
				ActionChoice.Icons.door,
				"Enter The House",
				true),
				atCottageNode);
		
		var RuinsBanditDialouge = new Node(NodeLabels.RuinsBanditDialouge.toString());
		RuinsBanditDialouge.addChild(new SelectionChoice(ChoiceLabels.Accept.toString()), 
				DrinkPotion);
		RuinsBanditDialouge.addChild(new SelectionChoice(ChoiceLabels.Reject.toString()),
				TakeBook);	
		var atRuinsNode = new Node(NodeLabels.AtRuins.toString());
		atRuinsNode.addChild(new ActionChoice(ChoiceLabels.TalkToBandit.toString(),
				odin,
				ActionChoice.Icons.talk,
				"Talk to the Bandit",
				true),
				RuinsBanditDialouge);
		return atRuinsNode; 
		
	}

	private enum NodeLabels{ AtRuins, BecomeNewKing, RuinsBanditDialouge, AtCrossroads, AtStonepath, WitchDialouge, AtCity, AtCottage, WitchTalk, AtDungeon, PracticeDarkMagic, EscapeFireDungeon, 
		MagicfightWitch, Winfight, stKnightDialog, DrinkHealingPotion, LockPickEscapeDungeon,  TakeScroll, BanditDialouge, TakeSword,  AtCastle, AtLibrary, GiveLovepotionToWitch,
		AtAlchemyshop, AlchemistDialouge, PoisonKing, PoisonWitch, KingDialouge, AcceptEvilCrown, AcceptGoodCrown, FinalFightLilith, BecomeEvilKing, DrinkPotion, ReadBook, At1stRuins, AgreetoFight, FistFight, SwordFight, RejectFight, TakeSpellBook, AcceptDarkQuest, RejectDarkQuest, GoToRuinsForRevenge, EscapeDungeon, GiveBookToLilith, TakeBook }
	public enum ChoiceLabels{Accept, Reject, Leave, AcceptECrown, AcceptGCrown, TalktoKing, Enter, TalktoKnight, TalkToForestBandit, DrinkPotion, TakeBook, TakeSword, StealPoison, PayForPoison, TalkToWitch, Talk2Witch, TalkToBandit, Fight, TalkToKing, AcceptBanditQuest, DeclineBanditQuest, AcceptWitchQuest, DeclineWitchQuest, MagicFight, FistFight, SwordFight, Winfight }
	public enum Cnames{ Player, Odin, Lilith, Kingarthur, Knight}
	public enum Pnames {Forest, Spookyroad, Ruins, CastleCrossroads, Dungeon, Cottage, AlchemyShop, GreatHall, Library, Hallway, Castlebedroom, City, SpookyPath}
	public enum Inames {PurplePotion, Chest, EvilBook, Scroll, Sword, JewelKey, GreenBook, Altar, Skull, RedPotion}
	HashMap<Cnames, Character> clist = new HashMap<>();
	HashMap<Pnames, Place> plist = new HashMap<>();
	HashMap<Inames, Item> ilist = new HashMap<>();
	
	 
	
	public ShortStory() {
		getThings();
	}
	public void getThings() {
		clist.put(Cnames.Player, new Character(Cnames.Player.toString(), Character.BodyType.B, Character.Clothing.Peasant, Character.Hairstyles.Spiky));
		clist.put(Cnames.Odin, new Character(Cnames.Odin.toString(), Character.BodyType.B, Character.Clothing.Bandit));
		clist.put(Cnames.Lilith, new Character(Cnames.Lilith.toString(), Character.BodyType.E, Character.Clothing.Witch, Character.Hairstyles.Long));
		clist.put(Cnames.Knight, new Character(Cnames.Knight.toString(), Character.BodyType.B, Character.Clothing.Knight));
		clist.put(Cnames.Kingarthur, new Character(Cnames.Kingarthur.toString(), Character.BodyType.H, Character.Clothing.King));
		plist.put(Pnames.Forest, new Place(Pnames.Forest.toString(), Place.Places.ForestPath));
		plist.put(Pnames.SpookyPath, new Place(Pnames.SpookyPath.toString(), Place.Places.SpookyPath));
		plist.put(Pnames.City, new Place(Pnames.City.toString(), Place.Places.City));
		ilist.put(Inames.RedPotion, new Item(Inames.RedPotion.toString(), Item.Items.RedPotion));
		plist.put(Pnames.Cottage, new Place(Pnames.Cottage.toString(), Place.Places.Cottage));
		plist.put(Pnames.CastleCrossroads, new Place(Pnames.CastleCrossroads.toString(), Place.Places.CastleCrossroads));
		plist.put(Pnames.Castlebedroom, new Place(Pnames.Castlebedroom.toString(), Place.Places.CastleBedroom));
		plist.put(Pnames.Library, new Place(Pnames.Library.toString(), Place.Places.Library));
		plist.put(Pnames.Hallway, new Place(Pnames.Hallway.toString(), Place.Places.Hallway));
		plist.put(Pnames.GreatHall, new Place(Pnames.GreatHall.toString(), Place.Places.GreatHall));
		plist.put(Pnames.Ruins, new Place(Pnames.Ruins.toString(), Place.Places.Ruins));
		plist.put(Pnames.AlchemyShop, new Place(Pnames.AlchemyShop.toString(), Place.Places.AlchemyShop));
		plist.put(Pnames.Dungeon, new Place(Pnames.Dungeon.toString(), Place.Places.Dungeon));
		ilist.put(Inames.Chest, new Item(Inames.Chest.toString(), Item.Items.Chest));
		ilist.put(Inames.EvilBook, new Item(Inames.EvilBook.toString(), Item.Items.EvilBook));
		ilist.put(Inames.GreenBook, new Item(Inames.GreenBook.toString(), Item.Items.GreenBook));
		ilist.put(Inames.Scroll, new Item(Inames.Scroll.toString(), Item.Items.Scroll));
		ilist.put(Inames.PurplePotion, new Item(Inames.PurplePotion.toString(), Item.Items.PurplePotion));
		ilist.put(Inames.Sword, new Item(Inames.Sword.toString(), Item.Items.Sword));
		ilist.put(Inames.GreenBook, new Item(Inames.GreenBook.toString(), Item.Items.GreenBook));
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
		map.add(NodeLabels.AtRuins.toString(), getAtRuins());
		map.add(NodeLabels.RuinsBanditDialouge.toString(), getRuinsBanditDialouge());
		map.add(NodeLabels.DrinkPotion.toString(), getDrinkPotion());
		map.add(NodeLabels.At1stRuins.toString(), getAt1stRuins());
		map.add(NodeLabels.TakeBook.toString(), getTakeBook());
		map.add(NodeLabels.WitchDialouge.toString(), getWitchDialouge());
		map.add(NodeLabels.AgreetoFight.toString(), getAgreetoFight());
		map.add(NodeLabels.BecomeEvilKing.toString(), getBecomeEvilKing());
		map.add(NodeLabels.FistFight.toString(), getFistFight());
		map.add(NodeLabels.SwordFight.toString(), getSwordFight());
		map.add(NodeLabels.Winfight.toString(), getWinFight());
		map.add(NodeLabels.RejectFight.toString(), getRejectFight());
		//map.add(NodeLabels.AtCity.toString(), getAtCity());
		map.add(NodeLabels.TakeSpellBook.toString(), getTakeSpellBook());
//		map.add(NodeLabels.stKnightDialog.toString(), get1stKnightDialog());
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
		//map.add(NodeLabels.TakeScroll.toString(), getTakeScroll());
		//map.add(NodeLabels.TakeSword.toString(), getTakeSword());
		//map.add(NodeLabels.BanditDialouge.toString(), getBanditDialouge());
		//map.add(NodeLabels.AtCastle.toString(), getAtCastle());
		map.add(NodeLabels.AtLibrary.toString(), getAtLibrary());
		//map.add(NodeLabels.GiveLovepotionToWitch.toString(), getGiveLovepotionToWitch());
		//map.add(NodeLabels.AtAlchemyshop.toString(), getAtAlchemyShop());
		//map.add(NodeLabels.AlchemistDialouge.toString(), getAlchemistDialouge());
		map.add(NodeLabels.GiveBookToLilith.toString(), getGiveBookToLilith());
		//map.add(NodeLabels.PoisonKing.toString(), getPoisonKing());
		//map.add(NodeLabels.PoisonWitch.toString(), getPoisonWitch());
		map.add(NodeLabels.KingDialouge.toString(), getKingDialouge());
		//map.add(NodeLabels.AcceptEvilCrown.toString(), getAcceptEvilCrown());
		map.add(NodeLabels.BecomeNewKing.toString(), getBecomeNewKing());
		map.add(NodeLabels.AcceptGoodCrown.toString(), getAcceptGoodCrown());
		return map;
		
	}

	private ActionSequence getAtRuins() {
		var sequence = new ActionSequence();
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var forest = plist.get(Pnames.Forest);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var spookyroad = plist.get(Pnames.SpookyPath);
		var home = plist.get(Pnames.Cottage);
		var scroll = ilist.get(Inames.Scroll);
		var city = plist.get(Pnames.City);
		var healingpotion = ilist.get(Inames.RedPotion);
		var dungeon = plist.get(Pnames.Dungeon);
		var castlebedroom = plist.get(Pnames.Castlebedroom);
		//var spellbook = ilist.get(Inames.SpellBook);
		var sword = ilist.get(Inames.Sword);
		sequence.add(new Create<Item>(sword));
		sequence.add(new Create<Place>(home));
		sequence.add(new Create<Place>(dungeon));
		sequence.add(new Create<Place>(castlebedroom));
		//sequence.add(new Create<Item>(spellbook));
		sequence.add(new Create<Item>(scroll));
		sequence.add(new Create<Place>(ruins));
		sequence.add(new Create<Character>(vlad));
		sequence.add(new Create<Character>(odin));
		sequence.add(new Create<Item>(healingpotion));
		sequence.add(new SetClothing(vlad));
		sequence.add(new SetClothing(odin));
		sequence.add(new SetHairStyle(vlad));
		sequence.add(new Create<Place>(city));
		//sequence.add(new Create<Place>(forest));
		sequence.add(new Create<Place>(spookyroad));
		sequence.add(new Position(vlad, ruins));
		sequence.add(new Position(odin, ruins, "Throne"));
		sequence.add(new Face(odin, vlad));
		sequence.add(new SetCameraFocus(vlad));
		sequence.add(new ShowMenu(true));
		sequence.add(new ShowMenu(false));
		sequence.add(new EnableInput(true));
		return sequence;
	}
	
	private ActionSequence getRuinsBanditDialouge() {
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var sequence = new ActionSequence();
		var evilbook = ilist.get(Inames.EvilBook);
		var lovepotion = ilist.get(Inames.PurplePotion);
		var ruins = plist.get(Pnames.Ruins);
		sequence.add(new Create<Item>(evilbook));
		sequence.add(new Create<Item>(lovepotion));
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(odin));
		sequence.add(new SetNarration("Talk to the Bandit Odin to Begin your Journey"));
		sequence.add(new ShowNarration());
		sequence.add(new SetDialog("Do you want to Drink the Magic Potion or read the Evil Book"));
		sequence.add(new SetDialog("[Accept|Magic Potion]"));
		sequence.add(new SetDialog("[Reject|Evil Book]"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getDrinkPotion() {	
		var lovepotion = ilist.get(Inames.PurplePotion);
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		var spookyroad = plist.get(Pnames.SpookyPath);
		//var chest = ilist.get(Inames.Chest);
		//var city = plist.get(Pnames.City);
		//sequence.add(new Create<Item>(lovepotion));
		//sequence.add(new Position(lovepotion, forest, "PathBlock"));
		sequence.add(new HideDialog());
		sequence.add(new Position(lovepotion, ruins, "Altar"));
		sequence.add(new Take(vlad, lovepotion));
		sequence.add(new Drink(vlad, lovepotion, ruins, "Altar"));
		sequence.add(new Pocket(vlad, lovepotion));
		sequence.add(new Position(vlad, spookyroad));
		return sequence;
	}
	private ActionSequence getTakeBook() {
		var evilbook = ilist.get(Inames.EvilBook);
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		var city = plist.get(Pnames.City);
		sequence.add(new HideDialog());
		sequence.add(new Position(evilbook, ruins, "Altar"));
		sequence.add(new Take(vlad, evilbook));	
		sequence.add(new Pocket(vlad, evilbook));
		sequence.add(new Position(vlad, city));
		return sequence;
	}
	//private ActionSequence getAtCity(){
	//	var vlad = clist.get(Cnames.Player);
	//	var ruins = plist.get(Pnames.Ruins);
	//	var city = plist.get(Pnames.City);
	//	var home = plist.get(Pnames.Cottage);
	//	var knight = clist.get(Cnames.Knight);
	//	var sequence = new ActionSequence();
	//	sequence.add(new EnableInput(false));
		//sequence.add(new Create<Character>(knight));
		//sequence.add(new Position(knight, city));
		
	//	return sequence;
	
	private ActionSequence get1stKnightDialog() {
		var vlad = clist.get(Cnames.Player);
		var knight = clist.get(Cnames.Knight);
		var sequence = new ActionSequence();
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetRight(knight));
		sequence.add(new SetDialog("Enter the red house to get some rest"));
		return sequence;
	}
	
	private ActionSequence getAtCottage() {
		var vlad = clist.get(Cnames.Player);
		var city = plist.get(Pnames.City);
		var home = plist.get(Pnames.Cottage);
		var ruins = plist.get(Pnames.Ruins);		
		var dungeon = plist.get(Pnames.Dungeon);
		var castlebedroom = plist.get(Pnames.Castlebedroom);
		var lilith = clist.get(Cnames.Lilith);
		//var vlad = clist.get(Cnames.Player);
		//var home = plist.get(Pnames.Cottage);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		//sequence.add(new Exit(vlad, ruins.getFurniture("Exit"), true));
		//sequence.add(new Enter(vlad, city.getFurniture("NorthEnd"), true));	
		sequence.add(new EnableInput(true));
		sequence.add(new Create<Character>(lilith));
		sequence.add(new SetClothing(lilith));
		sequence.add(new SetHairStyle(lilith));
		sequence.add(new Exit(vlad, city.getFurniture("city"), true));
		sequence.add(new Enter(vlad, home.getFurniture("home"), true));
		sequence.add(new Position(vlad, home));
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
		sequence.add(new SetDialog("I see you have found my book, Go to the library and retrieve my spell book"));
		sequence.add(new SetDialog("[Accept|I will Accept]"));
		sequence.add(new SetDialog("[Reject|No! I won't do it.]"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getAcceptDarkQuest() {
		var vlad = clist.get(Cnames.Player);
		var hallway = plist.get(Pnames.Hallway);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Create<Place>(hallway));
		sequence.add(new SetNarration("Splendid, Go to the library and bring me the spell book. You also will have access to special powers like teleportation and other magicks"));
		sequence.add(new ShowNarration());
		sequence.add(new Position(vlad, hallway));
		return sequence;
	}
	
	private ActionSequence getRejectDarkQuest() {
		var vlad = clist.get(Cnames.Player);
		var dungeon = plist.get(Pnames.Dungeon);
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(dungeon));
		sequence.add(new Position(vlad, dungeon, "CellDoor"));	
		sequence.add(new HideDialog());
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
		var dungeon = plist.get(Pnames.Dungeon);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		//sequence.add(new HideNarration());
		sequence.add(new Face(lilith, ruins.getFurniture("Altar")));
		//sequence.add(new DisableEffect(vlad, Blackflame));
		sequence.add(new Exit(vlad, dungeon.getFurniture("Door"), true));
		sequence.add(new Enter(vlad, ruins.getFurniture("Exit"), true));
		sequence.add(new Position(vlad, ruins));	
		sequence.add(new Position(lilith, ruins));
		return sequence;
	}
	private ActionSequence getFinalFightLilith() {
		var vlad = clist.get(Cnames.Player);
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var odin = clist.get(Cnames.Odin);
		var sword = ilist.get(Inames.Sword);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Position(sword, ruins, "Chest"));
		sequence.add(new Take(vlad, sword, ruins.getFurniture("Chest")));
		sequence.add(new Draw(vlad, sword));
		sequence.add(new Attack(vlad, lilith, true));
		//sequence.add(new EnableIcon("SwordAttack", sword, lilith, "Attack Lilith!", true));
		sequence.add(new SetNarration("You have defeated Lilith! Do you want to become King of Good or King of Evil?"));
		sequence.add(new ShowNarration());
		sequence.add(new SetRight(vlad));
		sequence.add(new SetLeft(odin));
		sequence.add(new SetDialog("[AcceptGCrown|I want to become King of Good]"));
		sequence.add(new SetDialog("[AcceptECrown|I want to become King of Evil]"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getAcceptGoodCrown() {
		var vlad = clist.get(Cnames.Player);
		var castle = plist.get(Pnames.GreatHall);
		var king = clist.get(Cnames.Kingarthur);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		sequence.add(new Create<Character>(king));
		sequence.add(new SetClothing(king));
		sequence.add(new Position(king, ruins, "altar"));
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
		var greenbook = ilist.get(Inames.GreenBook);
		var hallway = plist.get(Pnames.Hallway);
		var sequence = new ActionSequence();
		sequence.add(new EnableInput(false));
		sequence.add(new Position(greenbook, library, "Table"));
		sequence.add(new EnableInput(true));	
		return sequence;
		}
	private ActionSequence getTakeSpellBook() {
		var greenbook = ilist.get(Inames.GreenBook);
		var vlad = clist.get(Cnames.Player);
		var hallway = plist.get(Pnames.Library);
		var ruins = plist.get(Pnames.Ruins);
		var library = plist.get(Pnames.Library);
		var sequence = new ActionSequence();
		sequence.add(new Create<Place>(library));
		sequence.add(new Create<Item>(greenbook));
		sequence.add(new Position(greenbook, library, "Table"));
		sequence.add(new Exit(vlad, hallway.getFurniture("BackDoor"), true));
		sequence.add(new Enter(vlad, library.getFurniture("Door"), true));
		sequence.add(new Take(vlad, greenbook));
		sequence.add(new Pocket(vlad, greenbook));
		return sequence;
		
	}
	private ActionSequence getGiveBookToLilith() {
		var greenbook = ilist.get(Inames.GreenBook);
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var ruins = plist.get(Pnames.Ruins);
		var sequence = new ActionSequence();
		sequence.add(new Position(vlad, ruins));
		sequence.add(new Position(lilith, ruins));
		sequence.add(new Unpocket(vlad, greenbook));
		//sequence.add(new Face(vlad, lilith));
		//sequence.add(new Give(vlad, greenbook, lilith));
		sequence.add(new SetRight(vlad));
		sequence.add(new SetLeft(lilith));
		sequence.add(new SetDialog("This is the wrong book! Did you do what I asked?"));
		sequence.add(new SetDialog("[Talk2Witch| You forgot my book?]"));		
		//sequence.add(new SetDialog("[Talk2Witch] You forgot my Book?]"));
		sequence.add(new ShowDialog());
		//sequence.add(new Take(lilith, greenbook));
		return sequence;
	}
	private ActionSequence getBecomeEvilKing() {
		var ruins = plist.get(Pnames.Ruins);
		var lilith = clist.get(Cnames.Lilith);
		var vlad = clist.get(Cnames.Player);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Cast(vlad, lilith, "red"));
		sequence.add(new Die(lilith));
		//sequence.add(new SetNarration("And you lived evilily ever after as new King!"));
		return sequence;
	}
	private ActionSequence getAt1stRuins() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var city = plist.get(Pnames.City);
		var dungeon = plist.get(Pnames.Dungeon);
		var sword = ilist.get(Inames.Sword);
		var ruins = plist.get(Pnames.Ruins);
		var spookyroad = plist.get(Pnames.SpookyPath);
		var scroll = ilist.get(Inames.Scroll);
		var sequence = new ActionSequence();
		sequence.add(new Create<Character>(lilith));
		sequence.add(new SetClothing(lilith));
		sequence.add(new SetHairStyle(lilith));
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
		sequence.add(new SetDialog("Will you fight with fists or draw a sword?"));
		sequence.add(new SetDialog("[SwordFight|I choose the sword!]"));
		sequence.add(new SetDialog("[FistFight|I'll take you with my hands!]"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getAgreetoFight() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
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
		var odin = clist.get(Cnames.Odin);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Position(sword, ruins, "Chest"));
		sequence.add(new Take(vlad, sword, ruins.getFurniture("Chest")));
		sequence.add(new Draw(vlad, sword));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(vlad, lilith, false));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(vlad, lilith, true));
		sequence.add(new Position(vlad, ruins, "Throne"));
		sequence.add(new Position(odin, ruins, "Altar"));
		sequence.add(new SetRight(vlad));
		sequence.add(new SetLeft(odin));
		sequence.add(new Die(lilith));
		sequence.add(new SetDialog("You have defeated The Witch Lilith! You are now the king!"));
		sequence.add(new ShowDialog());
		sequence.add(new Revive(lilith));
		sequence.add(new HideDialog());
		sequence.add(new Die(vlad));
		sequence.add(new SetRight(lilith));
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetDialog("You couldnt defeat me!"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getWinFight() {
		var vlad = clist.get(Cnames.Player);
		var odin = clist.get(Cnames.Odin);
		var lilith = clist.get(Cnames.Lilith);
		var sequence = new ActionSequence();
		sequence.add(new Die(lilith));
		sequence.add(new SetRight(vlad));
		sequence.add(new SetLeft(odin));
		sequence.add(new SetDialog("You have defeated The Witch Lilith! You are now the king!"));
		sequence.add(new ShowDialog());
		sequence.add(new HideDialog());
		sequence.add(new Revive(lilith));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Die(vlad));
		sequence.add(new SetRight(lilith));
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetDialog("You couldnt defeat me!"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	private ActionSequence getFistFight() {
		var vlad = clist.get(Cnames.Player);
		var lilith = clist.get(Cnames.Lilith);
		var ruins = plist.get(Pnames.Ruins);
		var healingpotion = ilist.get(Inames.RedPotion);
		var odin = clist.get(Cnames.Odin);
		var sequence = new ActionSequence();
		sequence.add(new HideDialog());
		sequence.add(new Attack(vlad, lilith, false));
		sequence.add(new Cast(lilith, vlad, "red"));	
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(vlad, lilith, true));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Attack(lilith, vlad, true));
		sequence.add(new Create<Item>(healingpotion));
		sequence.add(new Position(healingpotion, ruins, "Altar"));
		sequence.add(new Take(vlad, healingpotion, ruins.getFurniture("Altar")));
		sequence.add(new Drink(vlad));
		//sequence.add(new Bash(lilith, vlad));
		sequence.add(new Cast(vlad, lilith, "red"));
		//sequence.add(new Attack(vlad, lilith, true));
		sequence.add(new Die(lilith));
		sequence.add(new SetLeft(odin));
		sequence.add(new SetRight(vlad));
		sequence.add(new SetDialog("You have defeated lilith! You are the new Evil King! The End:)"));
		sequence.add(new ShowDialog());
		//sequence.add(new Position(odin, ruins, "Altar"));
		//sequence.add(new Position(vlad, ruins, "Throne"));
		sequence.add(new Revive(lilith));
		sequence.add(new HideDialog());
		sequence.add(new Face(lilith, vlad));
		sequence.add(new Face(vlad, lilith));	
		sequence.add(new Die(vlad));
		sequence.add(new SetRight(lilith));
		sequence.add(new SetLeft(vlad));
		sequence.add(new SetDialog("You couldnt defeat me!"));
		sequence.add(new ShowDialog());
		return sequence;
	}
	
	

	
}
