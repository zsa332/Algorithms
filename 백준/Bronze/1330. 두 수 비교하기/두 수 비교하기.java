import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        String answer = A == B ? "==" : A > B ? ">" : "<";

        System.out.println(answer);
    }
}