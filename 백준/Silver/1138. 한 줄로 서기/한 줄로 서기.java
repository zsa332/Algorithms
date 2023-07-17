import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++) {
			int tall = sc.nextInt();
			
			for(int j = 1; j <= N; j++) {
				if(tall == 0 && arr[j] == 0) {
					arr[j] = i;
					break;
				}
				else if(arr[j] == 0)tall--;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
