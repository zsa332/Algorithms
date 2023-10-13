import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long[] result = new long[3];
        for(int i = 0; i < N - 2; i++){
            int left = i + 1;
            int right = N - 1;
            while(left < right){
                long sum = arr[i] + arr[left] + arr[right];
                long res = Math.abs(sum);

                if(min > res){
                    min = res;
                    result[0] = arr[i];
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if(sum > 0){
                    right--;
                }
                else left++;
            }
        }
        Arrays.sort(result);
        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
