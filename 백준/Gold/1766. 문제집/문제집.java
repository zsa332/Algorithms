import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Quiz[] quizs = new Quiz[N + 1];
		for (int i = 0; i <= N; i++) {
			quizs[i] = new Quiz(i, 0);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			quizs[u].next.add(quizs[v]);
			quizs[v].link++;
		}

		Queue<Quiz> queue = new PriorityQueue<>((o1, o2) -> {
			return o1.n - o2.n;
		});
		
		for (Quiz q : quizs) {
			if (q.n != 0 && q.link == 0) {
				queue.add(q);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			Quiz q = queue.poll();

			sb.append(q.n).append(" ");

			for (Quiz n : q.next) {
				n.link--;
				if (n.link == 0) {
					queue.add(n);
				}
			}
		}

		System.out.println(sb.toString());
	}

}

class Quiz {
	int n;
	int link;
	List<Quiz> next;

	public Quiz(int n, int link) {
		this.n = n;
		this.link = link;
		this.next = new ArrayList<Quiz>();
	}
}
