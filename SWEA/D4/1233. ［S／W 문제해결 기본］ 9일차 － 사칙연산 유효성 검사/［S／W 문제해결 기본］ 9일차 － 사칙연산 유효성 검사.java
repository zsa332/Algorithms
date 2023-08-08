import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			for(int i = 0 ; i < N; i++) {
				String[] str = br.readLine().split(" ");
				if(str.length == 4 && isNumber(str[1]) || str.length == 2 && !isNumber(str[1])) {
					answer = 0;
				}
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	public static boolean isNumber(String str) {
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

}
