import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pw = br.readLine();

        int[] arr = new int[200];
        for(int i = 0; i < str.length(); i++){
            int index = str.charAt(i) - '!';
            if(arr[index] == 0 ) arr[index] = i + 1;
        }

        int sum = 0;
        for(int i = 0; i < pw.length(); i++){
            int index = pw.charAt(i) - '!';

            sum *= str.length();
            sum += arr[index];
            sum %= 900528;
        }
        System.out.println(sum);
    }
}
