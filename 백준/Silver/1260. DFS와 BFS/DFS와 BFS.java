import java.util.*;

public class Main {

    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;

    public void dfs(int current){
        System.out.print(current+" ");

        int size = graph.get(current).size();
        for(int i = 0; i < size; i++){
            int next = graph.get(current).get(i);
            if(!visited[next]){
                visited[next] = true;
                dfs(next);
            }
        }

    }

    public void bfs(int current){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(current);
        while(!queue.isEmpty()){
            int temp = queue.peek();
            int size = graph.get(temp).size();
            for(int i = 0; i < size; i++){
                int next = graph.get(temp).get(i);
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(graph.get(temp).get(i));
                }
            }
            queue.remove();
            System.out.print(temp+" ");
        }
    }

    public static void main(String[] args) {
        Main sol = new Main();
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int node_line = sc.nextInt();
        int start_node = sc.nextInt();



        for(int i = 0; i <= node; i++){
            sol.graph.add(new ArrayList<>());
        }
        for(int i = 0; i < node_line; i++){
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            sol.graph.get(node1).add(node2);
            sol.graph.get(node2).add(node1);
        }
        for(int i = 0; i <= node; i++){
            Collections.sort(sol.graph.get(i));
        }

        sol.visited = new boolean[node+1];
        sol.visited[start_node] = true;

        sol.dfs(start_node);
        System.out.println();

        sol.visited = new boolean[node+1];
        sol.visited[start_node] = true;
        sol.bfs(start_node);
    }
}
