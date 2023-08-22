import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for (int i = 1; i <= N; i++){
            parents[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int status = Integer.parseInt(st.nextToken());

                if(status == 1){
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int prev = 0;
        boolean check = true;
        for(int i = 1; i <= M; i++){
            int a = Integer.parseInt(st.nextToken());
            if(i == 1){
                prev = find(a);
            }
            if(prev != find(a)){
                check = false;
                break;
            }
        }
        if(check) System.out.println("YES");
        else System.out.println("NO");
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot)return;
        parents[bRoot] = aRoot;
    }

    private static int find(int a) {
        if(a == parents[a])return a;
        return parents[a] = find(parents[a]);
    }
}
