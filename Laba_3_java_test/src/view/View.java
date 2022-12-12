package view;

import model.Model;
import controller.Controller;

public class View {
	public static void Greetings (Model model)
	{
		System.out.println("Hello "+ model.PrintModul());
	}
	public static int Menu(){
		System.out.println("");
		System.out.println("Enter number: ");
		System.out.println("0.Exit from program");
		System.out.println("1.Exit from account");
		System.out.println("2.Create animal");
		System.out.println("3.All animals");
		System.out.println("4.Delete animal");
		System.out.println("");
		int number=Controller.CheckChoice(0,4);
		return number;
		
	}
	public static int SpecialMenu(){
		System.out.println("");
		System.out.println("Enter number: ");
		System.out.println("0.Exit from program");
		System.out.println("1.Exit from account");
		System.out.println("2.Create animal");
		System.out.println("3.All animals");
		System.out.println("4.Delete animal");
		System.out.println("5.Autotests");
		System.out.println("6.Debugging");
		System.out.println("");
		int number=Controller.CheckChoice(0,6);
		return number;
		
	}
}
