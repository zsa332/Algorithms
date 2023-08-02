import java.util.Scanner;

public class Main {
	static int[] dp = new int[5001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		dp[3] = 1;
		dp[5] = 1;
		for (int i = 6; i < dp.length; i++) {
			if (dp[i - 3] != 0)
				dp[i] = dp[i - 3] + 1;
			if (dp[i - 5] != 0)
				dp[i] = dp[i] != 0 ? Math.min(dp[i], dp[i - 5] + 1) : dp[i - 5] + 1;
		}

		dp[N] = dp[N] != 0 ? dp[N] : -1;

		System.out.println(dp[N]);

	}

}
