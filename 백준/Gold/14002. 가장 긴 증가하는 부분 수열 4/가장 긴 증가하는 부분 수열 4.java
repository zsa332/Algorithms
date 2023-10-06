import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N];
		int ans = 0;
		for(int i=0; i<N; i++) {
			dp[i] = 1;
			
	        for(int j=0; j<i; j++) {
	            if(A[i] > A[j]) {  
	                dp[i] = Math.max(dp[i], dp[j] + 1);
	            }
	        }
	        ans = Math.max(ans, dp[i]);
	    }
		
		int cnt = ans;
	    int[] ansArr = new int[ans];
	    for(int i = N - 1; i >= 0; i--) {
	    	if(dp[i] == cnt) {
	    		ansArr[--cnt] = A[i];
	    	}
	    }

	    System.out.println(ans);
	    for(int i : ansArr)System.out.print(i + " ");
	}
}