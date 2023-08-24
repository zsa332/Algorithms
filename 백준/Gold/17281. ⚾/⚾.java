import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int p[], innings[][];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		innings = new int[N][9];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++)innings[i][j] = Integer.parseInt(st.nextToken());
		}
		
		p = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
		int answer = 0;
		do {
//			System.out.println(Arrays.toString(p));
			answer = Math.max(answer, play());
		} while(np(p));
		
		System.out.println(answer);
	}

	private static int play() {
		boolean[] base;
		int score = 0;
		int idx = 0;
		for(int i = 0; i < N; i++) {
			base = new boolean[3];
			
			int out = 0;
			int hitter = 0;
			while(out < 3) {
				if(idx == 9)idx %= 9;
				if(idx == 3) {
					hitter = p[0];
					idx++;
				}
				else if(idx == 0) {
					hitter = p[3];
					idx++;
				}else {
					hitter = p[idx++];
				}
				
				if(innings[i][hitter] == 0)out++;
				else {
					int hit = innings[i][hitter];
					if(hit == 1){
						if (base[2]) {
							score++;
							base[2] = false;
						}
						for(int j = 1; j >= 0; j--) {
							if(base[j]) {
								base[j] = false;
								base[j + 1] = true;
							}
						}
						base[0] = true;
					}
					if(hit == 2){
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						if (base[0]) {
							base[0] = false;
							base[2] = true;
						}
						base[1] = true;
					}
					if(hit == 3){
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						if (base[0]) {
							score++;
							base[0] = false;
						}
						base[2] = true;
					}
					if(hit == 4){
						for(int j = 0; j < 3; j++) {
							if(base[j]) {
								score++;
								base[j] = false;
							}
						}
						score++;
					}
				}
			}	
		}
		
		return score;
	}

	private static boolean np(int[] p) {
		int L = p.length;
		int i = L - 1;
		while(i > 1 && p[i-1] >= p[i])--i;
		if(i == 1) return false;
		
		int j = L-1;
		while(p[i-1] >= p[j])--j;
		
		swap(p, i-1, j);
		
		int k = L - 1;
		while(i < k)swap(p, i++, k--);
		return true;
	}

	private static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}

}
