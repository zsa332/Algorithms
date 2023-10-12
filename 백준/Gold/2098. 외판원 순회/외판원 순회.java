import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, INF = 987654321;
	static int[][] W, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][(1 << N) - 1];
		for(int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		

		System.out.println(tsp(0, 1));
	}
	private static int tsp(int cur, int flag) {
		// 모든 도시 방문 완료
		if(flag == (1 << N) - 1) {
			// 경로 없으면 inf로 탐색 무효화
			if(W[cur][0] == 0)return INF;
			// 경로가 있다면 w[cur][0];
			else return W[cur][0];
		}
		
		//이미 방문한 경우
		if(dp[cur][flag] != -1) return dp[cur][flag];
		
		// 해당 도시 출석 표시
		dp[cur][flag] = INF;
		
		// 방문하지 않은 도시 탐색
		for(int i = 0; i < N; i++) {
			// 경로가 없거나 도시를 이미 방문한 경우 continue
			if(W[cur][i] == 0 || (flag & (1 << i)) != 0)continue;
			dp[cur][flag] = Math.min(dp[cur][flag], tsp(i, flag | (1 << i)) + W[cur][i]);
		}
		
		return dp[cur][flag];
	}
}