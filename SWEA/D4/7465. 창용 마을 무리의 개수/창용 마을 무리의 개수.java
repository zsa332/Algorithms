import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			graph = new ArrayList[N];
			for (int i = 0; i < N; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken())-1;
				graph[u].add(v);
				graph[v].add(u);
			}

			visited = new boolean[N];
			int answer = 0;
			for (int i = 0; i < N; i++) {
				if(!visited[i]) {
					dfs(i);
					answer++;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void dfs(int n) {
		visited[n] = true;
		for(int i = 0; i < graph[n].size(); i++) {
			if(!visited[graph[n].get(i)])dfs(graph[n].get(i));
		}
	}
}