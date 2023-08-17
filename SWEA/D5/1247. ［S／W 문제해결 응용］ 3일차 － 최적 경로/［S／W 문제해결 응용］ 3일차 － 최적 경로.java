import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static Point[] points;
	static Point start, end;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // TestCase
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			start = new Point();
			end = new Point();
			start.x = Integer.parseInt(st.nextToken());
			start.y = Integer.parseInt(st.nextToken());
			end.x = Integer.parseInt(st.nextToken());
			end.y = Integer.parseInt(st.nextToken());
			
			points = new Point[N];
			for(int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points[i] = new Point(x, y);
			}
			
			int[] arr = new int[N];
			for(int i = 0; i < N;i++) {
				arr[i] = i;
			}
			
			int answer = Integer.MAX_VALUE;
			do {
				int sum = Math.abs(start.x - points[arr[0]].x) + Math.abs(start.y - points[arr[0]].y);
				for(int i = 0; i < N - 1; i++) {
					sum += Math.abs(points[arr[i]].x - points[arr[i+1]].x) + Math.abs(points[arr[i]].y - points[arr[i+1]].y);
				}
				sum += Math.abs(end.x - points[arr[N-1]].x) + Math.abs(end.y - points[arr[N-1]].y);
				answer = Math.min(answer, sum);
			}while(np(arr));
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	private static boolean np(int[] arr) {
		int N = arr.length;
		int i = N - 1;
		while(i > 0 && arr[i-1] >= arr[i])--i;
		if(i == 0) return false;
		
		int j = N - 1;
		while(arr[i - 1] >= arr[j])--j;
		
		swap(arr, i-1, j);
		
		int k = N - 1;
		while(i < k) {
			swap(arr, i++, k--);
		}
		return true;
	}
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}