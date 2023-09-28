import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int F = sc.nextInt();

        int answer = 0;
        N /= 100;
        N *= 100;
        while (N % F != 0) {
            N++;
            answer++;
        }
        if (answer < 10) {
            System.out.print("0");
        }
        System.out.print(answer);
    }
}
