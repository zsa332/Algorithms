import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N x M 크기의 배열과 배열의 값들이 입력된다.
 * 이때 이 배열의 구성원들을 R번 회전하게 되고 회전후의 결과를 출력하면된다.
 * 
 * 입력
 *  2 ≤ N, M ≤ 300
 *  1 ≤ R ≤ 1,000
 *  min(N, M) mod 2 = 0
 *  1 ≤ Aij ≤ 108
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int c = N > M ? M / 2 : N / 2;
		for (int r = 0; r < R; r++) {

			for (int d = 0; d < c; d++) {
				int tmp = map[d][d];
				// 상 오른쪽에서 왼쪽으로
				for (int i = d + 1; i < M - d; i++) {
					map[d][i - 1] = map[d][i];
				}
				// 우 아래에서 위쪽으로
				for (int i = d + 1; i < N - d; i++) {
					map[i - 1][M - d - 1] = map[i][M - d - 1];
				}
				// 하 왼쪽에서 오른쪽으로
				for (int i = M - d - 2; i >= d; i--) {
					map[N - d - 1][i+1] = map[N - d - 1][i];
				}
				// 좌 위에서 아래로
				for (int i = N - d - 2; i >= d; i--) {
					map[i+1][d] = map[i][d];
				}
				map[d + 1][d] = tmp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
