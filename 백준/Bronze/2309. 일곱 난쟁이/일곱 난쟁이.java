import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int[] answer = new int[7];
		int cnt = 0;
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}

		boolean isFind = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum - arr[i] - arr[j]) == 100) {
					for (int k = 0; k < arr.length; k++) {
						if (k != i && k != j) {
							answer[cnt] = arr[k];
							cnt++;
						}
					}
					isFind = true;
				}
				if(isFind)break;
			}
			if(isFind)break;
		}
		Arrays.sort(answer);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

}
