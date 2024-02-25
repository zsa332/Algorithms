import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] tree;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int u = Integer.parseInt(st.nextToken()) - 1;
            if (u < 0) u = 0;
            tree[u].add(i);
        }

        score = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            score[num] += w;
        }

        for (int i = 0; i < N; i++) {
            int w = score[i];
            for (int j = 0; j < tree[i].size(); j++) {
                int num = tree[i].get(j);
                score[num] += w;
            }
        }
        for (int i = 0; i < N; i++) System.out.print(score[i] + " ");
    }
}
