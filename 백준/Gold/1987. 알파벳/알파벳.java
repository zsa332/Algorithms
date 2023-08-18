import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int R, C, ans;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		visited = new boolean[26];
		dfs(0, 0, 0);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int cnt) {
		int idx = map[x][y] - 'A';
		if (visited[idx]) {
			ans = Math.max(ans, cnt);
			return;
		} else {

			visited[idx] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (nx < 0 || ny < 0 || nx >= R || ny >= C)
					continue;
				dfs(nx, ny, cnt + 1);

			}
		}
		visited[idx] = false;
	}

}