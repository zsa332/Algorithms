import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int right = 0;
        arr = new int[M];
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
        }

        int left = 1, answer = 0;
        while(left <= right){
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i = 0; i < M; i++){
                sum += arr[i] / mid;
                if(arr[i] % mid != 0)sum++;
            }

            if(sum > N)left = mid + 1;
            else {
                right = mid - 1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}