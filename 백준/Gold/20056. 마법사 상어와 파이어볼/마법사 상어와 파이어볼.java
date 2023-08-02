import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<FireBall>[][] map;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static ArrayList<FireBall> fires;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new ArrayList[N][N];
		fires = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			map[r][c].add(new FireBall(r, c, m, s, d));
			fires.add(new FireBall(r, c, m, s, d));
		}

		for (int i = 0; i < K; i++) {
			moveFire();
			mergeFire();
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (FireBall fire : map[i][j])
						answer += fire.m;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void moveFire() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<FireBall>();
			}
		}

		for (FireBall fire : fires) {
			fire.r += dx[fire.d] * fire.s;
			fire.c += dy[fire.d] * fire.s;
			if (fire.r < 0)
				fire.r = N + (fire.r % N);
			if (fire.c < 0)
				fire.c = N + (fire.c % N);
			if (fire.r >= N)
				fire.r %= N;
			if (fire.c >= N)
				fire.c %= N;

			map[fire.r][fire.c].add(fire);
		}
	}

	public static void mergeFire() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 2) {
					int avgM = 0;
					int avgS = 0;
					int check = 0;
					int size = map[i][j].size();
					for (FireBall fire : map[i][j]) {
						check += fire.d % 2;
						avgM += fire.m;
						avgS += fire.s;
					}

					avgM /= 5;
					avgS /= size;
					map[i][j] = new ArrayList<FireBall>();
					if (avgM > 0) {
						if (check == 0 || check == size) {
							for (int D = 0; D < 8; D += 2) {
								map[i][j].add(new FireBall(i, j, avgM, avgS, D));
							}
						} else {
							for (int D = 1; D < 8; D += 2) {
								map[i][j].add(new FireBall(i, j, avgM, avgS, D));
							}
						}
					}
				}
			}
		}
		fires = new ArrayList<FireBall>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!map[i][j].isEmpty()) {
					for (FireBall fire : map[i][j])
						fires.add(fire);
				}
			}
		}
	}
	
	public static class FireBall {
		int r;
		int c;
		int m;
		int s;
		int d;

		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

}

