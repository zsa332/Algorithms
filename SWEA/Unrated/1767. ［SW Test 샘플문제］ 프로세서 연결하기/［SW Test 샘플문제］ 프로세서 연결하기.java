import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int N, max, totalCnt, min, map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<int[]> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (i == 0 || j == 0 || i == N - 1 || j == N - 1)
						continue;
					if (map[i][j] == 1) {
						list.add(new int[] { i, j });
						totalCnt++;
					}
				}
			}
			go(0,0);
			System.out.println("#" + tc + " " + min);
		}
	}

	private static void go(int idx, int cnt) {
		// 가지 치기 : 현재까지 연결된 코어수 + 남은 코어수 < 임시 최대 코어 연결수
		if (cnt + totalCnt - idx < max)
			return;

		// 기저 조건 처리
		if (idx == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이의 합
			if(cnt > max) {
				max = cnt;
				min = res;
			} else if(cnt == max){
				min = Math.min(min, res);
			}
			
			return;
		}
			
		int[] cur = list.get(idx);
		int r = cur[0];
		int c = cur[1];
		// 현재 코어 선택(4방향)
		for (int d = 0; d < 4; d++) {
			// 현재 코어의 위치에서 해당 방향으로 전선 놓기가 가능한지 체크
			if (!isAvailable(r, c, d))
				continue;
			// 가능하다면 전선 놓기
			setStatus(r, c, d, 2);
			// 다음 코어로 가기
			go(idx + 1, cnt + 1);
			// 전선 지우기
			setStatus(r, c, d, 0);
		}

		// 현재 코어 비선택
		go(idx + 1, cnt);

	}

	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2)lCnt++;
			}
		}
		return lCnt;
	}

	private static void setStatus(int r, int c, int d, int status) {
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N)break;
			map[nr][nc] = status;
		}
	}

	private static boolean isAvailable(int r, int c, int d) {
		int nr = r;
		int nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr < 0 || nc < 0 || nr >= N || nc >= N)break;
			if(map[nr][nc] != 0)return false;
		}
		return true;
	}
}
