import java.util.*;
import java.io.*;
class ReadData
{
	public static void main(String... s) throws IOException
	{
		int count=0;
		Scanner s1 = new Scanner(new FileReader("\\X:\\Masters of Applied computer Science\\Fall 2018\\Advance Database\\Project\\Temp1500000.txt"));	
		while(s1.hasNext())
		{
			String k = s1.next();
			count++;
		}
		System.out.println(count);
	}
}