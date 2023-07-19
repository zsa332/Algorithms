import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		
		int[] start = new int[N];
		int[] end = new int[N];
		
		for(int i = 0; i < N; i++) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int current = 0;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(current < start[i])current = start[i];
			
			while(current < end[i]) {
				current += L;
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}