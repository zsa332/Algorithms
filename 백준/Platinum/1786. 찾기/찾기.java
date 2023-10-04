import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static String T, P;
	static int[] table;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = br.readLine();
		P = br.readLine();
		
		makeTable();
		
		int idx = 0;
		List<Integer> results = new ArrayList<>();
		for(int i = 0; i < T.length(); i++) {
			while(idx > 0 && T.charAt(i) != P.charAt(idx)) {
				idx = table[idx - 1];
			}
			
			if(T.charAt(i) == P.charAt(idx)) {
				if(idx == P.length()-1) {
					results.add(i - idx + 1);
					idx = table[idx];
				}
				else idx++;
			}
		}
		System.out.println(results.size());
		for(int res : results)System.out.print(res + " ");
	}
	private static void makeTable() {
		int n = P.length();
		table = new int[n];
		
		int idx = 0;
		for(int i = 1; i < n; i++) {
			while(idx > 0 && P.charAt(i) != P.charAt(idx))idx = table[idx-1];
			
			if(P.charAt(i) == P.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
	}
}
