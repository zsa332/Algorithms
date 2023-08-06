import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[42];
        int answer = 0;
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(arr[num % 42] == 0) {
                answer++;
                arr[num % 42]++;
            }
        }

        System.out.println(answer);
    }
}