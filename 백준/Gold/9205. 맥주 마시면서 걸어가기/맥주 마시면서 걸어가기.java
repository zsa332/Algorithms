import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static Point[] stores;
	static Point start, end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		Queue<Point> queue;
		boolean[] visited;
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			stores = new Point[N];
			st = new StringTokenizer(br.readLine());
			start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				stores[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			visited = new boolean[N];
			queue = new ArrayDeque<Point>();
			queue.offer(start);
			boolean isPossible = false;
			while(!queue.isEmpty()) {
				Point cur = queue.poll();
				
				int lastDis = Math.abs(cur.x - end.x) + Math.abs(cur.y - end.y);
				if(lastDis <= 1000) {
					isPossible = true;
					break;
				}
				
				for(int i = 0; i < N; i++) {
					int dis = Math.abs(cur.x - stores[i].x) + Math.abs(cur.y - stores[i].y);
					if(dis <= 1000 && !visited[i]) {
						visited[i] = true;
						queue.offer(stores[i]);
					}
				}
			}
			
			if(isPossible)System.out.println("happy");
			else System.out.println("sad");
		}
	}
}