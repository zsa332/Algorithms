import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int R, C;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Point start = null;
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == 'S')start = new Point(i, j);
			}
		}
		
		int answer = escapeMaze(start);
		if(answer == Integer.MAX_VALUE)System.out.println("KAKTUS");
		else System.out.println(answer);
	}
	private static int escapeMaze(Point start) {
		int moveNum = Integer.MAX_VALUE;
		
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {start.x, start.y, 0});
		
		int minute = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			
			if(map[cur[0]][cur[1]] == 'D') {
				moveNum = cur[2];
				break;
			}
			
			if(minute != cur[2]) {
				waterZone();
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == '*' || map[cur[0]][cur[1]] == '*' || visited[nx][ny]) continue;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny, cur[2]+1});
			}
			minute = cur[2];
		}
		
		return moveNum;
	}
	private static void waterZone() {
		Queue<int[]> queue = new ArrayDeque<>();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == '*')queue.add(new int[] {i, j});
			}
		}
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == 'D' || map[nx][ny] == '*') continue;
				map[nx][ny] = '*';
			}
		}
	}
}