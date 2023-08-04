import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] cro = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		String str = st.nextToken();
		
		int answer= 0;
		for(int i = 0; i < 8; i++) {
			String tmp = str.replaceFirst(cro[i], " ");

			if(!str.equals(tmp)) {
				i--;
				answer++;
			}
			str = tmp;
		}
		str = str.replace(" ", "");
		answer += str.length();
		
		System.out.println(answer);
		
	}

}
