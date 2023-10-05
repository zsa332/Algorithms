import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String hexStr = br.readLine();
			List<Character> hexList = new ArrayList<Character>();
			for(int i = 0; i < hexStr.length(); i++) {
				hexList.add(hexStr.charAt(i));
			}
			
			
			Set<Integer> pwSet = new HashSet<>();
			for(int rotate = 0; rotate < N/4; rotate++) {
				int start = 0;
				int end = N / 4;
				for(int i = 0; i < 4; i++) {
					String hex = "";
					for(int j = start; j < end; j++) {
						hex += hexList.get(j);
					}
					pwSet.add(Integer.parseInt(hex, 16));
					start = end;
					end += N / 4;
				}
				hexList.add(0, hexList.get(hexList.size()-1));
				hexList.remove(hexList.size()-1);
			}
			List<Integer> pwList = new ArrayList<>(pwSet);
			Collections.sort(pwList, Collections.reverseOrder());
			System.out.println("#" + tc + " " + pwList.get(K-1));
		}
	}
}