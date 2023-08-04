import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		int[] arr = new int[11];
		int idx = 0;
		for(int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			int mush = Integer.parseInt(st.nextToken());
			arr[i] = arr[i-1] + mush;
			if(arr[i] <= 100)idx = i;
		}

		StringBuilder sb = new StringBuilder();
		if(idx < 10 && Math.abs(100 - arr[idx]) == Math.abs(100 - arr[idx+1]) ) {
			sb.append(arr[idx+1]);
		} else if(idx < 10 && Math.abs(100 - arr[idx]) > Math.abs(100 - arr[idx+1])) {
			sb.append(arr[idx+1]);
		}else sb.append(arr[idx]);
		
		System.out.println(sb.toString());
	}

}
