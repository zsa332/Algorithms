import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] adj;
	static int N, K, answer;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == j) continue;
					adj[i][j] = Math.min(adj[i][j], adj[k][j] + adj[i][k]);
				}
			}
		}
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];
		visited[K] = true;
		combination(1, K, 0);
		System.out.println(answer);
	}
	private static void combination(int cnt, int cur, int sum) {
		if(cnt == N) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			combination(cnt + 1, i, sum + adj[cur][i]);
			visited[i] = false;
		}
	}
}
