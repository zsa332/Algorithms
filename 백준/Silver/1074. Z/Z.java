import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		recursive(0, 0, (int)Math.pow(2, N));
	}

	private static void recursive(int r, int c, int size) {
		if (r == R && c == C) {
			System.out.println(ans);
			return;
		}
		int hSize = size/2;
		if(R < r + hSize && C < c + hSize) {
			recursive(r, c, hSize);
		}
		else if(R < r + hSize && C >= c + hSize) {
			ans += (size*size) / 4;
			recursive(r, c + hSize, hSize);
		}
		else if(R >= r + hSize && C < c + hSize) {
			ans += (size*size) / 4 * 2;
			recursive(r + hSize, c, hSize);
		} 
		else if(R >= r + hSize && C >= c + hSize) {
			ans += (size*size) / 4 * 3;
			recursive(r + hSize, c + hSize, hSize);
		}
	}
}