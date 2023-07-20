import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 
		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 int L = Integer.parseInt(st.nextToken());
		 
		 int[] arr = new int[N+1];
		 
		 int cur = 1, cnt = 0;
		 while(true) {
			 arr[cur] += 1;
			 
			 if(arr[cur] == M)break;
			 
			 if(arr[cur] % 2 == 0)cur += L;
			 else cur -=L;
			 
			 if(cur > N)cur -= N;
			 else if(cur < 1)cur += N;
			 cnt++;
		 }
		 System.out.println(cnt);
	}

}