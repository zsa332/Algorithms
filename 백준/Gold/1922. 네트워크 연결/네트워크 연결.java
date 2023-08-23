import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] parents;
	static Computer[] coms;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		coms = new Computer[M];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			coms[i] = new Computer(a, b, c);
		}
		
		make();
		
		Arrays.sort(coms);
		
		int answer = 0;
		int cnt = 0;
		for(Computer c : coms) {
			if(union(c.a, c.b)) {
				answer += c.c;
				if(++cnt == N - 1)break;
			}
		}
		System.out.println(answer);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot)
			return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	private static int find(int a) {
		if(a == parents[a])return a;
		return parents[a] = find(parents[a]);
	}
	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++)parents[i] = i;
	}
}

class Computer implements Comparable<Computer>{
	int a;
	int b;
	int c;
	public Computer(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Computer o) {
		return Integer.compare(this.c, o.c);
	}
	
}