import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nums;
	static boolean[] visited;
	static int N;
	static int max;
	static int winNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		winNum = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		max = 0;
		visited = new boolean[N];
		recursive(0, 0);
		
		System.out.println(max);
	}
	
	public static void recursive(int sum, int num) {
		if(sum > winNum)return;
		if(num == 3) {
			max = Math.max(max, sum);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				recursive(sum+nums[i], num+1);
				visited[i] = false;
			}
		}
	}
}
