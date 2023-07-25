import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[100][100];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			for(int j = x; j < x + 10; j++) {
				for(int k = y; k < y + 10; k++)map[j][k] = 1;
			}
		}
		
		int answer = 0;
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(map[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						
						if(nx >= 0 && nx < 100 && ny >= 0 && ny < 100 && map[nx][ny] == 0)answer++;
						if(nx < 0)answer++;
						if(ny < 0)answer++;
						if(nx >= 100)answer++;
						if(ny >= 100)answer++;
					}
				}
			}
		}
		System.out.println(answer);
	}

}