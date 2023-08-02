import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dy = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int N, M, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			answer = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					bugKill(i,j);
				}
			}
			

			System.out.println("#" + tc + " " + answer);
			
		}
	}
	
	public static void bugKill(int x, int y) {
		int answer1 = map[x][y];
		int answer2 = map[x][y];
		for (int i = 0; i < 8; i++) {
			for(int j = 1; j < M; j++) {
				int nx = x + dx[i] * j; 
				int ny = y + dy[i] * j;
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
					if(i < 4)answer1 += map[nx][ny];
					else answer2 += map[nx][ny];
				}
			}
		}
		
		answer = Math.max(answer, answer1);
		answer = Math.max(answer, answer2);
	}
}
