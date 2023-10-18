package camelot;
import java.util.Scanner;

public class Main {
	static Scanner scnr = new Scanner(System.in);
	public static void main(String[] args) {
	
		Main.Start();
	while(true) {
			
		}

	}
	
	public static void Start(){
		Action("CreatePlace(forest, ForestPath)");
		Action("CreateCharacter(Lilith, G)");
		Action("SetClothing(Lilith, Witch)");
		Action("CreateCharacter(Vlad, B)");
		Action("SetClothing(Vlad, Noble");
		Action("SetHairStyle(Lilith, Long)");
		//Action("EnableIcon(\"Change\", Hand, Bedroom.Closet, \"Change\", true)");
		Action("SetPosition(Vlad, ForestPath.EastEnd)");
		Action("SetCameraFocus(Vlad)");
		Action("ShowMenu()");
		WaitFor("input Selected Start");
		Action("HideMenu()");
		Action("EnableInput()");
		//WaitFor("input Change Bedroom.Closet");
		Action("FadeOut()");
		Action("SetClothing(Jane, Peasant)");
		Action("FadeIn()");
		WaitFor("input Change Bedroom.Closet");
		Action("FadeOut()");
		Action("SetClothing(Jane, Merchant)");
		Action("FadeIn()");
		WaitFor("input Change Bedroom.Closet");
		Action("FadeOut()");
		Action("SetClothing(Jane, Noble)");
		Action("FadeIn()");
	}

	public static void WaitFor(String msg)
	{
		while (true)
		{
			String input = scnr.nextLine();
			if (input.equals( msg)) {
				break;
		}
		}
	}

	public static void Action(String msg)
	{
		System.out.println("start " + msg);
		while (true)
		{
			
			String input = scnr.nextLine();
			if (input.equals("succeeded " + msg)) {
				break;
			}
		}
	}

}
