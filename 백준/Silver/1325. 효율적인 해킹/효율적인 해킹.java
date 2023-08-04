import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
/*
 * N 개의 컴퓨터
 * M 개의 신뢰관계
 * 단방향 신뢰
 * */
public class Main{
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int M = Integer.parseInt(st.nextToken());
    	
    	ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    	for(int i = 0; i <= N; i++) {
    		graph.add(new ArrayList<>());
    	}
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		graph.get(b).add(a);
    	}
    	
    	int[] depths = new int[N+1];
    	Queue<Integer> queue;
    	boolean[] visited;
    	int max = 0;
    	for(int i = 1; i <= N; i++) {
    		queue = new LinkedList<>();
    		visited = new boolean[N+1];
    		queue.add(i);
    		visited[i] = true;
    		while(!queue.isEmpty()) {
    			int num = queue.poll();
    			
    			for(int j : graph.get(num)) {
    				if(!visited[j]) {
    					visited[j] = true;
    					queue.add(j);
    					depths[i]++;
    				}
    			}
    			
    		}
    		max = Math.max(depths[i], max);
    	}
    	StringBuilder sb = new StringBuilder();
    	for(int i = 1; i <= N; i++) {
    		if(max == depths[i]) sb.append(i).append(" ");
    	}
    	
    	System.out.println(sb.toString());
    }
}