import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D, ans;
	static List<Point>achers, enemys, sEnemys;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		// 적 배치
		enemys = new ArrayList<Point>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					enemys.add(new Point(i, j));
				}
			}
		}
		
		enemys.sort((o1, o2)-> {
			if(o1.x == o2.x)return o1.y - o2.y;
			return o2.x - o1.x;
		});
		
		int[] acher = new int[M];
		for(int i = M-3; i < M; i++) {
			acher[i] = 1;
		}
		
		achers = new ArrayList<Point>();
		do {
			enemyCopy();
			// 아군 배치
			achers = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				if(acher[i] == 1) {
					achers.add(new Point(N, i));
				}
			}
			// 시뮬레이션
			simulation();
			if(ans == enemys.size())break;
		}while(np(acher));
		
		System.out.println(ans);
	}
	
	private static void enemyCopy() {
		sEnemys = new ArrayList<Point>();
		for(int i = 0; i < enemys.size(); i++) {
			sEnemys.add(new Point(enemys.get(i).x, enemys.get(i).y));
		}
	}
	
	private static void simulation() {
		int kill = 0;
		while(!sEnemys.isEmpty()) {
			kill += attack();
			moveEnemy();
		}
		ans = Math.max(ans, kill);
	}
	
	private static void moveEnemy() {
		for(int i = 0; i < sEnemys.size(); i++) {
			sEnemys.get(i).x++;
			if(sEnemys.get(i).x == N) {
				sEnemys.remove(i--);
			}
		}
	}
	
	private static int attack() {
		int kill = 0;
		boolean[] isDeth = new boolean[sEnemys.size()];
		for(int j = 0; j < achers.size(); j++) {
			int idx = 0;
			boolean check = false;
			int disMin = Integer.MAX_VALUE;
			for(int i = 0; i < sEnemys.size(); i++) {
				int dis = Math.abs(achers.get(j).x - sEnemys.get(i).x) + Math.abs(achers.get(j).y - sEnemys.get(i).y);
				if(dis <= D && dis < disMin) {
					idx = i;
					disMin = dis;
					check = true;
				}
				else if(dis == disMin) {
					idx = sEnemys.get(idx).y < sEnemys.get(i).y ? idx : i; 
				}
			}
			if(check)isDeth[idx] = true;
		}
		
		for(int i = sEnemys.size()-1; i >= 0; i--) {
			if(isDeth[i]) {
				sEnemys.remove(i);
				kill++;
			}
		}
		return kill;
	}
	private static boolean np(int[] p) {
		int size = p.length;
		int i = size - 1;
		while(i > 0 && p[i - 1] >= p[i])--i;
		
		if(i == 0)return false;
		
		int j = size - 1;
		while(p[i-1] >= p[j]) --j;
		
		swap(p, i-1, j);
		
		int k = size - 1;
		while(i < k) {
			swap(p, i++, k--);
		}
		return true;
	}
	
	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
