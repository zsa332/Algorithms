import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int H, W;
	static char[][] map;
	static int[][][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static Point[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new char[H][W];
		P = new Point[2];
		int pIdx = 0;
		for(int i = 0; i < H; i++) {
			String line = br.readLine();
			for(int j = 0; j < W; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'C')P[pIdx++] = new Point(i, j);
			}
		}
		
		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> { return Integer.compare(o1[3], o2[3]); });
		visited = new int[4][H][W];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < H; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
			visited[i][P[0].x][P[0].y] = 0;
		}

		queue.offer(new int[] {P[0].x, P[0].y, 0, 0});
		int rotate = Integer.MAX_VALUE;
		
		while(!queue.isEmpty()) {
			
			int[] cur = queue.poll();
			
			
			if(cur[0] == P[1].x && cur[1] == P[1].y) {
				rotate = Math.min(rotate, cur[3]);
				continue;
			}

			if(visited[cur[2]][cur[0]][cur[1]] < cur[3])continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= H || ny >= W || visited[i][nx][ny] <= cur[3] || map[nx][ny] == '*')continue;
				
				int nextCost = (cur[2] == i || (cur[0] == P[0].x && cur[1] == P[0].y)) ? cur[3] : cur[3] + 1;

				visited[i][nx][ny] = nextCost;
				if(cur[0] == P[0].x && cur[1] == P[0].y)queue.offer(new int[] {nx, ny, i, cur[3]});
				else if(cur[2] == i) {
					queue.offer(new int[] {nx, ny, i, cur[3]});
				}
				else queue.offer(new int[] {nx, ny, i, cur[3] + 1});
			}
			
		}
		return rotate;
	}
}
