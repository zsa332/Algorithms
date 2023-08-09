import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) == Math.abs(o2))return o1 - o2;
			return Math.abs(o1) - Math.abs(o2);
		});

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) {
				pQueue.add(num);
			} else if (num == 0) {
				if (pQueue.isEmpty())
					sb.append("0\n");
				else
					sb.append(pQueue.poll() + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}