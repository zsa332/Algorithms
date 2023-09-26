import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Point start = null;
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0')start = new Point(i, j);
			}
		}
		int answer = escapeMaze(start);
		if(answer == Integer.MAX_VALUE)answer = -1;
		System.out.println(answer);
	}
	private static int escapeMaze(Point start) {
		boolean[][][] visited = new boolean[64][N][M];
		
		Queue<Status> queue = new ArrayDeque<>();
		queue.add(new Status(start.x, start.y, 0, 0));
		int move = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			Status cur = queue.poll();
			if(map[cur.x][cur.y] == '1') {
				move = Math.min(move, cur.moveNum);
			}
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
				if(map[nx][ny] == '#' || visited[cur.keys][nx][ny]) {
					continue;
				}
				if(map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
					visited[cur.keys][nx][ny] = true;
					queue.add(new Status(nx, ny, cur.keys | (1 << (map[nx][ny] - 'a')), cur.moveNum + 1));
				}
				else if(map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {
					int check = cur.keys & (1 << (map[nx][ny] - 'A'));
					if(check > 0) {
						visited[cur.keys][nx][ny] = true;
						queue.add(new Status(nx, ny, cur.keys, cur.moveNum + 1));
					}
				}
				else {
					visited[cur.keys][nx][ny] = true;
					queue.add(new Status(nx, ny, cur.keys, cur.moveNum + 1));
				}
			}
		}
		return move;
	}
	
	static class Status{
		int x;
		int y;
		int keys;
		int moveNum;
		
		public Status(int x, int y, int keys, int moveNum) {
			this.x = x;
			this.y = y;
			this.keys = keys;
			this.moveNum = moveNum;
		}
	}
}