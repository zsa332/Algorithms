import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited = new boolean[400000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int zeroP = visited.length / 2;
        Queue<Structure> q = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = zeroP + Integer.parseInt(st.nextToken());
            visited[x] = true;
            q.offer(new Structure(x, 0));
        }

        int hNum = 0;
        long totalDis = 0;
        while(!q.isEmpty()){
            Structure s = q.poll();
            totalDis += s.dis;
            if(s.dis > 0){
                hNum++;
                if(hNum == K)break;
            }
            int nx = s.x + 1;
            if(nx <= 400000000 && !visited[nx]){
                visited[nx] = true;
                q.offer(new Structure(nx, s.dis + 1));
            }
            nx = s.x - 1;
            if(nx >= 0 && !visited[nx]){
                visited[nx] = true;
                q.offer(new Structure(nx, s.dis + 1));
            }

        }
        System.out.println(totalDis);
    }
}
class Structure{
    int x;
    int dis;

    public Structure(int x, int dis) {
        this.x = x;
        this.dis = dis;
    }
}