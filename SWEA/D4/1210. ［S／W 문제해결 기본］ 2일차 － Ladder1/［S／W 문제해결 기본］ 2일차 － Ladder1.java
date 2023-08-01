import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] map = new int[100][100];
	static int[] dx = {0, 0, -1};
	static int[] dy = {-1, 1, 0};
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < 100; i++) {
				if(map[99][i] == 2) {
					int x = 99;
					int y = i;
					while(x > 0) {
						for(int j = 0; j < 3; j++) {
							int nx = x + dx[j];
							int ny = y + dy[j];
							if(nx >= 0 && ny >= 0 && nx < 100 && ny < 100 && map[nx][ny] == 1) {
								x = nx;
								y = ny;
								map[x][y]=0;
							}
						}
					}
					answer = y;
				}
			}
			System.out.println("#"+t+" "+answer);
		}
	}
}
