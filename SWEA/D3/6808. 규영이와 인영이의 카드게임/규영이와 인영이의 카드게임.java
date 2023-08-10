import java.io.*;
import java.util.*;

public class Solution {

	static int[] A, B, C;
	static int win;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			boolean[] check = new boolean[18];
			A = new int[9];
			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				check[A[i] - 1] = true;
			}

			B = new int[9];
			C = new int[9];
			for (int i = 0, j = 0; i < 18; i++) {
				if (!check[i])
					B[j++] = i + 1;
			}
			win = 0;
			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(win).append(" ").append(362880 - win).append("\n");

		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void dfs(int cnt, int flag) {
		if (cnt == 9) {
			int scoreA = 0, scoreB = 0;
			for (int i = 0; i < 9; i++) {
				if (A[i] > C[i]) {
					scoreA += A[i] + C[i];
				} else if (A[i] < C[i])
					scoreB += A[i] + C[i];
			}
			if (scoreA > scoreB)
				win++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if ((flag & 1 << i) != 0)
				continue;

			C[cnt] = B[i];
			dfs(cnt + 1, flag | 1 << i);
		}
	}

}