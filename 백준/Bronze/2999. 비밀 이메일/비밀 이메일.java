import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String str = st.nextToken();
		
		int len = str.length();
		
		int r = 0;
		int c = 0;
		for(int i = 1; i <= Math.sqrt(len); i++) {
			if(len % i == 0) {
				r = i;
				c = len/i;
			}
		}
		
		char[][] massege = new char[r][c];
		int idx = 0;
		for(int i = 0; i < c; i++) {
			for(int j = 0; j < r; j++) {
				massege[j][i] = str.charAt(idx++);
			}
		}
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(massege[i][j]);
			}
		}
	}

}
