import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int[] lenArr = new int[6];
		int maxLen = 0;
		int maxIdx = 0;
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			lenArr[i] = len;
			if(maxLen < len) {
				maxLen = len;
				maxIdx = i;
			}
		}
		int left = maxIdx - 1 >= 0 ? maxIdx - 1 : 5;
		int right = (maxIdx + 1) % 6;
		int rect = 0;
		if(lenArr[left] > lenArr[right]) {
			int row = left - 1 >= 0 ? left - 1 : 5;
			
			rect = maxLen * lenArr[left] - (maxLen - lenArr[row]) * (lenArr[left] - lenArr[right]);
		}
		else {
			int row = (right + 1) % 6;
			rect = maxLen * lenArr[right] - (maxLen - lenArr[row]) * (lenArr[right] - lenArr[left]);
		}
		
		System.out.println(rect * K);
	}

}
