import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Edge> edges;
	static int[] parents;
	static int N;
	static int[][] islandPoint;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			islandPoint = new int[N][2];

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				islandPoint[i][0] = Integer.parseInt(st.nextToken());
			}	
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				islandPoint[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			edges = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i != j) {
						long disX = Math.abs(islandPoint[i][0] - islandPoint[j][0]);
						long disY = Math.abs(islandPoint[i][1] - islandPoint[j][1]);
						
						long dis = disX * disX + disY * disY;
						edges.add(new Edge(i, j, dis));
					}
				}
			}
			
			make();
			Collections.sort(edges);
			
			int cnt = 0;
			double result = 0;
			for(Edge e : edges) {
				if(union(e.from, e.to)) {
					result += e.weight;
					if(++cnt == N - 1)break;
				}
			}
			System.out.println("#" + tc + " " + Math.round(result * E));
		}

	}
	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++)parents[i] = i;
	}
	
	private static int find(int a) {
		if(a == parents[a])return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
}
class Edge implements Comparable<Edge>{
	int from;
	int to;
	long weight;
	
	public Edge(int from, int to, long weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return Long.compare(this.weight, o.weight);
	}
	
}