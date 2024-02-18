import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int right = 0, left = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right += arr[i];
            left = Math.max(left, arr[i]);
        }

        int mid = 0;
        while(left <= right){
            mid = (left + right) / 2;

            int sum = 0, check = 0;
            for(int i = 0; i < N; i++){
                sum += arr[i];
                if(sum > mid) {
                    sum = arr[i];
                    check++;
                }
            }
            if (sum != 0)check++;

            if(check > M)left = mid + 1;
            else right = mid - 1;
        }
        System.out.println(left);
    }

}