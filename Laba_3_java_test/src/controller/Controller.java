package controller;
import java.util.Scanner;
import model.*;
import model.animal.*;
import java.util.HashMap;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.Random;

import view.View;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Controller {
	public static Scanner scanner=new Scanner(System.in);
	private static PrimitiveIterator.OfInt random;
	private static PrimitiveIterator.OfInt random_4;
	
	public static String inputString() {
		return scanner.nextLine();
	}
	protected static  boolean CheckInt(String line)
	{
			try 
			{
				int intValue=Integer.parseInt(line);
				return true;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Input incorrect");
				return false;
			}
	}
	public static int CheckIntput()
	{
		String line=scanner.nextLine();
		boolean flag=CheckInt(line);
		while(flag==false)
		{
			line=scanner.nextLine();
			flag=CheckInt(line);
		}
		return Integer.parseInt(line);
	}
	public static int CheckPositiv()
	{
		int number=CheckIntput();
		while(number<1)
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}
	public static int CheckPositivKind()
	{
		int number=CheckIntput();
		while((number<1)||(number>4))
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}

	public static String InputLogin()
	{
		System.out.println("Enter login: ");
		String login=inputString();
		return login;
	}
	public static String InputPassword()
	{
		System.out.println("Enter password: ");
		String password=inputString();
		return password;
	}
	
	public static int CheckChoice(int left,int right)
	{
		int number=CheckIntput();
		while((number<left)||(number>right))
		{
			System.out.println("Please input correct number");
			number=CheckIntput();
		}
		return number;
	}
	public static List<ModelAnimal> Generator_list(int number) throws IOException
	{
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_list"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_ID_list"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_add_list"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_add_ID_list"));
		List<ModelAnimal> array=new ArrayList<>();
		random = new Random().ints(0, 10000).iterator();
		random_4 = new Random().ints(1, 5).iterator();
		int[] arrays= new int[number];
		int summa=0;
		try {
            Logging.log(Integer.toString(number));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "Start program: "+ new Date()+"\n"+"ArrayList");
		long startTime = System.nanoTime();
		for (int i=0;i<number;i++)
		{
			long startTime_test = System.nanoTime();
			array.add(new ModelAnimal("fff",random.nextInt(),random.nextInt(),random_4.nextInt()));
			long endTime_test = System.nanoTime();
			arrays[i]=(int) (endTime_test - startTime_test);
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_add_list"), String.valueOf(endTime_test - startTime_test));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_add_ID_list"), String.valueOf(i));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "add,IP "+Integer.toString(i+1)+" "+array.get(i).hashCode());
		}
		long endTime = System.nanoTime();
		for (int i=0;i<number;i++)
		{
			summa=summa+arrays[i];
		}
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "addTotalCount= "+Integer.toString(number));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "addTotalTime= "+String.valueOf(endTime - startTime));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "addMedianTime= "+String.valueOf(summa/number));
		int number_test=number;
		startTime = System.nanoTime();
		for (int i=number/10;i>0;i--)
		{
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "remove, ID "+Integer.toString((i*10))+" "+array.get(i*10-1).hashCode());
			long startTime_test = System.nanoTime();
			array.remove(i*10-1);
			long endTime_test = System.nanoTime();
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_list"), String.valueOf(endTime_test - startTime_test));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_ID_list"), String.valueOf(Integer.toString(i*10)));
			summa=summa-arrays[i*10-1];
			number_test=number_test-1;
		}
		endTime = System.nanoTime();
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "removeTotalCount= "+Integer.toString(number-number_test));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "removeTotalTime= "+String.valueOf(endTime - startTime));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "removeMedianTime= "+String.valueOf(summa/number_test));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_list"), "Finish program: "+ new Date());
		return array;
	}
	
	public static HashMap<String, ModelAnimal> Generator_map(int number) throws IOException
	{
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_map"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_ID_map"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_add_map"));
		Model.Cleaner(Model.AbsoluteFilePath(String.valueOf(number)+"_add_ID_map"));
		HashMap<String, ModelAnimal> array = new HashMap<String, ModelAnimal>();
		random = new Random().ints(0, 10000).iterator();
		random_4 = new Random().ints(1, 5).iterator();
		int[] arrays= new int[number];
		int summa=0;
		try {
            Logging.log(Integer.toString(number));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "Start program: "+ new Date()+"\n"+"HashMap");
		long startTime = System.nanoTime();
		for (int i=0;i<number;i++)
		{
			long startTime_test = System.nanoTime();
			array.put(String.valueOf(i),new ModelAnimal("fff",random.nextInt(),random.nextInt(),random_4.nextInt()));
			long endTime_test = System.nanoTime();
			arrays[i]=(int) (endTime_test - startTime_test);
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_add_map"),String.valueOf(endTime_test - startTime_test));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_add_ID_map"),String.valueOf(i));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "add,IP "+Integer.toString(i+1)+" "+array.get(Integer.toString(i)).hashCode());
		}
		long endTime = System.nanoTime();
		for (int i=0;i<number;i++)
		{
			summa=summa+arrays[i];
		}
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "addTotalCount= "+Integer.toString(number));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "addTotalTime= "+String.valueOf(endTime - startTime));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "addMedianTime= "+String.valueOf(summa/number));
		int number_test=number;
		startTime = System.nanoTime();
		for (int i=number/10;i>0;i--)
		{
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "remove, ID "+Integer.toString((i*10))+" "+array.get(Integer.toString(i*10-1)).hashCode());
			long startTime_test = System.nanoTime();
			array.remove(Integer.toString(i*10-1));
			long endTime_test = System.nanoTime();
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_map"), String.valueOf(endTime_test - startTime_test));
			Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_time_ID_map"), String.valueOf(Integer.toString(i*10)));
			summa=summa-arrays[i*10-1];
			number_test=number_test-1;
		}
		endTime = System.nanoTime();
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "removeTotalCount= "+Integer.toString(number-number_test));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "removeTotalTime= "+String.valueOf(endTime - startTime));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "removeMedianTime= "+String.valueOf(summa/number_test));
		Logging.log_test(Model.AbsoluteFilePath(String.valueOf(number)+"_log_numbers_map"), "Finish program: "+ new Date());
		return array;
	}

}

