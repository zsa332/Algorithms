import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[N][M];
		int[][] B = new int[N][M];
		
		//	A행렬
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < M; j++) {
				A[i][j] = line.charAt(j) - '0';
			}
		}
		//	B행렬
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j = 0; j < M; j++) {
				B[i][j] = line.charAt(j) - '0';
			}
		}
		
		//	원소 뒤집기
		int[] dx = {0, 0, 0, 1, 1, 1, 2, 2, 2};
		int[] dy = {0, 1, 2, 0, 1, 2, 0, 1, 2};
		int answer = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = 0; j < M - 2; j++) {
				if(A[i][j] != B[i][j]) {
					for(int k = 0; k < 9; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						A[nx][ny] = A[nx][ny] == 0 ? 1 : 0;
					}
					answer++;
				}
			}
		}
		
		//	체크
		boolean check = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(A[i][j] != B[i][j])check = false;
			}
		}
		
		if(check)System.out.println(answer);
		else System.out.println(-1);
	}
}
