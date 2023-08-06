import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] roll = new int[L+1];

        int takeMax = 0;
        int takeIdx = 0;
        int wantMax = 0;
        int wantIdx = 0;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int want = K - P;
            int take = 0;
            for(int j = P; j <= K; j++){
                if(roll[j] == 0){
                    roll[j] = i;
                    take++;
                }
            }

            if(takeMax < take){
                takeMax = take;
                takeIdx = i;
            }
            if(wantMax < want){
                wantMax = want;
                wantIdx = i;
            }
        }

        System.out.println(wantIdx);
        System.out.println(takeIdx);

    }
}
