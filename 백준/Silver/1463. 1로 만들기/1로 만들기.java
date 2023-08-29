import java.util.Scanner;

public class Main {
	static int answer, dp[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n == 1)System.out.println(0);
		else if(n <= 3)
			System.out.println(1);
		else {
			dp = new int[n + 1];
			dp[1] = 1;
			dp[2] = 1;
			dp[3] = 1;
			for (int i = 4; i <= n; i++) {
				dp[i] = dp[i-1] + 1;
				if(i % 2 == 0)dp[i] = Math.min(dp[i], dp[i/2] + 1);
				if(i % 3 == 0)dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			System.out.println(dp[n]);
		}
	}
}
