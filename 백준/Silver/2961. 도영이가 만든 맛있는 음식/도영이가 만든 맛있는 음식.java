import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int min;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		min = Integer.MAX_VALUE;
		visited = new boolean[N];
		recursive(0);
		
		System.out.println(min);
	}
	
	public static void recursive(int depth) {
		if(depth == N) {
			int sour = 1;
			int bitter = 0;
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					sour *= arr[i][0];
					bitter += arr[i][1];
					cnt++;
				}
			}
			
			if(cnt == 0)return;
			min = Math.min(min, Math.abs(sour - bitter));
			return;
		}
		visited[depth] = true;
		recursive(depth+1);
		visited[depth] = false;
		recursive(depth+1);
	}
}
