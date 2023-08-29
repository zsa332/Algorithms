import java.util.Scanner;

public class Main {
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		answer = Integer.MAX_VALUE;
		recursive(n, 0);
		System.out.println(answer);
	}

	private static void recursive(int n, int cnt) {
		if(cnt > answer || n < 1) {
			return;
		}
		if(n == 1) {
			answer = Math.min(answer, cnt);
			return;
		}
		if(n % 3 == 0)recursive(n/3, cnt+1);
		if(n % 2 == 0)recursive(n/2, cnt+1);
		recursive(n-1, cnt+1);
	}

}
