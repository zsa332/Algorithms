import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] loc = new int[N][2];
		int totalDist = 0;	
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			loc[i][0] = x;
			loc[i][1] = y;
			if(i > 0)totalDist += Math.abs(loc[i][0] - loc[i - 1][0]) + Math.abs(loc[i][1] - loc[i - 1][1]);
		}
		
		
		int answer = totalDist;
		for(int i = 1; i < N - 1; i++) {
			int prevDist = Math.abs(loc[i][0] - loc[i - 1][0]) + Math.abs(loc[i][1] - loc[i - 1][1]);
			int nextDist = Math.abs(loc[i][0] - loc[i + 1][0]) + Math.abs(loc[i][1] - loc[i + 1][1]);
			int passDist = Math.abs(loc[i + 1][0] - loc[i - 1][0]) + Math.abs(loc[i + 1][1] - loc[i - 1][1]);
			
			answer = Math.min(answer, totalDist - prevDist - nextDist + passDist);
		}
		
		System.out.println(answer);
		
	}

}
