import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		for(int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		
		dfs("", 0);
		
	}
	
	public static void dfs(String str, int num) {
		if(num == M) {
			System.out.println(str);
		}
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				String temp = arr[i] + " ";
				str += temp;
				dfs(str, num + 1);
				str = str.substring(0, str.length() - temp.length());
				visited[i] = false;
			}
		}
	}

}