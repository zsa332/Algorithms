import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] link = new int[N];
		Stack<Tower> stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			
			if(!stack.isEmpty() && stack.peek().height < height) {
				while(!stack.isEmpty() && stack.peek().height < height) {
					stack.pop();
				}
			}
			
			if(stack.isEmpty())link[i] = 0;
			else link[i] = stack.peek().idx + 1;
			
			stack.push(new Tower(i, height));
		}
		
		for(int t : link) {
			System.out.print(t+" ");
		}
	}
}
class Tower{
	int idx;
	int height;
	public Tower(int idx, int height) {
		super();
		this.idx = idx;
		this.height = height;
	}
}