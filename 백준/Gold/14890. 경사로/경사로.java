import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer= 0;
        boolean[] visited;
        for(int i = 0; i < N; i++){
            int prev = map[i][0];
            visited = new boolean[N];
            boolean isRoad = true;
            for(int j = 0; j < N; j++){
                if(prev == map[i][j]){
                    prev = map[i][j];
                    continue;
                }
                else if(Math.abs(prev - map[i][j]) != 1){
                    isRoad = false;
                    break;
                }
                else if(prev > map[i][j]){
                    for(int k = j; k < j + L; k++){
                        if(k >= N || visited[k] || map[i][j] != map[i][k]){
                            isRoad=false;
                            break;
                        }
                        visited[k] = true;
                    }
                }
                else if (prev < map[i][j]){
                    for(int k = j - 1; k >= j - L; k--){

                        if(k < 0 || visited[k] || prev != map[i][k]){
                            isRoad=false;
                            break;
                        }
                        visited[k] = true;
                    }
                }
                prev = map[i][j];
            }

            if(isRoad) answer++;

            prev = map[0][i];
            visited = new boolean[N];
            isRoad = true;
            for(int j = 0; j < N; j++){
                if(prev == map[j][i]){
                    prev = map[j][i];
                    continue;
                }
                else if(Math.abs(prev - map[j][i]) != 1){
                    isRoad = false;
                    break;
                }
                else if(prev > map[j][i]){
                    for(int k = j; k < j + L; k++){
                        if(k >= N || visited[k] || map[j][i] != map[k][i]){
                            isRoad=false;
                            break;
                        }
                        visited[k] = true;
                    }
                }
                else if (prev < map[j][i]){
                    for(int k = j - 1; k >= j - L; k--){
                        if(k < 0 || visited[k] || prev != map[k][i]){
                            isRoad=false;
                            break;
                        }
                        visited[k] = true;
                    }
                }

                prev = map[j][i];
            }

            if(isRoad) answer++;

        }
        System.out.println(answer);
    }
}
