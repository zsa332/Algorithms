import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R, C, T;
	static int[][] dust;
	static int[] dr = {0, 0, -1, 1};
	static int[] dc = {-1, 1, 0, 0};
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 R = Integer.parseInt(st.nextToken());
		 C = Integer.parseInt(st.nextToken());
		 T = Integer.parseInt(st.nextToken());
		 
		 dust = new int[R][C];
		 Point[] airCleaner = new Point[2];
		 for(int i = 0; i < R; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < C; j++) {
				 dust[i][j] = Integer.parseInt(st.nextToken());
				 if(dust[i][j] == -1) {
					 if(airCleaner[0] == null)
						 airCleaner[0] = new Point(i, j);
					 else	
						 airCleaner[1] = new Point(i, j);
				 }
			 }
		 }
		 
		 for(int t = 0; t < T; t++) {
			 dustDiffusion();
			 rotateDust(airCleaner);
		 }

		 int sum = 0;
		 for(int[] i : dust) {
			 for(int j : i)if(j != -1)sum += j;
		 }
		 System.out.println(sum);
	}
	private static void rotateDust(Point[] airCleaner) {
		// 위쪽
		int r = airCleaner[0].x;
		int c = airCleaner[0].y;
		
		for(int i = r - 1; i > 0; i--) {
			dust[i][c] = dust[i - 1][c];
		}
		for(int i = 0; i < C - 1; i++) {
			dust[0][i] = dust[0][i+1];
		}
		for(int i = 0; i < r; i++) {
			dust[i][C - 1] = dust[i + 1][C - 1];
		}
		for(int i = C - 1; i > 1; i--) {
			dust[r][i] = dust[r][i - 1];
		}
		dust[r][c + 1] = 0;
		
		// 아래쪽		
		r = airCleaner[1].x;
		c = airCleaner[1].y;
		
		for(int i = r + 1; i < R - 1; i++) {
			dust[i][c] = dust[i + 1][c];
		}
		for(int i = 0; i < C - 1; i++) {
			dust[R - 1][i] = dust[R - 1][i+1];
		}
		for(int i = R - 1; i > r; i--) {
			dust[i][C - 1] = dust[i - 1][C - 1];
		}
		for(int i = C - 1; i > 1; i--) {
			dust[r][i] = dust[r][i - 1];
		}
		dust[r][c + 1] = 0;
	}
	
	private static void dustDiffusion() {
		int[][] diffDust = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(dust[i][j] > 0) {
					int cnt = 0;
					int dustW = dust[i][j] / 5;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						
						if(nr < 0 || nc < 0 || nr >= R || nc >= C || dust[nr][nc] == -1)continue;
						diffDust[nr][nc] += dustW;
						cnt++;
					}

					dust[i][j] -= dustW * cnt;
				}
			}
		}

		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				dust[i][j] += diffDust[i][j];
			}
		}
	}
}
