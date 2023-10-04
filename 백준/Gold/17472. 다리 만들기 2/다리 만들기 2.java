import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] train;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)map[i][j] = -1;
            }
        }


        // 1. 영역 나누기
        int num = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == -1)areaMarking(i, j, num++);
            }
        }

        // 2. 영역별 다리 건설 (인접행렬 생성)
        train = new int[num][num];
        for(int i = 0; i < num; i++) {
            for(int j = 0; j < num; j++) {
                train[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != 0)buildTrain(i, j, map[i][j]);
            }
        }

        // 3. prim 이용하여 mst 찾기
        boolean[] visited = new boolean[num];
        int[] dist = new int[num];
        int result = 0, cnt = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        while(true) {
            int min = Integer.MAX_VALUE;
            int idx = 1;
            for(int i = 1; i < num; i++) {
                if(!visited[i] && dist[i] < min) {
                    idx = i;
                    min = dist[i];
                }
            }
            visited[idx] = true;
            if(min != Integer.MAX_VALUE)result += min;
            cnt++;

            if(cnt == num - 1)break;
            for(int i = 1; i < num; i++) {
                if(!visited[i] && train[idx][i] > 0 && dist[i] > train[idx][i]) {
                    dist[i] = train[idx][i];
                }
            }
        }

        for(int i = 1; i < num; i++){
            if(!visited[i]){
                result = -1;
            }
        }
        System.out.println(result);

    }
    private static void buildTrain(int x, int y, int start) {
        for(int i = 0; i < 4; i++) {
            int dis = 0;
            for(int j = 1; j <= 10; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == start)break;
                dis++;
                if(map[nx][ny] != 0) {
                    int end = map[nx][ny];
                    if(dis <= 2)break;
                    train[start][end] = Math.min(train[start][end], dis - 1);
                    train[end][start] = train[start][end];
                    break;
                }
            }
        }
    }
    private static void areaMarking(int x, int y, int num) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(x,y));

        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            map[cur.x][cur.y] = num;
            for(int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != -1)continue;
                queue.offer(new Point(nx, ny));
            }
        }
    }
}
