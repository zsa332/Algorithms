import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String seat = st.nextToken();
		
		int L = 0;
		int answer = 0;
		boolean check = false;
		for(int i = 0; i < seat.length(); i++) {
			if(seat.charAt(i) == 'S')answer++;
			else if(seat.charAt(i) == 'L')L++;
			if(L == 2) {
				L = 0; 
				answer++;
				check = true;
			}
		}
		if(check)answer++;
		System.out.println(answer);
	}

}
