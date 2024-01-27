import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] arr;
    static int[][] map;

    static int N, M;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N+1];
        map = new int[N][M];

        for(int i=0; i<N; ++i){
            arr[i] = br.readLine();
            for(int j=0; j<M; ++j){
                map[i][j] = arr[i].charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; ++i){
            for(int j=0; j<M; ++j){
                slv(j, i);
            }
        }
        System.out.println(ans);
    }
    public static void slv(int c, int r){
        for(int i=-N; i<N; ++i){
            for(int j=-M; j<M; ++j){
                if(i == 0 && j == 0) continue;
                int x = c;
                int y = r;
                int sqr = 0;
                while (0<=x && x<M && 0<=y && y<N){
                    sqr *= 10;
                    sqr += map[y][x];
                    int root = (int)Math.sqrt(sqr);
                    if( Math.pow(root, 2) == sqr )
                        ans = Math.max(ans, sqr);
                    x += j;
                    y += i;
                }
            }
        }
    }
}