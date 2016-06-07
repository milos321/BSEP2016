package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileWriterReader {
	public static String path = "C:\\Users\\Milos\\Documents\\GitHub\\repoPrj\\data";

	//OVERWRITE, ID
	public static int write(String string, Integer id) {
		try(FileWriter fw = new FileWriter(path+"/"+string, false);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
				
					out.print(id.toString());
			    out.close();
			} catch (IOException e) {
			    System.out.println("GRESKA PRI PISANJU U FAJL");
			    return -1;
			}
		
		return 0;
		
	}
	

	public static Integer read(String string) {
		// TODO Auto-generated method stub
			
			try(BufferedReader br = new BufferedReader(new FileReader(path+"/"+string))) {
			    String line = br.readLine();  
			   br.close();
			   return Integer.parseInt(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		return null;
	}
}
