import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		boolean check = false;
		while(queue.size() > 1) {
			int cur = queue.poll();
			if(check) {
				queue.add(cur);
				check = false;
			}else {
				check = true;
			}
		}
		
		int answer = queue.poll();
		System.out.println(answer);
	}
}
