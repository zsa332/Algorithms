import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int destination[] = new int[n];
		int shuffle[] = new int[n];
		int cards[] = new int[n];

		for (int i = 0; i < n; i++) {
			destination[i] = in.nextInt();
			cards[i] = destination[i];
		}
		for (int i = 0; i < n; i++) {
			shuffle[i] = in.nextInt();
		}

		int index = 0;
		while (true) {
			if (isPossible(cards)) {
				break;
			}

			shuffleCards(cards, shuffle);
			index++;

			if (isSame(destination, cards)) {
				index = -1;
				break;
			}
		}
		System.out.println(index);
	}

	private static void shuffleCards(int[] destination, int[] shuffle) {
		int length = destination.length;
		int newDestination[] = new int[length];

		for (int i = 0; i < length; i++) {
			newDestination[shuffle[i]] = destination[i];
		}
		for (int i = 0; i < length; i++) {
			destination[i] = newDestination[i];
		}
		newDestination = null;
	}

	private static boolean isPossible(int[] destination) {
		for (int i = 0; i < destination.length; i++) {
			if (destination[i] != i % 3) {
				return false;
			}
		}
		return true;
	}

	private static boolean isSame(int[] destination, int[] cards) {
		for (int i = 0; i < destination.length; i++) {
			if (destination[i] != cards[i]) {
				return false;
			}
		}
		return true;
	}
}