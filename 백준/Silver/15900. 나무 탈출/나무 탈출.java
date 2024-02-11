import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        if(ans % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    public static void dfs(int cur, int cnt) {
        visited[cur] = true;
        for (int next : tree[cur]) {
            if (!visited[next]) {
                dfs(next, cnt + 1);
            }
        }
        if (cur != 1 && tree[cur].size() == 1) {
            ans += cnt;
        }
    }
}