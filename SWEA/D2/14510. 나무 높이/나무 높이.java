import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] tree = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int max = 0;
			for(int i = 0; i < N; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				max = Math.max(max, tree[i]);
			}
			
			int answer = 0, odd = 0, even = 0;
			
			for(int i = 0; i < N; i++) {
				int num = max - tree[i];
				odd += num % 2;
				even += num / 2;
			}
			if(even > odd) {
				while(Math.abs(even - odd) > 1) {
					even--;
					odd += 2;
				}
			}
			
			if(odd > even) {
				answer = odd * 2 - 1;
			}
			else if(odd < even) {
				answer = even * 2;
			}
			else if(odd == even && odd != 0){
				answer = odd + even;
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
