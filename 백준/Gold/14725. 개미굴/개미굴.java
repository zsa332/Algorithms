import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Node root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        root = new Node();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Node subRoot = root;
            Node checkRoot = root;
            for(int j = 0; j < K; j++){
                String c = st.nextToken();
                if(subRoot.child.get(c) != null){
                    subRoot = subRoot.child.get(c);
                }
                else if(subRoot.child.get(c) == null){
                    subRoot.child.put(c, new Node());
                    subRoot = subRoot.child.get(c);
                }
            }
        }
        dfs(root, "");
    }

    private static void dfs(Node subRoot, String dash) {
        List<String> child = new ArrayList<>(subRoot.child.keySet());
        Collections.sort(child);
        for(String key : child){
            System.out.print(dash);
            System.out.println(key);
            dfs(subRoot.child.get(key), dash+"--");
        }
    }

    private static Node findSubRoot(Node subRoot, String c) {
        if(subRoot.child.get(c) == null)return subRoot;
        else return findSubRoot(subRoot.child.get(c), c);
    }

    static class Node{
        Map<String, Node> child = new HashMap<>();
    }
}