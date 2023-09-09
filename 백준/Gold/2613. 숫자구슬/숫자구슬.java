import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] beads;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        beads = new int[N];
        int left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            beads[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, beads[i]);
            right += beads[i];
        }
        int mid = 0, groupCnt = 0, answer = Integer.MAX_VALUE;
        while(left <= right){
            mid = (left + right) / 2;
            groupCnt = countGroup(mid);

            if(M < groupCnt) {
                left = mid + 1;
            } else {
                right = mid - 1;
                if(mid < answer){
                    answer = mid;
                }
            }
        }

        StringBuilder sb = new StringBuilder().append(answer).append("\n");
        int sum = 0, cnt = 0;
        for(int i = 0; i < N; i++){
            sum += beads[i];
            if(sum <= answer)cnt++;
            else if(sum > answer){
                sb.append(cnt).append(" ");
                cnt = 1;
                sum = beads[i];
                M--;
            }
            if(M == N - i)break;
        }
        for(int i = 0; i < M; i++){
            sb.append(cnt).append(" ");
            cnt = 1;
        }
        System.out.println(sb.toString());
    }

    private static int countGroup(int mid) {
        int sum = 0;
        int cnt = 0;
        for(int i = 0; i < N; i++){
            sum += beads[i];
            if(sum > mid){
                sum = beads[i];
                cnt++;
            }
        }
        if(sum > 0)cnt++;
        return cnt;
    }
}
