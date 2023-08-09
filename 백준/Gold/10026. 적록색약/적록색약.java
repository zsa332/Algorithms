import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] map;
	static boolean[][][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		int rgb = 0;
		int rb = 0;
		visited = new boolean[2][N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[0][i][j]) {
					visited[0][i][j] = true;
					dfs(i, j, 0);
					rgb++;
				}
				if(!visited[1][i][j]) {
					visited[1][i][j] = true;
					dfs(i, j, 1);
					rb++;
				}
			}
		}
		System.out.println(rgb + " " + rb);
	}

	public static void dfs(int x, int y, int vIdx) {
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[vIdx][nx][ny]) continue;
			if(vIdx == 0 && map[x][y] == map[nx][ny]) {
				visited[vIdx][nx][ny] = true;
				dfs(nx, ny, vIdx);
			}
			if(vIdx == 1 && (map[x][y] == 'B' && map[nx][ny] == 'B' || map[x][y] == 'R' && map[nx][ny] != 'B'|| map[x][y] == 'G' && map[nx][ny] != 'B')) {
				visited[vIdx][nx][ny] = true;
				dfs(nx, ny, vIdx);
			}
		}
	}

}