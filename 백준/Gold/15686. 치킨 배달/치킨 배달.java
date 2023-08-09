import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, answer;
	static List<Point> chikenList, houseList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chikenList = new ArrayList<Point>();
		houseList = new ArrayList<Point>();
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					houseList.add(new Point(i, j));
				else if (n == 2)
					chikenList.add(new Point(i, j));
			}
		}

		visited = new boolean[chikenList.size()];
		answer = Integer.MAX_VALUE;
		backtracking(0, 0);
		
		System.out.println(answer);
	}

	private static void backtracking(int start, int cnt) {
		if (cnt == M) {
			int[] dis = new int[houseList.size()];
			for(int i = 0; i < dis.length; i++) {
				dis[i] = Integer.MAX_VALUE;
			}
			for(int i = 0; i < chikenList.size(); i++) {
				if(visited[i]) {
					for(int j = 0; j < houseList.size(); j++) {
						int d = Math.abs(chikenList.get(i).x - houseList.get(j).x) + Math.abs(chikenList.get(i).y - houseList.get(j).y);
						dis[j] = Math.min(dis[j], d);
					}
				}
			}
			
			int totalDis = 0;
			for(int i = 0; i < dis.length; i++) {
				totalDis += dis[i];
			}
			answer = Math.min(answer, totalDis);
			return;
		}
		for (int i = start; i < chikenList.size(); i++) {
			visited[i] = true;
			backtracking(i + 1, cnt + 1);
			visited[i] = false;
		}
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}