import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[1001][1001];
		int maxX = 0;
		int maxY = 0;
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for(int j = x; j < x+width; j++) {
				for(int k = y; k < y+height; k++) {
					map[k][j] = i;
				}
			}
			maxX = Math.max(maxX, x+width);
			maxY = Math.max(maxY, y+height);
		}
		
		int[] arr = new int[N+1];
		for(int i = 0; i < maxX; i++) {
			for(int j = 0; j < maxY; j++) {
				arr[map[j][i]]++;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(arr[i]);
		}
	}

}