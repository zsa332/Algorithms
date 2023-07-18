import java.util.Scanner;

public class Main {
	static int[] nums;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		nums = new int[10];
		
		int start = 1;
		int end = N;
		int cnt = 0;
		int k = 1;
		while(start <= end) {
			while(start < 10 && start <= end) {
				counting(start, k);
				start++;
			}
			while(end % 10 != 9 && start <= end) {
				counting(end, k);
				end--;
			}
			
			if(start > end)break;
			
			end /= 10;
			start /= 10;
			
			cnt = (end - start + 1) * k;
			
			for(int i = 0; i < nums.length; i++) {
				nums[i] += cnt;
			}
			k *= 10;
		}
		
		for(int num : nums)System.out.print(num + " ");
	}
	
	public static void counting(int num, int k) {
		while(num > 0) {
			nums[num % 10]+=k;
			num /= 10;
		}
	}
}