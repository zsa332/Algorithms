import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static List<Integer>[] party;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N + 1];
		for(int i = 0; i <= N; i++)parents[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		for(int i = 0; i < k; i++) {
			union(0, Integer.parseInt(st.nextToken()));
		}
		
		party = new ArrayList[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int pNum = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<>();
			for(int j = 0; j < pNum; j++) {
				int p = Integer.parseInt(st.nextToken());
				party[i].add(p);
				if(j > 0)union(party[i].get(0), p);
			}
		}
		
		int answer = M;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < party[i].size(); j++) {
				if(find(party[i].get(j)) == 0) {
					answer--;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		if(aRoot > bRoot) {
			int tmp = aRoot;
			aRoot = bRoot;
			bRoot = tmp;
		}
		
		parents[bRoot] = aRoot;
		return true;
	}

	private static int find(int n) {
		if(n == parents[n])return n;
		else return parents[n] = find(parents[n]);
	}
}
