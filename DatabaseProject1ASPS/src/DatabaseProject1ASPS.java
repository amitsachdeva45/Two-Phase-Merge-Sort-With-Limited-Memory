
/*import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
class DatabaseProject1ASPS {
	static String FilePath = "C:\\Users\\S_KURIAN\\Downloads\\Test Cases\\NewLineDelimited\\";
	static double operation_size;
	static void initial_sort() throws FileNotFoundException, IOException {
		
		int n=0;						//number of files
		Scanner reader = new Scanner(new File(FilePath + "input_1_1M_5mb.txt")); // ADD FILES
		BufferedWriter out; 
		int total;						//total number of tuples in the text file
		double mm;						//size of main memory
		double temp_mm = 0.0;
		total = reader.nextInt();
		String check_mm = reader.next();
		if(check_mm.length() == 4)
		{
			mm = (double)Integer.valueOf(check_mm.substring(0,2));
		}
		else 
		{
			mm = (double)Integer.valueOf(check_mm.substring(0,1));
		}
		if(mm <=2.0)
		{
			operation_size = ((double)Runtime.getRuntime().freeMemory()/1000000)/1.5;
			mm = 	(double)Runtime.getRuntime().freeMemory()/1000000;
			temp_mm = 2.0;
		}
		else if(mm>2.0 &&mm<=4.0)
		{
			operation_size = 2.0;
		}
		else if(mm == 5.0)
		{
			operation_size = 3.0;
		}
		else if(mm > 5.0)
		{
			operation_size = 4.0;
		}
		int arr[];												//array to store a particular set of numbers from a file
		int count = 0;//to keep a track of the numbers
		int loa = (int)((mm-operation_size)*1000000)/4;
		if(loa >= total) {
			loa = total;
		}
		if(loa > 1000000)
		{
			loa = 1000000;
		}
		arr = new int[loa];
		int ct=total;
		while(reader.hasNext()) {
			out = new BufferedWriter(new FileWriter(new File(FilePath + "sort_"+n +".txt"))); // ADD FILES
			while(count<arr.length) {
				if(reader.hasNext()) {
					arr[count] = reader.nextInt();
					count++;
				}
			}
			Arrays.sort(arr);
			for(int i=0; i<arr.length; i++) {
				out.write(Integer.toString(arr[i]));
				out.newLine();
			}
			ct = ct-count;
			if(ct<count)
				arr = new int[ct];
			count =0;
			n++;
			out.close();
		}
		reader.close();
		System.out.println("Number of files created = " + n);
		arr = null;
		System.gc();
		if(n>1) {
		   mergeOperation(total, mm, n,temp_mm);
		}
	}
	
	static void mergeOperation(int total, double mm, int n, double temp_mm) throws FileNotFoundException, IOException{
		
		if(temp_mm == 2.0)
		{
			mm = Runtime.getRuntime().freeMemory()/1000000.0;
			operation_size = (Runtime.getRuntime().freeMemory()/1000000.0)/1.5;
			System.out.println(mm + " " + operation_size);
		}
		
		int b_elements;												//number of elements in a buffer
		int[] p = new int[n];										//pointers to keep a track of elements in the buffer
		
		b_elements = ((int) ((mm-operation_size)*1000000/(n+1))/4) ;
		if(temp_mm == 2.0)
		{
			b_elements = 1100;
		}
		if(b_elements>=total) {
			b_elements = (total/(n+1));
		}
		int[][] buffer_array = new int[n+1][b_elements];
		int check;
		int ncf=0;													//counter for number of files
		int min;													//to keep a minimum for comparison
		int min_array_number=0;										//to keep a number for the array for the minimum number
		int min_array_position=0;									// to keep the pointer to position
		int count_elements = 0;
		Scanner[] reader = new Scanner[n];
		BufferedWriter out = new BufferedWriter(new FileWriter(new File(FilePath + "Final_list"+".txt"))); //ADD FILES
		
		for(;ncf<n;ncf++) {
			reader[ncf] = new Scanner(new File(FilePath + "sort_"+ncf+".txt")); //ADD FILES
		}
		ncf = 0;							
		for(int i = 0; i<n; i++) {
			p[i] = b_elements;
		}
		
		
		/*merging the files using buffers*/
		while(true) {
			/*reading from the files to input buffers*/
			while(ncf<n) {
				
				if(p[ncf] == b_elements && reader[ncf].hasNext()) {
					p[ncf] = 0;
				for(int i=0; i<b_elements; i++) {
					if(reader[ncf].hasNext())
					buffer_array[ncf][i] = reader[ncf].nextInt();
					else
						break;
				}
				
				}
				ncf++;
			}
			
			ncf = 0;
			for(int k=0; k<b_elements; k++) {
				min = Integer.MAX_VALUE;
				//doing the comparison for first element
				for(int i=0; i<n; i++) {
					if(p[i] < b_elements) {	
					if(buffer_array[i][p[i]]< min) {					
						min = buffer_array[i][p[i]];			
						min_array_number = i;
						min_array_position = p[i];		
					}
				//System.out.println("Minimum element is "+min);	
				}
				}
				buffer_array[n][k] = min;
				p[min_array_number] = min_array_position+1;
			}
			//int m=0;
			for(int i=0; i<b_elements; i++) {
				out.write(Integer.toString(buffer_array[n][i]));
				out.newLine();
				count_elements++;
				if(count_elements == total) {
					break;
				}
			}
			if(count_elements == total) {
				break;
			}
		}
		out.close();
		for(int i=0; i<n; i++) {
			reader[i].close();
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		
		
long val=System.currentTimeMillis();
		
		System.gc();		   
		initial_sort();
		
		
		
		System.out.println("Running time actual "+(System.currentTimeMillis()-val));
		
		
	}
}

