import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents, counts;
    static int N, R, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        parents = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            parents[i] = Integer.parseInt(st.nextToken());
        }

        R = Integer.parseInt(br.readLine());
        remove(R);

        counts = new int[N];
        for(int i = 0; i < N; i++){
            if(parents[i] == -1 || parents[i] == -2) continue;
            counts[parents[i]]++;
        }

        for(int i = 0; i < N; i++){
            if(parents[i] == -2)continue;
            if(counts[i] == 0) ans++;
        }

        System.out.println(ans);
    }

    private static void remove(int idx) {
        parents[idx] = -2;

        for(int i = 0; i < N; i++){
            if(parents[i] == idx)remove(i);
        }
    }
}