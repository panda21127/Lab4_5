import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;

import controller.Controller;
import model.*;
import model.animal.*;
import view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class App {

	public static Model model = new Model();
	public static List <ModelAnimal> arrayanimal=new ArrayList<>();
	
	public static Model Checking () throws IOException {
		Model model1 = new Model();
		if (!Model.CheckActive())
		{	
			Model.CreateActive();
			System.out.println("1.loggin in account");
			System.out.println("2.create account");
			
			
			int num = Controller.CheckChoice(1,2);

			if(num == 1)
			{while (true)
				{
					String login=Controller.InputLogin();
					String password=Controller.InputPassword();
					model1=new Model(login,password);
					boolean flag=model1.Checklogin();
					if(flag==true)
					{
						try {
					        Logging.log( "Account is: "+model.PrintModul());
					    } catch (IOException e) {
					        throw new RuntimeException(e);
					    }
						break;
					}
					System.out.print(flag);
				}
			}
			else
			{
				String login=Controller.InputLogin();
				String password=Controller.InputPassword();
				model1=new Model(login,password);
				System.out.println(false);
				model1.CreateAccount();
				boolean flag=model1.Checklogin();
				System.out.println(flag);
				try {
			        Logging.log( "No enter in account");
			    } catch (IOException e) {
			        throw new RuntimeException(e);
			    }
			}
		}
		else
		{
			List<String[]> logPassAdmin = Model.ReadFile(Model.AbsoluteFilePath("ActivePerson.txt"));
			for(int i=0;i<logPassAdmin.size();i++)
			{
				model1.SetLogin(logPassAdmin.get(i)[0]);
				model1.Setpassword(logPassAdmin.get(i)[1]);
				model1.SetCheckAdmin(logPassAdmin.get(i)[2]);
				System.out.println(logPassAdmin.get(i)[0]);
				System.out.println(logPassAdmin.get(i)[1]);
				System.out.println(logPassAdmin.get(i)[2]);
			}
			
		}
		return model1;
		
	}
	
	public static boolean CheckingAccount (Model model) throws IOException {
		
		return CheckFiles.CheckFile(Model.AbsoluteFilePath(model.PrintModul()));
	}
	
	public static void main(String[] args) throws IOException {
		model=Checking();
		if (CheckingAccount(model)==false)
		{
			CheckFiles.CreateFile(Model.AbsoluteFilePath(model.PrintModul()));
		}
		else
		{
			arrayanimal=ModelAnimal.ReadFile(Model.AbsoluteFilePath(model.PrintModul()));
		}
		View.Greetings(model);
		while (true)
		{
			int number=0;
			if(model.GetCheckAdmin().equals("+"))
			{
				number=View.SpecialMenu();
			}
			else {number=View.Menu();}
			switch(number)
			{
			case 0:
			{
				try {
		            Logging.log( "App is close");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
				System.exit(0);
				break;
			}
			case 1:
			{
				try {
					CheckFiles.CleanFile(Model.AbsoluteFilePath("ActivePerson.txt"));
				}  catch (IOException x) {
				    System.err.println(x);
				}
				try {
		            Logging.log( "Account is close");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
				System.exit(0);
				break;
			}
			case 2:
			{
				ModelAnimal animal=ModelAnimal.modelAnimal();
				arrayanimal.add(animal);
				animal.PrintInf();
				ModelAnimal.WriteFile(Model.AbsoluteFilePath(model.PrintModul()),arrayanimal);
				break;
			}
			case 3:
			{
				ModelAnimal.PrintInfArray(arrayanimal);
				try {
		            Logging.log( "Print all animals");
		        } catch (IOException e) {
		            throw new RuntimeException(e);
		        }
				break;
			}
			case 4:
			{
				String animalName=Controller.inputString();
				for (int i=0;i<arrayanimal.size();i++)
				{
					if(arrayanimal.get(i).GetName().equals(animalName))
					{
						arrayanimal.remove(i);
					}
				}
				ModelAnimal.WriteFile(Model.AbsoluteFilePath(model.PrintModul()),arrayanimal);
				break;
			}
			case 5:
			{
				//List <ModelAnimal> array=new ArrayList<>();
				//array=Controller.Generator_list(10);
				//ModelAnimal.WriteFile(Model.AbsoluteFilePath("10_list"),array);
				//array=Controller.Generator_list(100);
				//ModelAnimal.WriteFile(Model.AbsoluteFilePath("100_list"),array);
				//array=Controller.Generator_list(1000);
				//ModelAnimal.WriteFile(Model.AbsoluteFilePath("1000_list"),array);
				//array=Controller.Generator_list(10000);
				//ModelAnimal.WriteFile(Model.AbsoluteFilePath("10000_list"),array);
				//array=Controller.Generator_list(100000);
				//ModelAnimal.WriteFile(Model.AbsoluteFilePath("100000_list"),array);
				
				HashMap<String, ModelAnimal> arrays = new HashMap<String, ModelAnimal>();
				arrays=Controller.Generator_map(10);
				ModelAnimal.WriteFile_map(Model.AbsoluteFilePath("10_map"),arrays);
				//arrays=Controller.Generator_map(100);
				//ModelAnimal.WriteFile_map(Model.AbsoluteFilePath("100_map"),arrays);
				//arrays=Controller.Generator_map(1000);
				//ModelAnimal.WriteFile_map(Model.AbsoluteFilePath("1000_map"),arrays);
				//arrays=Controller.Generator_map(10000);
				//ModelAnimal.WriteFile_map(Model.AbsoluteFilePath("10000_map"),arrays);
  			    //arrays=Controller.Generator_map(100000);
				//ModelAnimal.WriteFile_map(Model.AbsoluteFilePath("100000_map"),arrays);
				
				MyFrame frame=new MyFrame(1); frame.show();
				MyFrame frame2=new MyFrame(2); frame2.show();
				while (System.in.available() == 0) { } frame.show(false);frame2.show(false);
				break;
			}
			case 6:
			{
				break;
			}
			}
		}
	}
}
