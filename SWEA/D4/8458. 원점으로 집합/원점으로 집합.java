import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			
			arr = new int[N];
			boolean isOdd = false;
			boolean isEven = false;
			int max = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[i] = Math.abs(x) + Math.abs(y);
				if(arr[i] % 2 == 0)isEven = true;
				else isOdd = true;
				
				max = Math.max(max, arr[i]);
			}
			
			int answer = 0;
			if(isOdd != isEven) {
				int sum = 0;
				int i = 0;
				while(true) {
					sum += i;
					if(sum >= max && Math.abs(sum - max) % 2 == 0) {
						break;
					}
					i++;
				}
				answer = i;
			} else {
				answer = -1;
			}
			System.out.println("#" + tc + " " + answer);
		} 
	}
}