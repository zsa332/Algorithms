import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*
		 * 1. 입력 N
		 * 2. N개의 정수 x 입력
		 * 3. 0을 만나면 배열에서 절댓값이 가장 작은 값을 출력, 절댓값이 같은 수가 있다면 그냥 비교하여 낮은값 출력
		 */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(Math.abs(o1) < Math.abs(o2))return -1;
				else if(Math.abs(o1) > Math.abs(o2))return 1;
				else if(Math.abs(o1) == Math.abs(o2)) {
					if(o1 < o2) return -1;
					else if(o1 > o2)return 1;
					else return 0;
				}
				else return 0;
			}
		});
		
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num != 0) {
				pQueue.add(num);
			} else if(num == 0) {
				if(pQueue.isEmpty())sb.append("0\n");
				else sb.append(pQueue.poll()+"\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
