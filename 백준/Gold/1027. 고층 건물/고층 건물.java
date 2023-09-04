import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st =  new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			int cnt = 0;
			double tmp = 0.0;
			// 왼쪽
			for(int j = i - 1; j >= 0; j--) {
				double slope = (double)(arr[i] - arr[j]) / (i - j);
				
				if(i - 1 == j || slope < tmp) {
					cnt++;
					tmp = slope;
				}
			}
			// 오른쪽
			for(int j = i + 1; j < N; j++) {
				double slope = (double)(arr[i] - arr[j]) / (i - j);
				if(i + 1 == j || slope > tmp) {
					cnt++;
					tmp = slope;
				}
			}
			ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
