import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<int[]> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[100001];
		queue.add(new int[] { N, 0 });
		visited[N] = true;
		int answer = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == K) {
				answer = cur[1];
				break;
			}

			if (cur[0] * 2 <= 100000 && !visited[cur[0] * 2]) {
				visited[cur[0] * 2] = true;
				queue.add(new int[] { cur[0] * 2, cur[1] + 1 });
			}
			if (cur[0] + 1 <= K && !visited[cur[0]+1]) {
				visited[cur[0]+1] = true;
				queue.add(new int[] { cur[0] + 1, cur[1] + 1 });
			}
			if (cur[0] - 1 >= 0 && !visited[cur[0]-1]) {
				visited[cur[0]-1] = true;
				queue.add(new int[] { cur[0] - 1, cur[1] + 1 });
			}
		}
		System.out.println(answer);
		sc.close();
	}
}
