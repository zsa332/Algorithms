import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String[] gears;
	static int[] gearPoint;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		gears = new String[4];
		gearPoint = new int[4];
		for(int i = 0; i < 4; i++) {
			gears[i] = br.readLine();
		}
		
		int K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			
			rotateGear(num, dir);
			
		}
		
		int answer = 0;
		int score = 1;
		for(int i = 0; i < 4; i++) {
			if(gears[i].charAt(gearPoint[i]) == '1') {
				answer += score;
			}
			score *= 2;
		}
		
		System.out.println(answer);
	}
	private static void rotateGear(int num, int dir) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {num, dir});
		visited = new boolean[4];
		visited[num] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			int gearLeft = gearPoint[cur[0]] - 2;
			if(gearLeft < 0)gearLeft = 8 + gearLeft;
			if(cur[0] - 1 >= 0 && !visited[cur[0] - 1]) {
				int prevGearRight = (gearPoint[cur[0] - 1] + 2) % 8;
				if(gears[cur[0]].charAt(gearLeft) != gears[cur[0]-1].charAt(prevGearRight)) {
					queue.add(new int[] {cur[0] - 1, cur[1] * -1});
					visited[cur[0] - 1] = true;
				}
			}
			
			int gearRight = (gearPoint[cur[0]] + 2) % 8;
			if(cur[0] + 1 < 4 && !visited[cur[0] + 1]) {
				int prevGearLeft = gearPoint[cur[0] + 1] - 2;
				if(prevGearLeft < 0)prevGearLeft = 8 + prevGearLeft;
				if(gears[cur[0]].charAt(gearRight) != gears[cur[0] + 1].charAt(prevGearLeft)) {
					queue.add(new int[] {cur[0] + 1, cur[1] * -1});
					visited[cur[0] + 1] = true;
				}
			}
			
			if(cur[1] == -1) {
				gearPoint[cur[0]] = gearPoint[cur[0]] + 1 > 7 ? 0 : gearPoint[cur[0]] + 1;
			}
			else if(cur[1] == 1) {
				gearPoint[cur[0]] = gearPoint[cur[0]] - 1 < 0 ? 7 : gearPoint[cur[0]] - 1;
			}
		}
	}
}
