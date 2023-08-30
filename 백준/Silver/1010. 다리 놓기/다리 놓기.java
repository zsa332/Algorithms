import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[b+1][a+1];
			dp[0][0] = 1;
			for (int i = 0; i <= b; i++) {
				for (int j = 0, end = Math.min(i, a); j <= end; j++) {
					if(j == 0 || i == j)dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			System.out.println(dp[b][a]);
		}
	}
}
