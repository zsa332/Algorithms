import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int size;
	static int[] dx = { 1, -1, -1, 0, -1, 1, 1, 0 };
	static int[] dy = { -1, 0, -1, -1, 1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		size = 19;
		map = new int[size][size];

		int N = Integer.parseInt(st.nextToken());
		int answer = -1;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;

			map[x][y] = i % 2 == 0 ? 2 : 1;
			if (fiveCheck(x, y, map[x][y])) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}

	public static boolean fiveCheck(int x, int y, int curNum) {
		for (int i = 0; i < 4; i++) {
			int cnt = 1;
			for (int j = 1; j <= 4; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;
				if (nx >= 0 && ny >= 0 && nx < size && ny < size && map[nx][ny] == curNum) {
					cnt++;
				} else
					break;
			}
			for (int j = 1; j <= 4; j++) {
				int nx = x + dx[i + 4] * j;
				int ny = y + dy[i + 4] * j;
				if (nx >= 0 && ny >= 0 && nx < size && ny < size && map[nx][ny] == curNum) {
					cnt++;
				} else
					break;
			}
			if (cnt == 5)
				return true;
		}
		return false;
	}
}
