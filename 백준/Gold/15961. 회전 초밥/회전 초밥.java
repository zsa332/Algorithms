import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int M = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int C = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] sushi = new int[N];
		for(int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int[] check = new int[3001];
		int coupone = 0;
		Queue<Integer> queue = new ArrayDeque<>();
		int kind = 0;
		for(int i = 0; i < K; i++) {
			if(check[sushi[i]] == 0)kind++;
			if(sushi[i] == C)coupone++;
			check[sushi[i]]++;
			queue.add(i);
		}

		int start = 0;
		int end = K-1;
		int answer = 0;
		while(start < N) {
			if(coupone > 0)
				answer = Math.max(answer, kind);
			else 
				answer = Math.max(answer, kind + 1);
			
			int prev = queue.poll();
			
			check[sushi[prev]]--;
			if(check[sushi[prev]] == 0)kind--;	
			if(sushi[prev] == C)coupone--;
			
			start++;
			end++;

			if(start == N)break;
			if(end == N)end %= N;
			
			queue.add(end);
			if(check[sushi[end]] == 0)kind++;
			if(sushi[end] == C)coupone++;
			
			check[sushi[end]]++;

		}		
		System.out.println(answer);
	}
}
