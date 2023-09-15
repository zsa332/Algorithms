import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean status = true;
        int cnt = 0;
        while(status) {
            visited = new boolean[N][N];
            int check = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        check++;
                        visited[i][j] = true;
                        status = makeGroup(i, j);
                    }
                }
            }
            if(check == N * N) break;

            cnt++;
        }

        System.out.println(cnt);
    }

    private static boolean makeGroup(int x, int y) {
        List<int[]> groups = new ArrayList<>();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});
        groups.add(new int[] {x, y});
        int sum = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            sum += map[cur[0]][cur[1]];
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                int num = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if(num >= L && num <= R){
                    visited[nx][ny] = true;
                    groups.add(new int[] {nx, ny});
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        if(groups.size() <= 1) return true;

        if(groups.size() == N * N) return false;

        sum /= groups.size();
        for(int[] cur : groups){
            map[cur[0]][cur[1]] = sum;
        }
        return true;
    }
}
