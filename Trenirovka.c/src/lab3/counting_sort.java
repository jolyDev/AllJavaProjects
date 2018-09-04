package lab3;

public class counting_sort {
	public static void main (String[] argc) {
		int [] a = {6, 7, 3, 1, 0, 8, 5, 3, 2, 1, 6, 7, 0, 9, 7};
		int k = 9;
		int[] C = new int[k + 1];
		for (int i = 0; i < k; i++) {
			C[k] = 0;
		}
		int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			C[a[i]]++;
		}

		int j = 0;
		for (int i = 0; i < n;) {
			if (C[j] == 0) {
				j++;
			} else {
			a[i] = j;
			C[j]--;
			i++;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.print("\n");
	}
}
