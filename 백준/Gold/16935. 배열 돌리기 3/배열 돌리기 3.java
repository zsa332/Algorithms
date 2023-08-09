import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int c = Integer.parseInt(st.nextToken());
			switch (c) {
			case 1:
				upDownInversion();
				break;
			case 2:
				leftRightInversion();
				break;
			case 3:
				rightRotate90();
				break;
			case 4:
				leftRotate90();
				break;
			case 5:
				rangeRightRotate();
				break;
			case 6:
				rangeLeftRotate();
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void upDownInversion() {
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int tmp = map[i][j];
				map[i][j] = map[N - i - 1][j];
				map[N - i - 1][j] = tmp;
			}
		}
	}

	private static void leftRightInversion() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M / 2; j++) {
				int tmp = map[i][j];
				map[i][j] = map[i][M - j - 1];
				map[i][M - j - 1] = tmp;
			}
		}
	}

	private static void rightRotate90() {
		int tmp = N;
		N = M;
		M = tmp;
		int[][] rotateMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotateMap[i][j] = map[M - j - 1][i];
			}
		}
		
		map = rotateMap;
	}

	private static void leftRotate90() {
		int tmp = N;
		N = M;
		M = tmp;
		int[][] rotateMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				rotateMap[i][j] = map[j][N - i - 1];
			}
		}

		map = rotateMap;
	}

	private static void rangeRightRotate() {
		int[][] rotateMap = new int[N][M];
		int width = M / 2;
		int height = N / 2;

		// 1 -> 2
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i][j + width] = map[i][j];
			}
		}

		// 2 -> 3
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i + height][j + width] = map[i][j + width];
			}
		}

		// 3 -> 4
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i + height][j] = map[i + height][j + width];
			}
		}

		// 4 -> 1
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i][j] = map[i + height][j];
			}
		}
		
		map = rotateMap;
	}
	
	private static void rangeLeftRotate() {
		int[][] rotateMap = new int[N][M];
		int width = M / 2;
		int height = N / 2;

		// 1 -> 4
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i + height][j] = map[i][j];
			}
		}

		// 4 -> 3
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i + height][j+width] = map[i+height][j];
			}
		}

		// 3 -> 2
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i][j + width] = map[i + height][j + width];
			}
		}

		// 2 -> 1
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				rotateMap[i][j] = map[i][j+width];
			}
		}
		
		map = rotateMap;
	}
}