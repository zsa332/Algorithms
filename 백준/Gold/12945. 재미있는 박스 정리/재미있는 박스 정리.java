import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int inBox = 0;
		for(int i = N/2 - 1, j = N - 1; i >= 0; i--) {
			if(arr[i] * 2 <= arr[j]) {
				inBox++;
				j--;
			}
		}
		System.out.println(N - inBox);
	}
}
