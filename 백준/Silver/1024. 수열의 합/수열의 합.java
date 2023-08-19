import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int L = sc.nextInt();

        int start = N / 2;
        int end = N / 2 + 1;
        int sum = start + end;
        while(start > 0){
            sum += --start;

            if(sum > N){
                sum -= end--;
            }
            if(sum == N){
                if(end - start >= L - 1){
                    break;
                }
            }
        }

        if(end - start == L && start == 0) start++;
        if(sum != N || end - start >= 100 || end - start < L - 1){
            sb.append(-1);
        } else {
            for (int i = start; i <= end; i++) {
                sb.append(i).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
