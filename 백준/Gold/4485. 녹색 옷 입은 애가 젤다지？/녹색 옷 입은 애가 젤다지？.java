import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, weight;
	static int N;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int num = 0;
		while(0 != N) {
			map = new int[N][N];
			weight = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					weight[i][j] = Integer.MAX_VALUE;
				}
			}
			
			weight[0][0] = map[0][0];
			BFS();
			sb.append("Problem ").append(++num).append(": ").append(weight[N-1][N-1]).append("\n");
			N = Integer.parseInt(br.readLine());
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	private static void BFS() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 0});
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
				int w = weight[cur[0]][cur[1]] + map[nx][ny];
				if(w < weight[nx][ny]) {
					weight[nx][ny] = w;
					queue.add(new int[] {nx, ny});
				}	
			}
		}
	}
}
