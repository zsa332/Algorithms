import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		if (T % 10 != 0)
			System.out.println(-1);
		else {
			int fM = T / 300;
			int oM = T % 300 / 60;
			int tS = T % 60 / 10;

			System.out.println(fM + " " + oM + " " + tS);
		}
		sc.close();
	}

}
