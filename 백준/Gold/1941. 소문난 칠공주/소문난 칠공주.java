import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static char[][] map;
    static int[] c;
    static int answer;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[5][5];
        for(int i = 0; i < 5; i++){
            String line = br.readLine();
            for(int j = 0; j < 5; j++){
                map[i][j] = line.charAt(j);
            }
        }

        c = new int[7];
        combination(0, 0, 0);
        System.out.println(answer);
    }

    private static void combination(int start, int cnt, int yNum) {

        if(yNum > 3){
            return;
        }

        if(cnt == 7){
            if(isLinked())answer++;
            return;
        }

        for(int i = start; i < 25; i++){
            c[cnt] = i;
            combination(i + 1, cnt + 1, map[i/5][i%5] == 'Y' ? yNum + 1 : yNum);
        }
    }

    private static boolean isLinked() {
        boolean[][] visited = new boolean[5][5];
        for(int i = 0; i < 7; i++){
            int x = c[i] / 5;
            int y = c[i] % 5;
            visited[x][y] = true;
        }

        Queue<Point> queue = new ArrayDeque<>();
        queue.offer(new Point(c[0] / 5, c[0] % 5));
        visited[c[0]/5][c[0]%5] = false;
        int cnt = 1;
        while(!queue.isEmpty()){
            Point cur = queue.poll();


            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5 || !visited[nx][ny])continue;
                queue.offer(new Point(nx, ny));
                visited[nx][ny] = false;
                cnt++;
            }
        }

        if(cnt == 7)return true;
        else return false;
    }
}