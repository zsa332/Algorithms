import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[][] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		answer = Integer.MAX_VALUE;
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			dfs(i, 0, i, 0);
			visited[i] = false;
		}
		
		System.out.println(answer);
	}

	private static void dfs(int start, int cnt, int cur, int w) {
		if(cnt == N - 1) {
			if(graph[cur][start] == 0) return;
			answer = Math.min(answer, w + graph[cur][start]);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(graph[cur][i] != 0 && !visited[i]) {
				visited[i] = true;
				dfs(start, cnt+1, i, w + graph[cur][i]);
				visited[i] = false;
			}
		}
	}
}
