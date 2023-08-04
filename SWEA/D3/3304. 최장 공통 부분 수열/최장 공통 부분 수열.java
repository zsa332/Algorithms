import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            int[][] dp = new int[A.length() + 1][B.length() + 1];

            // 1부터 시작 (index 0 은 공집합이므로 0의 값을 갖고있음)
            for(int i = 1; i <=A.length(); i++) {
                for(int j = 1; j <= B.length(); j++) {

                    // (i-1)과 (j-1) 번째 문자가 서로 같다면
                    if(A.charAt(i - 1) == B.charAt(j - 1)) {
                        // 대각선 위 (i-1, j-1)의 dp에 +1 한 값으로 갱신
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    // 같지 않다면 이전 열(i-1)과 이전 행(j-1)의 값 중 큰 것으로 갱신
                    else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
//            for(int i= 1; i <= A.length(); i++){
//                for(int j = 1; j <= B.length(); j++){
//                    System.out.print(dp[i][j]+" ");
//                }
//                System.out.println();
//            }
            System.out.println("#" + tc + " " + dp[A.length()][B.length()]);
        }
    }
}
