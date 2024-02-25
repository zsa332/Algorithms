import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int minSum = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0, left = 0, right = N - 1;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(sum) < minSum){
                minSum = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if(sum > 0)
                right--;
            else
                left++;
        }
        System.out.println(ans1 + " " + ans2);
    }
}