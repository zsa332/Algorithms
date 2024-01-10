import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int INF = 1000001;
    static boolean[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        String line;
        int check;
        for(int i = 0; i < N; i++){
            line = br.readLine();
            for(int j = 0; j < M; j++){
                check = line.charAt(j) - '0';
                map[i][j] = check == 0;
            }
        }

        bfs();

    }

    private static void bfs() {
        Queue<Loc> queue = new ArrayDeque<>();
        queue.offer(new Loc(0, 0, false, 1));

        boolean[][][] visited = new boolean[2][N][M];

        int answer = INF;
        while(!queue.isEmpty()){
            Loc cur = queue.poll();

            if(cur.x == N - 1 && cur.y == M - 1){
                answer = cur.cnt;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;

                if(map[nx][ny]){
                    if(!cur.broken && !visited[0][nx][ny]) {
                        queue.offer(new Loc(nx, ny, false, cur.cnt + 1));
                        visited[0][nx][ny] = true;
                    } else if(cur.broken && !visited[1][nx][ny]){
                        queue.offer(new Loc(nx, ny, true, cur.cnt + 1));
                        visited[1][nx][ny] = true;
                    }
                }
                else if(!map[nx][ny] && !cur.broken){
                    queue.offer(new Loc(nx, ny, true, cur.cnt + 1));
                    visited[1][nx][ny] = true;
                }
            }
        }

        if(answer == INF) answer = -1;
        System.out.println(answer);
    }

    static class Loc{
        int x;
        int y;
        boolean broken;
        int cnt;

        public Loc(int x, int y, boolean broken, int cnt) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.cnt = cnt;
        }
    }
}