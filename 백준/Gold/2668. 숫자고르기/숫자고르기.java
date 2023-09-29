import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int last;
    static ArrayList<Integer> list;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            visited[i] = true;    //무한 재귀에 빠지면 안되므로 첫 시작점도 방문으로 체크
            last = i;
            dfs(i);
            visited[i] = false; //다음 숫자 DFS를 해야하므로 초기화
        }
        Collections.sort(list);    // 작은수 부터 출력해야하므로 정렬
        System.out.println(list.size());
        for (int i : list) {
            System.out.println(i);
        }
    }

    public static void dfs(int i) {

        if (!visited[arr[i]]) {     //방문하지 않은 경우
            visited[arr[i]] = true;     // 방문했으므로 true
            dfs(arr[i]);
            visited[arr[i]] = false; // 다음 DFS들을 위하여 false
        }
        if (arr[i] == last) {    //마지막 점이 출발점과 같다면 사이클이 완성됐으므로 리스트에 추가
            list.add(last);
        }
    }
}
