import java.util.*;
import java.lang.*;
import java.io.*;
class RandomNumber
{
	public static void main(String... s) throws IOException
	{	
		int i=0;
		PrintWriter writer = new PrintWriter("File1500000.txt", "UTF-8");
		String s1 = "";
		while(i<1500000)
		{	
			int x = (int)(Math.random()*10000000);
			s1 = s1 + String.valueOf(x) + " "; 	
			System.out.println(i);			
			i=i+1;
		}
		writer.println(s1);
		writer.close();
	}
}