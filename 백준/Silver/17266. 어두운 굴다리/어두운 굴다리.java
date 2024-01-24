import java.util.Scanner;

public class Main {
    static int[] map;
    static int N,M;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N =sc.nextInt();
        M =sc.nextInt();
        map = new int[M];

        for(int i = 0; i < M; i++) {
            map[i] = sc.nextInt();
        }

        int left = 1;
        int right = N;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(possible(mid)) {
                result = mid;
                right = mid - 1;
            }
            else left = mid + 1;
        }
        System.out.println(result);
    }

    static boolean possible(int target) {
        int prev = 0;
        for(int i = 0; i < map.length; i++) {
            if(map[i] - target <= prev) {
                prev = map[i] + target;
            } else return false;
        }
        return N - prev <= 0;
    }
}