import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int N, M;
	static int result;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static class Virus {
		int x;
		int y;
		
		Virus(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int cnt) {
		if(cnt == 3) {
			bfs();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(cnt+1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	public static void bfs() {
		Queue<Virus> queue = new LinkedList<>();
		int[][] copyMap = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 2) {
					queue.add(new Virus(i, j));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Virus virus = queue.poll();
			int x = virus.x;
			int y = virus.y;
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if(copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = 2;
						queue.add(new Virus(nx, ny));
					}
				}
			}
		}
		
		int count = countSafeArea(copyMap);
		result = Math.max(result, count);
	}

	private static int countSafeArea(int[][] copyMap) {
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(copyMap[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
}