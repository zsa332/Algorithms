import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int N;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		str = "";
		dc(0, 0, N);
		
		System.out.println(str);
	}
	
	private static void dc(int r, int c, int size) {
		int sum = 0;
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				sum += map[i][j];
			}
		}
		if(sum == 0) {
			str+= "0";
		}
		else if(sum == size*size) {
			str += "1";
		}
		else {
			str += "(";
			int half = size / 2;
			dc(r, c, half);
			dc(r, c + half, half);
			dc(r + half, c, half);
			dc(r + half, c + half, half);
			str += ")";
		}
	}

}
