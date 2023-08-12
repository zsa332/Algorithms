import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        List<Integer> list;
        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            list = new LinkedList<>();
            for(int i = 1 ; i < N; i++){
                int s = Integer.parseInt(st.nextToken());
                list.add(s);
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                String c = st.nextToken();
                int x, y, s;
                switch (c){
                    case "I":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j < y; j++){
                            s = Integer.parseInt(st.nextToken());
                            list.add(x++, s);
                        }
                        break;
                    case "D":
                        x = Integer.parseInt(st.nextToken());
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j < y; j++){
                            list.remove(x);
                        }
                        break;
                    case "A":
                        y = Integer.parseInt(st.nextToken());
                        for(int j = 0; j < y; j++){
                            s = Integer.parseInt(st.nextToken());
                        }
                        break;
                }


            }

            sb.append("#").append(tc);
            for(int i = 0; i < 10; i++){
                sb.append(" ").append(list.get(i));
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
