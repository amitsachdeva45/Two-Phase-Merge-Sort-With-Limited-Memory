import java.util.*;
import java.lang.*;
class DatabaseProject1ASPS {
		static void sort()
		{
			int a[] = new int[1000000];
			System.out.println(Runtime.getRuntime().totalMemory());
			for(int i=0;i<1000000;i++)
			{
				a[i] = (int)(Math.random()*1000000000);
			}
			Arrays.sort(a);
			
			/*for(int i=0;i<1000000;i++)

			{
				System.out.println(a[i]);
			}*/
			System.out.println(Runtime.getRuntime().freeMemory());
			a = null;
			System.gc();
		}
		static void sort3()
		{
			int c[] = new int[500000];
			System.out.println(Runtime.getRuntime().totalMemory());
			for(int i=0;i<500000;i++)
			{
				c[i] = (int)(Math.random()*1000000000);
			}
			Arrays.sort(c);
			/*for(int i=0;i<1000000;i++)

			{
				System.out.println(a[i]);
			}*/
			System.out.println(Runtime.getRuntime().freeMemory());
			c = null;
			System.gc();
		}
		static void sort2()
		{
			for(int j=1;j<=100;j++) {				
				
				int n = 100000 * j;
				System.out.println("*"+n+"*");
				int b[] = new int[n];
				for(int i=0;i<n;i++)
				{
					b[i] = (int)(Math.random()*1000000000);
				}
				Arrays.sort(b);
				System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
				b = null;
				System.gc();
			}
		}

	public static void main(String[] args) {
		
		//sort();
		System.out.println(Runtime.getRuntime().totalMemory());
		sort2();
		/*int n = 1000000;
		int a[] = new int[n];
		for(int i=0;i<n;i++)
		{
			a[i] = (int)(Math.random() *100000000);
		}
		
		System.out.println(Runtime.getRuntime().freeMemory());*/
		//sort3();
		
	}

}
