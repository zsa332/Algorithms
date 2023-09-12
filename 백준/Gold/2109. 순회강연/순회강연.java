import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
			if(o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
			return Integer.compare(o2[0], o1[0]);
		});
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int pay = Integer.parseInt(st.nextToken());
			int timeLimit = Integer.parseInt(st.nextToken());
			
			queue.add(new int[] {pay, timeLimit});
		}
		
		boolean[] scadule = new boolean[10001];
		int answer = 0;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int time = cur[1];
			while(time > 0) {
				if(!scadule[time]) {
					scadule[time] = true;
					break;
				}
				else time--;
			}
			if(time > 0)answer += cur[0];
		}
		System.out.println(answer);
	}
}
