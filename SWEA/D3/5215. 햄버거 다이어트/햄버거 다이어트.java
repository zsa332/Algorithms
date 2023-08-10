import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	static int N, totalCal, answer;
	static int[] taste, cal;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			totalCal = Integer.parseInt(st.nextToken());
			
			taste = new int[N];
			cal = new int[N];
			for(int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				taste[i] = Integer.parseInt(st.nextToken());
				cal[i] = Integer.parseInt(st.nextToken());
			}
			
			answer = 0;
			dfs(0, 0, 0);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void dfs(int cnt, int c, int t) {
		if(c > totalCal)return;
		
		if(c <= totalCal)answer = Math.max(answer, t);
		
		if(cnt == N)return;
		
		dfs(cnt+1, c + cal[cnt], t + taste[cnt]);
		dfs(cnt+1, c, t);
		
	}
}