import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Node[] nodes = new Node[N + 1];
		for(int i = 0; i <= N; i++) {
			nodes[i] = new Node(i, 0);
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			nodes[u].next.add(nodes[v]);
			nodes[v].link++;
		}
		
		Queue<Node> queue = new ArrayDeque<>();
		for(Node n : nodes) {
			if(n.n != 0 && n.link == 0) {
				queue.add(n);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			
			sb.append(cur.n).append(" ");
			
			for(Node n : cur.next) {
				n.link--;
				if(n.link == 0) {
					queue.add(n);
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}

class Node{
	int n;
	int link;
	List<Node> next;
	public Node(int n, int link) {
		this.n = n;
		this.link = link;
		next = new ArrayList<Node>();
	}
}