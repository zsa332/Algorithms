import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, M;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static Shark[][] map;
	static List<Shark> sharks;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		sharks = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1; // 행 좌표
			int c = Integer.parseInt(st.nextToken())-1; // 열 좌표
			int s = Integer.parseInt(st.nextToken()); // 속력
			int d = Integer.parseInt(st.nextToken())-1; // 방향
			int z = Integer.parseInt(st.nextToken()); // 크기
			sharks.add(new Shark(r, c, s, d, z));
			map[r][c] = sharks.get(i);
		}
		
		int answer = 0;
		for(int i = 0; i < C; i++) {
			answer += fishing(i);
			moveShark();
		}
		System.out.println(answer);
	}

	private static void moveShark() {
		map = new Shark[R][C];
		for(int i = 0; i < sharks.size(); i++) {
			Shark s = sharks.get(i);
			int dis = s.d == 0 || s.d == 1 ? s.s % ((R-1) * 2) : s.s % ((C-1) * 2);
			while(dis > 0) {
				if(s.r + dr[s.d] < 0)s.d = 1;
				if(s.r + dr[s.d] > R - 1)s.d = 0;
				if(s.c + dc[s.d] < 0)s.d = 2;
				if(s.c + dc[s.d] > C - 1)s.d = 3;
				
				s.r += dr[s.d];
				s.c += dc[s.d];

				dis--;
			}
			if(map[s.r][s.c] != null) {
				if(map[s.r][s.c].z > s.z)sharks.remove(i);
				else {
					sharks.remove(map[s.r][s.c]);
					map[s.r][s.c] = s;
				}
				i--;
			}
			else if(map[s.r][s.c] == null){
				map[s.r][s.c] = s;
			}
		}
	}

	private static int fishing(int c) {
		int size = 0;
		for(int i = 0; i < R; i++) {
			if(map[i][c] != null) {
				size = map[i][c].z;
				sharks.remove(map[i][c]);
				break;
			}
		}
		
		return size;
	}

	static class Shark{
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
