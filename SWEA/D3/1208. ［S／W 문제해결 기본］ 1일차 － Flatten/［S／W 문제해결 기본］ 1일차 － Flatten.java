import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T;
		T=10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < dump; i++) {
				Arrays.sort(arr);
				arr[0]++;
				arr[arr.length-1]--;
			}
			Arrays.sort(arr);
			System.out.println("#"+test_case+" "+(arr[arr.length-1]-arr[0]));
		}
	
	}
}