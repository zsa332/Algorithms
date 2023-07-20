import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static ArrayList<Integer> primeNums;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		isPrime = new boolean[2000001];
		primeNums = new ArrayList<>();
		eratosthenes();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			
			long sum = a+b;
			if(sum < 4)System.out.println("NO");
			else if(sum % 2 == 0)System.out.println("YES");
			else {
				if(primeCheck((sum)-2))System.out.println("NO");
				else System.out.println("YES");
			}
		}
	}
	
	public static boolean primeCheck(long num) {
		if(num <= 2000000)return isPrime[(int)num];
		for(int i = 0; i < primeNums.size(); i++) {
			if(num % primeNums.get(i) == 0)return true;
		}
		return false;
	}
	
	public static void eratosthenes() {
		isPrime[0] = true;
		isPrime[1] = true;
		for(int i = 2; i <= 2000000; i++) {
			if(!isPrime[i]) {
				primeNums.add(i);
				for(int j = i * 2; j <= 2000000; j += i) {
					isPrime[j] = true;
				}
			}
		}
	}
}