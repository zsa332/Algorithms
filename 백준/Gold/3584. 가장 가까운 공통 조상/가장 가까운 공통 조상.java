import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] parents, depth;
    static List<Integer>[] tree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            tree = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++)
                tree[i] = new ArrayList<>();

            boolean[] isNotRoot = new boolean[N + 1];
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                tree[u].add(v);
                tree[v].add(u);
                isNotRoot[v] = true;
            }

            int root = 0;
            for(int i = 1; i <= N; i++) {
                if (!isNotRoot[i]){
                    root = i;
                    break;
                }
            }

            parents = new int[N + 1];
            depth = new int[N + 1];

            setDepth(root, 1);

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            System.out.println(lca(u, depth[u], v, depth[v]));
        }
    }

    private static int lca(int u, int uDep, int v, int vDep) {
        if(uDep > vDep){
            while(uDep != vDep){
                uDep--;
                u = parents[u];
            }
        } else if(uDep < vDep){
            while(uDep != vDep){
                vDep--;
                v = parents[v];
            }
        }

        while(u != v){
            u = parents[u];
            v = parents[v];
        }

        return u;
    }

    private static void setDepth(int root, int dep) {
        depth[root] = dep;
        for(int i = 0; i < tree[root].size(); i++){
            if(depth[tree[root].get(i)] != 0) continue;
            setDepth(tree[root].get(i), dep + 1);
            parents[tree[root].get(i)] = root;
        }
    }
}