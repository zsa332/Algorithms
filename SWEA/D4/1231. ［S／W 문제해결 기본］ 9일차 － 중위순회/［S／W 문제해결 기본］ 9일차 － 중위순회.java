import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static char[] arr;
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());

            arr = new char[N+1];
            for(int i = 1; i <= N; i++){
                arr[i] = br.readLine().split(" ")[1].charAt(0);
            }
            sb.append("#" + tc + " ");
            dfs(1);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int cur) {
        if(cur > N)return;
        dfs(cur * 2);
        sb.append(arr[cur]);
        dfs(cur*2+1);
    }

}
