import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long C;
    static int[] depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        depth = new int[N+2];

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(0);
        treeSet.add(N+1);

        depth[0] = -1;
        depth[N+1] = -1;

        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            depth[num] = Math.max(depth[treeSet.lower(num)], depth[treeSet.higher(num)]) + 1;
            treeSet.add(num);

            C += depth[num];
            sb.append(C + "\n");
        }

        System.out.println(sb);
    }
}