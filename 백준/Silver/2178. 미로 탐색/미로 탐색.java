import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	static int[][] map;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < M; j++) {
				map[i][j]= line.charAt(j) - '0';
			}
		}
		
		BFS(0,0);
		
		System.out.println(map[N-1][M-1]);
		
	}

	private static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		while(!queue.isEmpty()) {
			int cur[] = queue.poll();
			for(int k = 0; k < 4; k++) {
				int x = cur[0] + dx[k];
				int y = cur[1] + dy[k];
				if(x < 0 || x >= N || y < 0 || y >= M);
				else if(map[x][y] == 1 && !visited[x][y]) {
					visited[x][y] = true;
					map[x][y] = map[cur[0]][cur[1]] + 1;
					queue.add(new int[] {x, y});
				}
			}
		}
	}
}
