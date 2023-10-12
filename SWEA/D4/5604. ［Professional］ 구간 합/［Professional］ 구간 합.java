import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st =new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			
			long[] nums = new long[10];
			long cnt = 0;
			long k = 1;
			if(A == 0) A = 1;
			while(A <= B) {
				while(A % 10 != 0 && A <= B) {
					counting(A, k, nums);
					A++;
				}
				while(B % 10 != 9 && A <= B) {
					counting(B, k, nums);
					B--;
				}
				
				if(A > B)break;
				
				A /= 10;
				B /= 10;
				
				cnt = (B - A + 1) * k;
				for(int i = 0; i < nums.length; i++)nums[i] += cnt;
				
				k *= 10;
			}
			
			long sum = 0;
			for(int i = 0; i < nums.length; i++) {
				sum += nums[i] * i;
			}
			System.out.println("#" + tc + " " + sum);
		}
	}

	private static void counting(long num, long k, long[] nums) {
		while(num > 0) {
			nums[(int) (num % 10)] += k;
			num /= 10;
		}
	}
}
