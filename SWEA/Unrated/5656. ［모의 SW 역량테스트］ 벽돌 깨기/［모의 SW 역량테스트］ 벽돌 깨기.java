import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, H, W, answer;
	static int[][] map, copyMap;
	static int[] ballLoc;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[16][13];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ballLoc = new int[N];
			answer = Integer.MAX_VALUE;
			bruteforce(0);
			System.out.println("#" + tc + " " + answer);
		}
	}

	private static void bruteforce(int cnt) {
		if (cnt == N) {
			copyMap = new int[16][13];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			brokenBlock();
			return;
		}

		for (int i = 0; i < W; i++) {
			ballLoc[cnt] = i;
			bruteforce(cnt + 1);
		}
	}

	private static void brokenBlock() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < H; j++) {
				if (copyMap[j][ballLoc[i]] != 0) {
					removeBlock(j, ballLoc[i]);
					break;
				}
			}

			// 블럭 드랍
			for (int j = 0; j < W; j++) {
				int blank = H - 1;
				for (int k = H - 1; k >= 0; k--) {
					if(copyMap[k][j] != 0) {
						copyMap[blank--][j] = copyMap[k][j];
						if(blank + 1 != k)copyMap[k][j] = 0;
					}
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (copyMap[i][j] != 0)
					cnt++;
			}
		}
		answer = Math.min(answer, cnt);
	}

	private static void removeBlock(int x, int y) {
		int range = copyMap[x][y];
		copyMap[x][y] = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < range; j++) {
				int nx = x + dx[i] * j;
				int ny = y + dy[i] * j;

				if (nx < 0 || ny < 0 || nx >= H || ny >= W)
					break;
				if (copyMap[nx][ny] > 1)
					removeBlock(nx, ny);
				else
					copyMap[nx][ny] = 0;
			}
		}
	}
}
