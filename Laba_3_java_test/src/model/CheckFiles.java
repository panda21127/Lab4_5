package model;

import java.io.*;

public class CheckFiles {
	
	public static boolean CheckFile(String absoluteFilePath)
	{
		File file = new File(absoluteFilePath);
		if (file.exists()) {
			if(file.length() != 0) {
				System.out.println("File"+absoluteFilePath+" founded!");
				return true;
			}
			else
			{
				System.out.println("File"+absoluteFilePath+" empty!");
				return false;
			}
			
		}
		else {
			System.out.println("File"+absoluteFilePath+" not founded!");
			return false;
		}
		
	}
	public static void CreateFile(String absoluteFilePath) throws IOException
	{
		File file = new File(absoluteFilePath);
		if (file.createNewFile()) {
			System.out.println("File"+absoluteFilePath+" create!");
		}
		else {
		System.out.println("File"+absoluteFilePath+" has been created!");
		}
	}
	public static void CleanFile(String absoluteFilePath) throws IOException
	{
		try(FileWriter writer = new FileWriter(absoluteFilePath, false))
        {
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
}
