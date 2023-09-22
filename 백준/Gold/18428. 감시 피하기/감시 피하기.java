import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int N;
    static char[][] map;
    static List<Point> t;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        t = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = line[j].charAt(0);
                if(map[i][j] == 'T')t.add(new Point(i, j));
            }
        }

        if(dfs(0)) System.out.println("YES");
        else System.out.println("NO");

    }

    private static boolean dfs(int cnt) {
        if(cnt == 3){
            return isSee();
        }
        boolean check = false;
        loop : for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 'X'){
                    map[i][j] = 'O';
                    check = dfs(cnt + 1);
                    map[i][j] = 'X';
                }
                if(check)break loop;
            }
        }
        return check;
    }

    private static boolean isSee() {
        for(Point p : t){
            for(int i = 0; i < 4; i++){
                int x = p.x;
                int y = p.y;
                for(int j = 1; j < N; j++){
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;

                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'O' || map[nx][ny] == 'T')break;
                    if(map[nx][ny] == 'S')return false;
                }
            }
        }
        return true;
    }
}
