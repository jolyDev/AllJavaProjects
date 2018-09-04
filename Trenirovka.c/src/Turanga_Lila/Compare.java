package Turanga_Lila;

public class Compare {
	public static void main (String[] argc) {
		System.out.println(CompareWithoutIF_Else(279, 8));
	}

	private static char[] CompareWithoutIF_Else(int i, int j) {
		for (int k = 31; k > 0; k--) {
			(i >> k == j >> k) ? continue : return 
		}
		return null;
	}
}
