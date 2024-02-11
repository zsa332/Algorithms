import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, R, Q;
    static int[] count;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        count = new int[N + 1];
        for(int i = 0; i <= N; i++)tree[i] = new ArrayList<>();

        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(R);

        for(int i = 0; i < Q; i++) {
            int q = Integer.parseInt(br.readLine());
            System.out.println(count[q]);
        }
    }

    private static void dfs(int root) {
        count[root] = 1;
        for(int next : tree[root]){
            if(count[next] != 0) continue;
            dfs(next);
            count[root] += count[next];
        }
    }
}