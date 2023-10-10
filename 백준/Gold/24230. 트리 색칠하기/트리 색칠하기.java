import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] targetColor,  treeColor;
	static boolean[] visited;
	static List<Integer>[] tree;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		targetColor = new int[N];
		tree = new ArrayList[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			targetColor[i] = Integer.parseInt(st.nextToken());
			tree[i] = new ArrayList<>();
		}
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			
			tree[p].add(c);
			tree[c].add(p);
		}
		
		
		treeColor = new int[N];
		visited = new boolean[N];
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(0);
		visited[0] = true;
		int cnt = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			if(treeColor[cur] != targetColor[cur]) {
				treeColor[cur] = targetColor[cur];
				cnt++;
			}
			
			for(int i = 0; i < tree[cur].size(); i++) {
				int idx = tree[cur].get(i);
				if(visited[idx])continue;
				treeColor[idx] = treeColor[cur];
				visited[idx] = true;
				queue.add(idx);
			}
		}
		return cnt;
	}
}