import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    int dp[][];
    ArrayList<Integer> tree[];
    boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main s = new Main();

        int n = sc.nextInt();
        s.tree = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            s.tree[i] = new ArrayList<>();
        }
        for(int i = 1; i < n; i++){
            int parent = sc.nextInt();
            int child = sc.nextInt();
            s.tree[parent].add(child);
            s.tree[child].add(parent);
        }
        s.visited = new boolean[n+1];
        s.dp = new int[n+1][2];
        s.dfs(1);

        int ans = Math.min(s.dp[1][0], s.dp[1][1]);
        System.out.println(ans);
    }

    public void dfs(int idx){
        visited[idx] = true;
        dp[idx][0] = 0;
        dp[idx][1] = 1;
        for(int i : tree[idx]){
            if(!visited[i]){
                dfs(i);
                dp[idx][0] += dp[i][1];
                dp[idx][1] += Math.min(dp[i][0], dp[i][1]);
            }
        }
    }
}
