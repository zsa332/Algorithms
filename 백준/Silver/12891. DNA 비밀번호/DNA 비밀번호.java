import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dnaNum;
	static int[] checkNum;
	static int check;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		char[] dnaChr = br.readLine().toCharArray();
		
		st = new StringTokenizer(br.readLine());
		dnaNum = new int[4];
		for(int i = 0; i < 4; i++) {
			dnaNum[i] = Integer.parseInt(st.nextToken());
			if(dnaNum[i] == 0)check++;
		}
		
		char[] dnaArr = {'A', 'C', 'G', 'T'};
		checkNum = new int[4];
		//	부분 문자열 처음 받을 때
		for(int i = 0; i < P; i++) {
			Add(dnaChr[i]);
		}

		int answer = 0;
		int start = 0;
		int end = P-1;
		while(end < S) {
			if(check == 4)answer++;
			
			Remove(dnaChr[start]);
			start++;
			end++;
			if(end < S)Add(dnaChr[end]);
		}
		System.out.println(answer);
		br.close();
	}
	
	public static void Add(char c) {
		switch(c) {
		case 'A':
			checkNum[0]++;
			if(checkNum[0] == dnaNum[0])check++;
			break;
		case 'C':
			checkNum[1]++;
			if(checkNum[1] == dnaNum[1])check++;
			break;
		case 'G':
			checkNum[2]++;
			if(checkNum[2] == dnaNum[2])check++;
			break;
		case 'T':
			checkNum[3]++;
			if(checkNum[3] == dnaNum[3])check++;
			break;
		}
	}
	public static void Remove(char c) {
		switch(c) {
		case 'A':
			if(checkNum[0] == dnaNum[0])check--;
			checkNum[0]--;
			break;
		case 'C':
			if(checkNum[1] == dnaNum[1])check--;
			checkNum[1]--;
			break;
		case 'G':
			if(checkNum[2] == dnaNum[2])check--;
			checkNum[2]--;
			break;
		case 'T':
			if(checkNum[3] == dnaNum[3])check--;
			checkNum[3]--;
			break;
		}
	}
}
