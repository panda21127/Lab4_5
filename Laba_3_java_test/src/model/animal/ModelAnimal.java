package model.animal;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import model.*;

import controller.Controller;

public class ModelAnimal extends KindAnimals {
//	KindAnimals animal=new KindAnimals();
	private static boolean autotests;
	
	public ModelAnimal()
	{
		super();
	}
	public ModelAnimal(String Name,int Weight,int Age,int KindAnimal)
	{
		super(Name,Weight,Age,KindAnimal);
	}
	
 	public static ModelAnimal modelAnimal() {
		System.out.println("\nInput animal: ");
		System.out.println("Name: ");
		String name=Controller.inputString();
		System.out.println("Kind Animal: ");
		System.out.println("1.Waterfowl\n2.Feathered\n3.Ungulates\n4.Cold-blooded ");
		System.out.println("Please input number: ");
		int kindAnimal=Controller.CheckPositivKind();
		System.out.println("Weight: ");
		System.out.println("Please input number: ");
		int Weight=Controller.CheckPositiv();
		System.out.println("Age: ");
		System.out.println("Please input number: ");
		int Age=Controller.CheckPositiv();
		ModelAnimal animal=new ModelAnimal(name,Weight,Age,kindAnimal);
		return animal;
		
	}
	public static void PrintInfArray(List<ModelAnimal> text) {
		System.out.println("\nName:\tKind Animal:\tWeight:\tAge: ");
		for(int i=0;i<text.size();i++)
		{
			text.get(i).PrintInf();
			text.get(i).move(text.get(i).GetKindAnimal());
			System.out.println();
		}
	}
	public static List<ModelAnimal> ReadFile(String absoluteFilePath) throws IOException
	{
		FileReader fR = new FileReader(absoluteFilePath);
		BufferedReader br = new BufferedReader(fR);
		List<ModelAnimal> text = new ArrayList<>();
		try {
			String line;
            while ((line = br.readLine()) != null) {
            	String[] array=line.split(" ");
            	ModelAnimal logPassAdmin=new ModelAnimal(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]));
                text.add(logPassAdmin);
            }
		}
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
		fR.close();
		return text;
	}
	public static void WriteFile(String absoluteFilePath,List<ModelAnimal> text) throws IOException
	{
		Model.Cleaner(absoluteFilePath);
		try(FileWriter writer = new FileWriter(absoluteFilePath, true))
        {
			for (int i=0;i<text.size();i++)
			{
				Logging.log_test(absoluteFilePath, i+"="+text.get(i).Print());
			}
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
	
//	public static HashMap<String, ModelAnimal> ReadFile_map(String absoluteFilePath) throws IOException
//	{
//		FileReader fR = new FileReader(absoluteFilePath);
//		BufferedReader br = new BufferedReader(fR);
//		HashMap<String, ModelAnimal> array = new HashMap<String, ModelAnimal>();
//		try {
//			String line;
//            while ((line = br.readLine()) != null) {
//            	String[] array=line.split(" ");
//            	ModelAnimal logPassAdmin=new ModelAnimal(array[0],Integer.parseInt(array[1]),Integer.parseInt(array[2]),Integer.parseInt(array[3]));
//                text.add(logPassAdmin);
//            }
//		}
//        catch(IOException ex){
//             
//            System.out.println(ex.getMessage());
//        } 
//		fR.close();
//		return text;
//	}
	
	public static void WriteFile_map(String absoluteFilePath,HashMap<String, ModelAnimal> text) throws IOException
	{
		Properties properties = new Properties();

		for (Map.Entry<String,ModelAnimal> entry : text.entrySet()) {
		    properties.put(entry.getKey(), entry.getValue().Print());
		}
		Model.Cleaner(absoluteFilePath);
		File file=new File(absoluteFilePath);
		properties.store(new FileOutputStream(file), null);
	}
	
}
