import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, answer;
	static int[] p;
	static int[][] map, copyMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				answer = Math.max(answer, map[i][j]);
			}
		}
		
		p = new int[5];
		permutation(0);
		System.out.println(answer);
	}
	private static void permutation(int cnt) {
		if(cnt == 5) {
			copyMap = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					copyMap[i][j] = map[i][j];
				}
			}
			for(int i = 0; i < 5; i++) {
				move(p[i]);
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			p[cnt] = i;
			permutation(cnt + 1);
		}
	}
	private static void move(int dir) {
		if(dir == 0) {
			for(int i = 0; i < N; i++) {
				int prev = 0;
				while(prev < N && copyMap[i][prev] == 0)prev++;
				if(prev == N) continue;
				int next = prev + 1;
				while(next < N) {
					if(copyMap[i][prev] == copyMap[i][next]) {
						copyMap[i][prev] += copyMap[i][next];
						answer = Math.max(copyMap[i][prev], answer);
						copyMap[i][next] = 0;
						prev = next + 1;
						next = prev;
					}
					else if(copyMap[i][next] != 0 && copyMap[i][prev] != copyMap[i][next])
						prev = next;
					next++;
				}
			}
			for(int i = 0; i < N; i++) {
				int prev = 0;
				while(prev < N && copyMap[i][prev] != 0)prev++;
				if(prev == N) continue;
				int next = prev + 1;
				while(next < N) {
					if(copyMap[i][next] != 0) {
						copyMap[i][prev++] = copyMap[i][next];
						copyMap[i][next] = 0;
					}
					next++;
				}
			}
		}
		else if(dir == 1) {
			for(int i = 0; i < N; i++) {
				int prev = 0;
				while(prev < N && copyMap[prev][i] == 0)prev++;
				if(prev == N) continue;
				int next = prev + 1;
				while(next < N) {
					if(copyMap[prev][i] == copyMap[next][i]) {
						copyMap[prev][i] += copyMap[next][i];
						answer = Math.max(copyMap[prev][i], answer);
						copyMap[next][i] = 0;
						prev = next + 1;
						next = prev;
					}
					else if(copyMap[next][i] != 0 && copyMap[prev][i] != copyMap[next][i])
						prev = next;
					next++;
				}
			}
			for(int i = 0; i < N; i++) {
				int prev = 0;
				while(prev < N && copyMap[prev][i] != 0)prev++;
				if(prev == N) continue;
				int next = prev + 1;
				while(next < N) {
					if(copyMap[next][i] != 0) {
						copyMap[prev++][i] = copyMap[next][i];
						copyMap[next][i] = 0;
					}
					next++;
				}
			}
		}
		
		else if(dir == 2) {
			for(int i = 0; i < N; i++) {
				int prev = N - 1;
				while(prev >= 0 && copyMap[i][prev] == 0)prev--;
				if(prev < 0) continue;
				int next = prev - 1;
				while(next >= 0) {
					if(copyMap[i][prev] == copyMap[i][next]) {
						copyMap[i][prev] += copyMap[i][next];
						answer = Math.max(copyMap[i][prev], answer);
						copyMap[i][next] = 0;
						prev = next - 1;
						next = prev;
					}
					else if(copyMap[i][next] != 0 && copyMap[i][prev] != copyMap[i][next])
						prev = next;
					next--;
				}
			}
			for(int i = 0; i < N; i++) {
				int prev = N - 1;
				while(prev >= 0 && copyMap[i][prev] != 0)prev--;
				if(prev < 0) continue;
				int next = prev - 1;
				while(next >= 0) {
					if(copyMap[i][next] != 0) {
						copyMap[i][prev--] = copyMap[i][next];
						copyMap[i][next] = 0;
					}
					next--;
				}
			}
		}
		
		else if(dir == 3) {
			for(int i = 0; i < N; i++) {
				int prev = N - 1;
				while(prev >= 0 && copyMap[prev][i] == 0)prev--;
				if(prev < 0) continue;
				int next = prev - 1;
				while(next >= 0) {
					if(copyMap[prev][i] == copyMap[next][i]) {
						copyMap[prev][i] += copyMap[next][i];
						answer = Math.max(copyMap[prev][i], answer);
						copyMap[next][i] = 0;
						prev = next - 1;
						next = prev;
					}
					else if(copyMap[next][i] != 0 && copyMap[prev][i] != copyMap[next][i])
						prev = next;
					next--;
				}
			}
			for(int i = 0; i < N; i++) {
				int prev = N - 1;
				while(prev >= 0 && copyMap[prev][i] != 0)prev--;
				if(prev < 0) continue;
				int next = prev - 1;
				while(next >= 0) {
					if(copyMap[next][i] != 0) {
						copyMap[prev--][i] = copyMap[next][i];
						copyMap[next][i] = 0;
					}
					next--;
				}
			}
		}
	}

}