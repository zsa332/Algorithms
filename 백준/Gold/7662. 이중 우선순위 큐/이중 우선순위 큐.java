import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> minQueue, maxQueue;
		Map<Integer, Integer> map;
		for(int tc = 0; tc < T; tc++) {
			minQueue = new PriorityQueue<>((o1, o2) -> {return Integer.compare(o1, o2);});
			maxQueue = new PriorityQueue<>((o1, o2) -> {return Integer.compare(o2, o1);});
			map = new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				char c = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
				if(c == 'I') {
					map.put(num, map.getOrDefault(num, 0) + 1);
					minQueue.add(num);
					maxQueue.add(num);
				}
				else if(c == 'D') {
					if(map.isEmpty())continue;
					if(num == 1) {
						while(!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0)maxQueue.poll();
						if(!maxQueue.isEmpty() && map.get(maxQueue.peek()) > 0) {
							int tmp = maxQueue.poll();
							map.put(tmp, map.get(tmp) - 1);
						}
					}
					else {
						while(!minQueue.isEmpty() && map.get(minQueue.peek()) == 0)minQueue.poll();
						if(!minQueue.isEmpty() && map.get(minQueue.peek()) > 0) {
							int tmp = minQueue.poll();
							map.put(tmp, map.get(tmp) - 1);
						}
					}
				}
				
			}
			
			while(!maxQueue.isEmpty() && map.get(maxQueue.peek()) == 0)maxQueue.poll();
			while(!minQueue.isEmpty() && map.get(minQueue.peek()) == 0)minQueue.poll();
			if(minQueue.isEmpty() || maxQueue.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				int max = maxQueue.poll();
				int min = minQueue.poll();
				System.out.println(max + " " + min);
			}
		}
	}
}
