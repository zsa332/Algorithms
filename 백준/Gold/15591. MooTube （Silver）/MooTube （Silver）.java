import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<int[]>[] graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            graph[p].add(new int[] {q, r});
            graph[q].add(new int[] {p, r});
        }

        int[] weights = new int[N+1];
        boolean[] visited;
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weights = new int[N+1];
            visited = new boolean[N+1];
            queue.add(new int[] {v, Integer.MAX_VALUE});
            weights[v] = 0;
            visited[v] = true;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();

                for(int[] next : graph[cur[0]]){
                    if(!visited[next[0]]){
                        visited[next[0]] = true;
                        weights[next[0]] = Math.min(cur[1], next[1]);
                        queue.add(new int[] {next[0], Math.min(cur[1], next[1])});
                    }
                }
            }

            int answer = 0;
            for(int j = 1; j <= N; j++){
                if(weights[j] >= k) answer++;
            }
            System.out.println(answer);

        }
    }
}
