package lab3;

public class Selection_sort {
	public static void main (String[] argc) {
		int [] a = {6, 7, 3, 1, 0, 8, 5, 3, 2, 1, 6, 7, 0, 9};
		int n = a.length;
		int min = a[0];
		int minIndex = 0;
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}
		for (int i = 0; i < n; i++) {
			min = a[i];
			for (int j = i; j < n ; j++) {
				if (a[j] < min) {
					min = a[j];
					minIndex = j;
				}
			}
			for (int j = minIndex; j > i; j--) {
				a[j] = a[j - 1];
			}
			a[i] = min;
		}
		System.out.print("\n");
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}
	}
}
