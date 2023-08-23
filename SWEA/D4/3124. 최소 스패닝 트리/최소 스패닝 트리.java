import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int V, E;
	static Edge[] edges;
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			edges = new Edge[E];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int weight = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(from, to, weight);
			}
			
			make();
			
			Arrays.sort(edges);
			
			long answer = 0;
			int cnt = 0;
			for(Edge e : edges) {
				if(union(e.from, e.to)) {
					answer += e.weight;
					if(++cnt == V - 1)break;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot)return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if(a == parents[a])return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[V];
		for(int i = 0; i < V; i++)parents[i] = i;
	}

}

class Edge implements Comparable<Edge>{
	int from;
	int to;
	int weight;
	public Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}