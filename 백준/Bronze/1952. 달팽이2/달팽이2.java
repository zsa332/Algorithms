import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int answer = 0;
        boolean turn = false;
        while(M > 0 && N > 0){
            if(M > 1){
                answer ++;
                turn = true;
            }
            M--;

            if(N > 1 && turn){
                answer++;
                turn = false;
            }
            N--;
        }
        System.out.println(answer);
    }
}