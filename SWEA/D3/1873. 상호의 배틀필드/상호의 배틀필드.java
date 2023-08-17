import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * H x W 사이즈의 맵내에서 사용자의 명령에 따라 탱크가 행동해야한다.
 * 맵의 구성은 다음과 같다.
 *	 .	평지(전차가 들어갈 수 있다.)
 *	 *	벽돌로 만들어진 벽
 *	 #	강철로 만들어진 벽
 *	 -	물(전차는 들어갈 수 없다.)
 *	 ^	위쪽을 바라보는 전차(아래는 평지이다.)
 *	 v	아래쪽을 바라보는 전차(아래는 평지이다.)
 *	 <	왼쪽을 바라보는 전차(아래는 평지이다.)
 *	 >	오른쪽을 바라보는 전차(아래는 평지이다.)
 *
 * 명령의 구성은 다음과 같다.
 *	 U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
 *	 D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
 *	 L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
 * 	 R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
 * 	 S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 * 
 * 포탄의 경우 벽을 만나는 경우만 벽을 부수고 평지로 만들며 강철을 만나거나 맵밖으로 나가면 종료해야 한다.
 */
public class Solution {
	/* 맵 정보 */
	static char[][] map;
	/* 높이, 넓이, 탱크의 x, y 좌표 */
	static int H, W, x, y;
	/* 탱크 x 이동 방향 */
	static int[] dx = { -1, 1, 0, 0 };
	/* 탱크 y 이동 방향 */
	static int[] dy = { 0, 0, -1, 1 };
	/* 탱크 방향별 모양 */
	static char[] tank = { '^', 'v', '<', '>' };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // TestCase
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			H = Integer.parseInt(st.nextToken()); // 높이
			W = Integer.parseInt(st.nextToken()); // 넓이

			map = new char[H][W]; // 맵 초기화
			x = 0; // x 좌표 초기화
			y = 0; // y 좌표 초기화
			for (int i = 0; i < H; i++) {
				String line = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j); // 맵 정보 입력
					// 맵에 탱크가 입력되면 위치 저장
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}

			int N = Integer.parseInt(br.readLine()); // 입력의 갯수
			String command = br.readLine(); // 입력
			tankController(command); // 입력에 따라 연결할 컨트롤러

			/* 결과 출력 */
			System.out.print("#" + tc + " ");
			for (char[] cs : map) {
				for (char c : cs) {
					System.out.print(c);
				}
				System.out.println();
			}
		}
	}

	/**
	 * 입력으로 들어온 명령에 따라 해당 연산을 실행할 함수와 연결
	 * 
	 * @param command : 입력
	 */
	private static void tankController(String command) {
		// 초기에 입력된 탱크의 방향에 따라 방향 설정
		int dir = map[x][y] == '^' ? 0 : map[x][y] == '<' ? 2 : map[x][y] == '>' ? 3 : 1;
		for (int i = 0; i < command.length(); i++) {
			switch (command.charAt(i)) {
			case 'U':
				moveTank(0); // 위로 이동
				dir = 0; // 위쪽 방향으로 갱신
				break;
			case 'D':
				moveTank(1); // 아래로 이동
				dir = 1; // 아래쪽 방향으로 갱신
				break;
			case 'L':
				moveTank(2); // 왼쪽으로 이동
				dir = 2; // 왼쪽 방향으로 갱신
				break;
			case 'R':
				moveTank(3); // 오른쪽으로 이동
				dir = 3; // 오른쪽 방향으로 갱신
				break;
			case 'S':
				shoot(dir); // 현재 방향으로 발사
				break;
			}
		}
	}

	/**
	 * 현재 바라보고 있는 방향으로 프탄 발사
	 * 
	 * @param dir : 현재 바라보고 있는 방향
	 */
	private static void shoot(int dir) {
		int maxDis = dir == 0 || dir == 1 ? H : W; // 방향에 따라 발사될 거리 설정

		for (int i = 1; i <= maxDis; i++) {
			int nx = x + dx[dir] * i;
			int ny = y + dy[dir] * i;
			if (nx < 0 || ny < 0 || nx >= H || ny >= W || map[nx][ny] == '#') // 맵의 범위를 벗어나거나 강철 벽을 만나면 종료 
				break;
			if (map[nx][ny] == '*') { // 벽을 만나면 벽을 평지로 만들고 종료
				map[nx][ny] = '.';
				break;
			}
		}
	}

	/**
	 * 명령에 따라 방향을 전환하고 이동이 가능하다면 이동
	 * 
	 * @param dir : 명령으로 들어온 방향
	 */
	private static void moveTank(int dir) {
		map[x][y] = tank[dir]; // 현재의 방향을 명령으로 들어온 방향으로 변환

		int nx = x + dx[dir]; // 이동할 x 좌표
		int ny = y + dy[dir]; // 이동할 y 좌표

		if (nx >= 0 && ny >= 0 && nx < H && ny < W && map[nx][ny] == '.') { // 맵의 범위내에서 평지인 경우 이동 수행
			map[x][y] = '.'; // 이동하기 전좌표 평지로
			x = nx;
			y = ny;
			map[x][y] = tank[dir]; // 이동 후 탱크의 방향에 맞춰 입력
		}
	}
}
