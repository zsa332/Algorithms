import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int[] buildTime;
	static int[] indegree;
	static int[] result;
	static int N, K, W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		for(int testNum = 0; testNum < testCase; testNum++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			graph = new ArrayList<>();
			buildTime = new int[N+1];
			indegree = new int[N+1];
			
			//	빌드 시간
			for(int i = 1; i <= N; i++) {
				buildTime[i] = sc.nextInt();
			}
			
			//	그래프
			for(int i = 0; i <= N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			
			for(int i = 0; i < K; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				//	위상정렬 이용 -> 단방향
				graph.get(X).add(Y);
				indegree[Y]++;
			}
			
			W = sc.nextInt();
			topologicalSort();
			
			System.out.println(result[W]);
		}
	}
	
	public static void topologicalSort() {
		Queue<Integer> queue = new LinkedList<>();
		result = new int[N+1];
		for(int i = 1; i <= N; i++) {
			result[i] = buildTime[i];
			if(indegree[i] == 0)queue.add(i);
		}
		
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i : graph.get(node)) {
				result[i] = Math.max(result[i], result[node] + buildTime[i]);
				indegree[i]--;
				
				if(indegree[i] == 0)queue.add(i);
			}
		}
	}

}
