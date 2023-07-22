import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] swi = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			swi[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if(sex == 1) {
				for(int j = 1; j <= N; j++) {
					if(j % num == 0)swi[j] = swi[j] == 0 ? 1 : 0;
				}
			}
			else if(sex == 2) {
				swi[num] = swi[num] == 0 ? 1 : 0;
				for(int j = 1; j <= N/2; j++) {
					if(num-j >= 1 && num + j <= N && swi[num - j] == swi[num + j]) {
						swi[num-j] = swi[num-j] == 0 ? 1 : 0;
						swi[num+j] = swi[num+j] == 0 ? 1 : 0;
					}
					else break;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(swi[i]).append(" ");
			if(i % 20 == 0)sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}