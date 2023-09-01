import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N, answer, map[][];
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// 1. 입력 받기
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 2. 영역 나누기
		int labelNum = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					areaLabeling(i, j, labelNum++);
			}
		}

		// 3. 각 영역의 경계선에서 다른 영역까지의 최단거리 찾기
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && isBoundary(i, j)) {
					visited = new boolean[N][N];
					buildTrain(i, j);
				}
			}
		}

		System.out.println(answer - 1);
	}

	private static void buildTrain(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y, 0 });
		visited[x][y] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] != map[x][y]) {
				answer = Math.min(answer, cur[2]);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || map[nx][ny] == map[x][y])
					continue;

				queue.offer(new int[] { nx, ny, cur[2] + 1 });
				visited[nx][ny] = true;
			}
		}

	}

	private static boolean isBoundary(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			if (map[nx][ny] == 0)
				return true;
		}
		return false;
	}

	private static void areaLabeling(int x, int y, int labelNum) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(new Point(x, y));
		map[x][y] = labelNum;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 1)
					continue;

				queue.offer(new Point(nx, ny));
				map[nx][ny] = labelNum;
			}
		}
	}

}