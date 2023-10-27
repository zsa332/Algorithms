import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[105][105];
        int sum = 0;

        dp[2][1] = 2;
        for(int i = 3; i <= n; i++){
            for(int j = 1; j <= i - 1; j++)dp[i][j] = (dp[i-1][j] * 2 + dp[i - 1][j-1] + dp[i - 1][j + 1]) % 10007;
        }
        for(int i = 1; i <= n-1; i++)sum += dp[n][i];
        System.out.println(sum % 10007);

    }
}