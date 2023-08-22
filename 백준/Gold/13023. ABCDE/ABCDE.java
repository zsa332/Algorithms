import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] friends;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		friends = new ArrayList[N];
		visited = new boolean[N];
		
		for(int i = 0; i < N; i++) {
			friends[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			friends[a].add(b);
			friends[b].add(a);
		}
		
		boolean check = false;
		for(int i = 0; i < N; i++) {
			visited[i] = true;
			if(check = dfs(i, 0)) break;
			visited[i] = false;
		}
		
		int answer = 0;
		if(check)answer = 1;
		System.out.println(answer);

	}
	private static boolean dfs(int a, int cnt) {
		if(cnt >= 4) return true;

		boolean check = false;
		for(int i = 0; i < friends[a].size(); i++) {
			if(!visited[friends[a].get(i)]) {
				visited[friends[a].get(i)] = true;
				if(check = dfs(friends[a].get(i), cnt+1))break;
				visited[friends[a].get(i)] = false;
			}
		}
		return check;
	}

}
