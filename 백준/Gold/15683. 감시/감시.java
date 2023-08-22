import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static int[][] map, copyMap;
	static int[] dir;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static List<Point> cctv;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cctv = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0 && map[i][j] != 6)
					cctv.add(new Point(i, j));
			}
		}
		dir = new int[cctv.size()];
		ans = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(ans);

	}

	private static void permutation(int cnt) {
		if (cnt == cctv.size()) {
			checkMap();
			return;
		}

		for (int i = 0; i < 4; i++) {
			dir[cnt] = i;
			permutation(cnt + 1);
		}

	}

	private static void checkMap() {
		copyMap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < cctv.size(); i++) {
			int x = cctv.get(i).x;
			int y = cctv.get(i).y;
			int type = copyMap[x][y];
			switch (type) {
			case 1:
				cctvCheck(x, y, dir[i]);
				break;
			case 2:
				if (dir[i] < 2) {
					cctvCheck(x, y, 0);
					cctvCheck(x, y, 2);
				} else {
					cctvCheck(x, y, 1);
					cctvCheck(x, y, 3);
				}
				break;
			case 3:
				if (dir[i] == 0) {
					cctvCheck(x, y, 0);
					cctvCheck(x, y, 1);
				}
				else if(dir[i] == 1) {
					cctvCheck(x, y, 1);
					cctvCheck(x, y, 2);
				}
				else if(dir[i] == 2) {
					cctvCheck(x, y, 2);
					cctvCheck(x, y, 3);
				}
				else if(dir[i] == 3) {
					cctvCheck(x, y, 3);
					cctvCheck(x, y, 0);
				}
					break;
			case 4:
				if (dir[i] == 0) {
					cctvCheck(x, y, 0);
					cctvCheck(x, y, 1);
					cctvCheck(x, y, 2);
				}
				else if(dir[i] == 1) {
					cctvCheck(x, y, 1);
					cctvCheck(x, y, 2);
					cctvCheck(x, y, 3);
				}
				else if(dir[i] == 2) {
					cctvCheck(x, y, 2);
					cctvCheck(x, y, 3);
					cctvCheck(x, y, 0);
				}
				else if(dir[i] == 3) {
					cctvCheck(x, y, 3);
					cctvCheck(x, y, 0);
					cctvCheck(x, y, 1);
				}
				break;
			case 5:
				cctvCheck(x, y, 0);
				cctvCheck(x, y, 1);
				cctvCheck(x, y, 2);
				cctvCheck(x, y, 3);
				break;
			}
		}
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0)count++;
			}
		}
		ans = Math.min(ans, count);
	}

	private static void cctvCheck(int x, int y, int d) {
		for (int i = 1; i <= 8; i++) {
			int nx = x + dx[d] * i;
			int ny = y + dy[d] * i;
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)break;
			if(copyMap[nx][ny] == 6) break;
			if(copyMap[nx][ny] == 0)
				copyMap[nx][ny] = 7;
		}
	}

}
