import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int size;
	static int[] dx = { 1, -1, -1, 0, -1, 1, 1, 0 };
	static int[] dy = { -1, 0, -1, -1, 1, 0, 1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		size = 19;
		map = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int winner = 0;
		int x = 0;
		int y = 0;
		boolean isFive = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (map[i][j] != 0) {
					if (isFive = fiveCheck(i, j, map[i][j])) {
						winner = map[i][j];
						x = i + 1;
						y = j + 1;
						break;
					}
				}
			}
			if (isFive)
				break;
		}
		System.out.println(winner);
		if (winner != 0)
			System.out.println(x + " " + y);
		br.close();
	}

	public static boolean fiveCheck(int x, int y, int curNum) {
		// 오른쪽 -> 왼쪽의 방향으로 탐색 결과적으로 첫 탐색 위치가 제일 왼쪽 바둑알 위치가 정해짐
		// 8방향 탐색 필요 x 결국 모든 맵을 탐색하면 4방향만 검색해도 모두 탐색하게됨
		for (int i = 4; i < 8; i++) {
			int cnt = 1;
			// 6개이상 연결되어있다면 승리아님

			for (int j = 1; j <= 5; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if (nx >= 0 && ny >= 0 && nx < size && ny < size && map[nx][ny] == curNum) {
					cnt++;
				}else break;
			}

			if (cnt == 5) {
				int px = x + dx[i % 4];
				int py = y + dy[i % 4];
				if (px >= 0 && py >= 0 && px < size && py < size && map[px][py] == curNum)
					return false;
				else
					return true;
			}

		}
		return false;
	}
}
