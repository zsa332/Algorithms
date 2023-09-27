import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] dp = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int dist = Integer.parseInt(st.nextToken());
					if(i == j)dp[i][j] = 0;
					else if(dist == 0)dp[i][j] = Integer.MAX_VALUE;
					else dp[i][j] = dist;
				}
			}
			
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < N; j++) {
						if(dp[i][k] != Integer.MAX_VALUE && dp[k][j] != Integer.MAX_VALUE)
							dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
					}
				}
			}
			
			int answer = Integer.MAX_VALUE;
			for(int[] row : dp) {
				int rowSum = 0;
				for(int num : row) {
					rowSum += num;
				}
				answer = Math.min(answer, rowSum);
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
