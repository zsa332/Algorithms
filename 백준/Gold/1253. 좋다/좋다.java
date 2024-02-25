import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);
        int answer = 0;
        for(int i = 0; i < N; i++){
            if(isLike(0, N - 1, i)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static boolean isLike(int left, int right, int target) {
        while(left < right){
            if(right >= N || right == target){
                right--;
                continue;
            }
            if(left == target){
                left++;
                continue;
            }

            long sum = arr[left] + arr[right];

            if(sum == arr[target]){
                return true;
            }

            if(sum > arr[target])right--;
            else left++;
        }

        return false;
    }
}
