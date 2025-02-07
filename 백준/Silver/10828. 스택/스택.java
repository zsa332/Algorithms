import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            switch(commend){
                case "push" :
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(stack.empty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.empty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if(stack.empty()) System.out.println(-1);
                    else System.out.println(stack.peek());
            }
        }
    }
}