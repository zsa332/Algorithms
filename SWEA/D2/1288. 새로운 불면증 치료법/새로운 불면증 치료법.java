import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int N = Integer.parseInt(br.readLine());
            int check = 0;
            int all_checked = ( 1 << 10) - 1;
            for(int k = 1;; k++){
                int num = N * k;
                while(num > 0){
                    int digit = num %10;
                    check |= 1 <<digit;
                    num /= 10;
                }

                if(check == all_checked){
                    System.out.println("#" + tc + " " + k*N);
                    break;
                }
            }
        }
    }
}
