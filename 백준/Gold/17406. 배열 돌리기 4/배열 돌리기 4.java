import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] r,c,s, command;
    static int N, M, K, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        r = new int[K];
        c = new int[K];
        s = new int[K];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            r[i] = Integer.parseInt(st.nextToken())-1;
            c[i] = Integer.parseInt(st.nextToken())-1;
            s[i] = Integer.parseInt(st.nextToken());
        }

        command = new int[K];
        answer = Integer.MAX_VALUE;
        for(int i = 0; i < K; i++){
            permutation(0, 0);
        }
        System.out.println(answer);
    }

    private static void permutation(int cnt, int flag) {
        if(cnt == K){
            int[][] sub = copyMap();
            for(int i = 0; i < K; i++){
                rotate(sub, r[command[i]], c[command[i]], s[command[i]]);
            }
            int minNum = getMinRowSum(sub);
            answer = Math.min(answer, minNum);
        }
        for(int i = 0; i < K; i++){
            if((flag & 1<<i) != 0) continue;
            command[cnt] = i;
            permutation(cnt + 1,flag | 1 << i);
        }
    }

    private static int getMinRowSum(int[][] sub) {
        int min = Integer.MAX_VALUE;
        for(int[] a : sub){
            int num = 0;
            for(int b : a){
                num += b;
            }
            min = Math.min(min, num);
        }
        return min;
    }

    private static int[][] copyMap() {
        int[][] sub = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sub[i][j] = map[i][j];
            }
        }
        return sub;
    }


    private static void rotate(int[][] sub, int r, int c, int s){
        for(int d = 1; d <= s; d++){
            int temp = sub[r-d][c+d];
            for(int j = c+d; j > c-d; j--){
                sub[r-d][j] = sub[r-d][j-1];
            }
            for(int j = r-d; j < r+d; j++){
                sub[j][c-d] = sub[j+1][c-d];
            }
            for(int j = c-d; j < c+d; j++){
                sub[r+d][j] = sub[r+d][j+1];
            }
            for(int j = r+d; j > r-d; j--){
                sub[j][c+d] = sub[j-1][c+d];
            }
            sub[r-d+1][c+d] = temp;
        }
    }
}
