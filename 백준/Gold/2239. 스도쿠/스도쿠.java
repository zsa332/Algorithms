import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        int cnt = 0;
        for(int i = 0; i < 9; i++){
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = line.charAt(j) - '0';
                if(map[i][j] == 0)cnt++;
            }
        }

        backtracking(0, 0);

    }

    private static void backtracking(int x, int y) {
        if(y == 9){
            backtracking(x + 1, 0);
            return;
        }
        if(x == 9){
            for(int[] row : map){
                for(int col : row) System.out.print(col);
                System.out.println();
            }
            System.exit(0);
        }

        if(map[x][y] == 0){
            for(int i = 1; i <= 9; i++){
                if(numCheck(x, y, i)){
                    map[x][y] = i;
                    backtracking(x, y + 1);
                    map[x][y] = 0;
                }
            }
            return;
        }

        backtracking(x, y + 1);
    }

    private static boolean numCheck(int x, int y, int num){
        for(int i = 0; i < 9; i++){
            if(map[x][i] == num)return false; // 행 체크
            if(map[i][y] == num)return false; // 열 체크
        }
        
        // 박스 체크
        int boxX = x / 3 * 3;
        int boxY = y / 3 * 3;
        for(int i = boxX; i < boxX + 3; i++){
            for(int j = boxY; j < boxY + 3; j++){
                if(map[i][j] == num)return false;
            }
        }
        return true;
    }
}
