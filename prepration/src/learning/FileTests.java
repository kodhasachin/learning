package learning;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Iterator;

public class FileTests {
	
	public static boolean file_reading() throws IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader(""));
		HashSet<String> set = new HashSet<String>();
		String line;
		
		while((line=reader.readLine())!=null)
		{
			set.add(line);
		}
		reader.close();
		
		for(Iterator<String> itr=set.iterator();itr.hasNext();)
		{
			if(itr.next().contains("test"))
				return true;
		}
		
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(""));
		for(String str:set)
		{
			writer.write(str);
			writer.newLine();
		}
		
		writer.close();
		return false;
			
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
