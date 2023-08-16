import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static int R, C, ans;
	static int[] dr = {-1, 0, 1};
	static int[] dc = {1, 1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for(int i = 0; i < R; i++) {
			String line = br.readLine();
			for(int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for(int i = 0; i < R; i++) {
			if(map[i][0] == '.')dfs(i, 0);
		}
		
		System.out.println(ans);
	}
	private static void print() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void dfs(int r, int c) {
		if(c == C - 1) {
			ans++;
			return;
		}
		
		map[r][c] = (char)(ans + '0');
		
		int check = ans;
		move : for(int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(nr >= 0 && nc >= 0 && nr < R && nc < C && map[nr][nc] == '.') {
				dfs(nr, nc);
				if(check != ans)break move;
			}
		}
	}
}