import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static Ball redBallP, blueBallP;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static class Ball{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Ball(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'R')redBallP = new Ball(i, j, 0, 0, 0);
                else if(map[i][j] == 'B')blueBallP = new Ball(0, 0, i, j, 0);
            }
        }
        bfs();
    }

    private static void bfs() {
        Queue<Ball> queue = new ArrayDeque<>();
        queue.offer(new Ball(redBallP.rx, redBallP.ry, blueBallP.bx, blueBallP.by, 0));

        map[redBallP.rx][redBallP.ry] = '.';
        map[blueBallP.rx][blueBallP.ry] = '.';

        visited = new boolean[N][M][N][M];
        visited[redBallP.rx][redBallP.ry][blueBallP.rx][blueBallP.ry] = true;

        int answer = 0;
        loop : while(!queue.isEmpty()){
            Ball ball = queue.poll();

            if(ball.cnt >= 10){
                answer = -1;
                break;
            }

            for(int i = 0; i < 4; i++){
                int nrx = ball.rx;
                int nry = ball.ry;
                boolean isRedGoal = false;
                while(map[nrx + dx[i]][nry + dy[i]] != '#'){
                    nrx += dx[i];
                    nry += dy[i];
                    if (map[nrx][nry] == 'O') {
                        isRedGoal = true;
                        break;
                    }
                }

                int nbx = ball.bx;
                int nby = ball.by;
                boolean isBlueGoal = false;
                while(map[nbx + dx[i]][nby + dy[i]] != '#'){
                    nbx += dx[i];
                    nby += dy[i];
                    if (map[nbx][nby] == 'O') {
                        isBlueGoal = true;
                        break;
                    }
                }

                if(isBlueGoal)continue;
                else if(isRedGoal){
                    answer = ball.cnt + 1;
                    break loop;
                }

                if(nrx == nbx && nry == nby){
                    if(i == 0){
                        if(ball.ry > ball.by) nry -= dy[i];
                        else nby -= dy[i];
                    }
                    else if(i == 1){
                        if(ball.ry > ball.by) nby -= dy[i];
                        else nry -= dy[i];
                    }
                    else if(i == 2){
                        if(ball.rx > ball.bx) nrx -= dx[i];
                        else nbx -= dx[i];
                    }
                    else {
                        if(ball.rx > ball.bx) nbx -= dx[i];
                        else nrx -= dx[i];
                    }
                }

                if(visited[nrx][nry][nbx][nby])continue;
                visited[nrx][nry][nbx][nby] = true;
                queue.offer(new Ball(nrx, nry, nbx, nby, ball.cnt + 1));
            }
        }

        if(answer == 0) answer= -1;
        System.out.println(answer);
    }
}
