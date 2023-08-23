import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int maxDepth, lastCall;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[101];
			for (int i = 0; i <= 100; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);				
			}

			bfs(start);
			
			System.out.println("#" + tc + " " + lastCall);
		}
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new ArrayDeque<>();
		visited = new boolean[101];
		visited[start] = true;
		maxDepth = 0;
		lastCall = 0;
		queue.add(new int[] {start, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			if(cur[1] > maxDepth) {
				maxDepth = cur[1];
				lastCall = cur[0];
			}
			else if(cur[1] == maxDepth)
				lastCall = Math.max(lastCall, cur[0]);
			
			for(int i : graph[cur[0]]) {
				if(visited[i])continue;
				visited[i] = true;
				queue.add(new int[] {i, cur[1] + 1});
			}
		}
	}
}