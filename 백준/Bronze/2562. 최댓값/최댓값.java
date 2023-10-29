import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < 9; i++){
            int num = sc.nextInt();
            if(max < num){
                idx = i + 1;
                max = num;
            }
        }

        System.out.println(max + "\n" + idx);
    }
}