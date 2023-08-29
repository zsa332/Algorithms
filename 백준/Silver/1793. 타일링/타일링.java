import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while (line != null) {
			int N = Integer.parseInt(line);
			BigInteger[] dp = new BigInteger[N + 1];
			if (N < 2)
				System.out.println(1);
			else if (N == 2)
				System.out.println(3);
			else {
				dp[1] = BigInteger.valueOf(1);
				dp[2] = BigInteger.valueOf(3);
				for (int i = 3; i <= N; i++) {
					dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.valueOf(2)));
				}
				System.out.println(dp[N]);
			}
			line = br.readLine();
		}
	}
}
