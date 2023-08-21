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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Structure[] structures = new Structure[N + 1];
		for (int i = 0; i <= N; i++) {
			structures[i] = new Structure(i, 0, 0);
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			structures[i].time = time;
			structures[i].totalTime = time;
			while (prev != -1) {
				structures[prev].next.add(structures[i]);
				structures[i].link++;
				prev = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Structure> queue = new ArrayDeque<>();
		for(Structure s : structures) {
			if(s.n != 0 && s.link == 0)queue.add(s);
		}

		while(!queue.isEmpty()) {
			Structure cur = queue.poll();
			
			for(Structure s : cur.next) {
				s.totalTime = Math.max(s.totalTime, cur.totalTime + s.time);
				s.link--;
				if(s.link == 0)queue.add(s);
			}
		}
		
		for(Structure s : structures) {
			if(s.n != 0)System.out.println(s.totalTime);
		}
		
	}
}

class Structure {
	int n;
	int time;
	int totalTime;
	int link;
	List<Structure> next;

	public Structure(int n, int time, int link) {
		this.n = n;
		this.time = time;
		this.link = link;
		this.next = new ArrayList<>();
	}	
}