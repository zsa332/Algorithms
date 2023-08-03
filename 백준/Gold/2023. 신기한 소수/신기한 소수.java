import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		recursive(0, N);
	}
	
	public static void recursive(int num, int cnt) {
		if(cnt == 0) {
			System.out.println(num);
			return;
		}
		for(int i = 1; i < 10; i++) {
			int tmp = num * 10 + i;
			if(primeCheck(tmp)) {
				recursive(tmp, cnt-1);
			}
		}
	}
	
	public static boolean primeCheck(int num) {
		if(num < 2)return false;
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0)return false;
		}
		return true;
	}
}
