import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static Edge[] edges;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;
			edges = new Edge[M];
			int totalCost = 0;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				edges[i] = new Edge(x, y, z);
				totalCost += z;
			}

			make();

			Arrays.sort(edges);

			long result = 0;
			int cnt = 0;
			for (Edge e : edges) {
				if (union(e.x, e.y)) {
					result += e.z;
					if (++cnt == N - 1)
						break;
				}
			}
			System.out.println(totalCost - result);
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int a) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[N];
		for (int i = 0; i < N; i++)
			parents[i] = i;
	}

	static class Edge implements Comparable<Edge> {
		int x;
		int y;
		int z;

		public Edge(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.z, o.z);
		}
	}
}
