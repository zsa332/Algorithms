import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 초기 N개의 원본 암호문이 주어지며 각 명령어를 통해 암호문이 수정된다.
 * 명령어는 I x y pws 의 형태로 x의 인덱스에 y개의 pws를 삽입하게 된다.
 * 이 때 x부터 x+y까지의 인덱스의 값들을 변경하는게 아닌 삽입되는 것이기때문에 기존의 값들은 뒤로 밀리게 된다.
 * 
 * 입력
 *  - 10 <= N <= 20
 *  - N개의 원본 암호문
 *  - 5 <= M <= 10
 *  - M개의 명령어
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 암호문을 저장할 리스트 삽입을 하기 때문에 LinkedList 사용
		LinkedList<Integer> list; 
		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 초기 암호문 개수
			
			list = new LinkedList<>(); // 암호문 저장 list 초기화
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken())); // 초기 암호문 입력
			}

			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 명령어 개수

			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M; i++) {
				st.nextToken(); // I 버리기
				int idx = Integer.parseInt(st.nextToken()); // 삽입한 index
				int num = Integer.parseInt(st.nextToken()); // 추가할 암호문 개수
				for(int j = idx; j < idx+num; j++) {
					list.add(j, Integer.parseInt(st.nextToken())); // 암호문 삽입
				}
			}
			
			/* 답 추출 */
			StringBuilder sb = new StringBuilder("#").append(tc);
			for(int i = 0; i < 10; i++) {
				sb.append(" ").append(list.get(i));
			}
			System.out.println(sb.toString());
		}
	}
}
