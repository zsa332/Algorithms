import java.util.*;
import java.io.*;

public class Main {
	static class Node implements Comparable<Node>{
		int n;
		int weight;
		public Node(int n, int weight) {
			this.n = n;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static List<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i = 0; i <= V; i++)graph[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v,w));
		}
		
		Queue<Node> pQueue = new PriorityQueue<>();
		boolean[] visited = new boolean[V+1];
		
		int[] minDist = new int[V + 1];
		Arrays.fill(minDist, Integer.MAX_VALUE);
		minDist[K] = 0;
		
		int cnt = 0;
		pQueue.offer(new Node(K, 0));
		while(!pQueue.isEmpty()) {
			Node cur = pQueue.poll();
			
			if(visited[cur.n])continue;
			
			visited[cur.n] = true;
			minDist[cur.n] = cur.weight;
			if(++cnt == V)break;
			
			for(Node n : graph[cur.n]) {
				if(!visited[n.n] && minDist[n.n] > minDist[cur.n] + n.weight) {
					pQueue.offer(new Node(n.n, minDist[cur.n] + n.weight));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= V; i++) {
			if(minDist[i] != Integer.MAX_VALUE)sb.append(minDist[i]).append("\n");
			else sb.append("INF\n");
		}
		
		System.out.println(sb.toString());
	}
}
