import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[][][] isVisited = new boolean[K+1][H][W];
		int[] dx = { 0, 0, -1, 1, -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] dy = { -1, 1, 0, 0, -1, 1, -2, 2, -2, 2, -1, 1 };
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.offer(new int[] { 0, 0, 0, 0 });
		
		isVisited[0][0][0] = true;
		int answer = -1;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if(cur[0] == H - 1 && cur[1] == W - 1) {
				answer = cur[3];
				break;
			}
			for (int i = 0; i < 12; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == 1)
					continue;
				if(i > 3 && cur[2] + 1 <= K && !isVisited[cur[2]+1][nx][ny]) {
					queue.offer(new int[] { nx, ny, cur[2] + 1, cur[3] + 1 });
					isVisited[cur[2] + 1][nx][ny] = true;
				}
				if(i <= 3 && !isVisited[cur[2]][nx][ny]) {
					queue.offer(new int[] { nx, ny, cur[2], cur[3] + 1});
					isVisited[cur[2]][nx][ny] = true;
				}
			}
		}
		
		System.out.println(answer);
	}
}