import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, minTaste;
	static int[][] synergy;
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			synergy = new int[N][N];
			for(int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N];
			answer = Integer.MAX_VALUE;
			dfs(0, 0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static void dfs(int start, int cnt) {
		if(cnt == N/2) {
			int tasteA = 0;
			int tasteB = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					if(visited[i] && visited[j]) {
						tasteA += synergy[i][j] + synergy[j][i];
					}
					else if(!visited[i] && !visited[j]) {
						tasteB += synergy[i][j] + synergy[j][i];
					}
				}
			}
			
			int t = Math.abs(tasteA - tasteB);
			answer = Math.min(answer, t);
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
