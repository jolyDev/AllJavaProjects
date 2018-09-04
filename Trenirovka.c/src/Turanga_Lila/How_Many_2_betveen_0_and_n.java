package Turanga_Lila;

public class How_Many_2_betveen_0_and_n {

	public static void main (String[] argc) {
		System.out.println(qcount(0, 13));
	}

	private static int qcount(int l, int r) {
		int count = 0;
		int number = 0;
		for (int i = 0; r != 0; r /= 10) {
			number = r % 10;
			if (number >= 2)
				count += Math.pow(10, i);
		}
		return count;
	}
}
