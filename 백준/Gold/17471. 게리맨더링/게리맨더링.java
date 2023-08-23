import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] graph;
	static boolean[] isVisited, isSelected;
	static int[] pNums;
	static int N, answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		pNums = new int[N];
		graph = new ArrayList[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			pNums[i] = Integer.parseInt(st.nextToken());
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for(int j = 0; j < m; j++) {
				int a = Integer.parseInt(st.nextToken())-1;
				graph[i].add(a);
			}
		}
		
		answer = Integer.MAX_VALUE;
		isSelected = new boolean[N];
		subSet(0);
		if(answer == Integer.MAX_VALUE)answer = -1;
		System.out.println(answer);
	}
	private static void subSet(int cnt) {
		if(cnt == N) {
			Set<Boolean> set = new HashSet<>();
			for(boolean c : isSelected)set.add(c);
			if(set.size() > 1)checkArea();
			return;
		}
		
		isSelected[cnt] = true;
		subSet(cnt + 1);
		isSelected[cnt] = false;
		subSet(cnt + 1);
	}
	private static void checkArea() {
		Queue<Integer> queue = new ArrayDeque<>();
		int tStart = -1;
		int fStart = -1;
		for(int i = 0; i < N; i++) {
			if(isSelected[i] && tStart == -1) {
				tStart = i;
			}
			if(!isSelected[i] && fStart == -1) {
				fStart = i;
			}
			if(tStart > -1 && fStart > -1)break;
		}
		
		isVisited = new boolean[N];
		isVisited[tStart] = true;
		queue.add(tStart);
		isVisited[fStart] = true;
		queue.add(fStart);
		int a = 0;
		int b = 0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();

			if(isSelected[cur])a += pNums[cur];
			if(!isSelected[cur])b += pNums[cur];
			
			for(int i = 0; i < graph[cur].size(); i++) {
				int next = graph[cur].get(i);
				if(!isVisited[next] && isSelected[cur] == isSelected[next]) {
					isVisited[next] = true;
					queue.add(next);
				}
			}
		}
		
		Set<Boolean> set = new HashSet<>();
		for(boolean c : isVisited)set.add(c);
		if(set.size() == 1) {
			answer = Math.min(answer, Math.abs(a - b));
		}
	}

}
