import java.awt.Point;
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

		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];

		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 1;
		}

		int L = Integer.parseInt(br.readLine());
		Command[] commands = new Command[L];
		
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			char command = st.nextToken().charAt(0);
			commands[i] = new Command(second, command);
		}

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		Queue<Point> queue = new ArrayDeque<>();
		queue.add(new Point(0, 0));
		Point head = new Point(0, 0);
		int dir = 0, time = 0, idx = 0;
		while (!queue.isEmpty()) {
			time++;
			if (idx < L && time-1 == commands[idx].second) {
				switch (commands[idx].command) {
				case 'L':
					dir--;
					break;
				case 'D':
					dir++;
					break;
				}
				if(dir == -1)dir = 3;
				else if(dir == 4)dir = 0;
				if(idx < L - 1)idx++;
			}
			int nx = head.x + dx[dir];
			int ny = head.y + dy[dir];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2)
				break;

			if (map[nx][ny] == 0) {
				Point tail = queue.poll();
				map[tail.x][tail.y] = 0;
			}
			head = new Point(nx, ny);
			queue.add(head);
			map[nx][ny] = 2;
		}
		
		System.out.println(time);
	}

	static class Command {
		int second;
		char command;

		public Command(int second, char command) {
			this.second = second;
			this.command = command;
		}
	}
}
