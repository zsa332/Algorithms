import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int total = A * B * C;
        int[] numCnt = new int[10];
        while(total > 0){
            int idx = total % 10;
            numCnt[idx]++;
            total /= 10;
        }

        for(int i = 0; i < 10; i++){
            System.out.println(numCnt[i]);
        }
    }
}
