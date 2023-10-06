import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M, x, y, dir;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		dir = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(runCleanUp());
	}

	private static int runCleanUp() {
		int cnt = 0;
		while (true) {
			if (map[x][y] == 0)	cnt++;
			map[x][y] = -1;
			
			boolean isClean = true;
			for (int i = 0; i < 4; i++) {
				dir = dir - 1 < 0 ? dir + 3 : dir - 1;
				int nx = x + dx[dir];
				int ny = y + dy[dir];
				if (map[nx][ny] == 0) {
					x = nx;
					y = ny;
					isClean = false;
					break;
				}
			}

			if (isClean) {
				int backDir = (dir + 2) % 4;
				int nx = x + dx[backDir];
				int ny = y + dy[backDir];
				if (map[nx][ny] == 1)
					break;
				else {
					x = nx;
					y = ny;
				}
			}
		}
		return cnt;
	}
}
