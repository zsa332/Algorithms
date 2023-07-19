import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] start = new int[N];
		int[] end = new int[N];
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			start[i] = Integer.parseInt(st.nextToken());
			end[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int cur = Integer.MIN_VALUE;
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(cur < start[i])cur = start[i];
			
			if(cur < end[i]) {
				answer += end[i] - cur;
				cur = end[i];
			}
		}
		
		System.out.println(answer);
	}
}
