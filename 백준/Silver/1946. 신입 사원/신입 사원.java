import java.io.*;
import java.util.*;

public class Main {
	static int T, num;
	static int[][] score;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			num = Integer.parseInt(br.readLine());
			score = new int[num][2];
			
			for (int j = 0; j < num; j++) {
				String[] str = br.readLine().split(" ");
				score[j][0] = Integer.parseInt(str[0]);	
				score[j][1] = Integer.parseInt(str[1]);
			}

			Arrays.sort(score, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return Integer.compare(o1[0], o2[0]);
				}

			});
			
			int top = score[0][1];
			int cnt=0;
			for(int j=1;j<num;j++) {
				if(top<score[j][1]) {
					cnt++;
					continue;
				}
				top=score[j][1];
			}
			System.out.println(num-cnt);
		}
	}
}