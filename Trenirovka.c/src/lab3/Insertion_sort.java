package lab3;

public class Insertion_sort {
	public static void main (String[] argc) {
		int [] a = {6, 7, 3, 1, 0, 8, 5, 3, 2, 1, 6, 7, 0, 9};
		int n = a.length;
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}
		System.out.print("\n");
		for (int i = 0; i < n ; i++) {
			int v = a[i];
			int j = i-1;
			while (j >= 0 && a[j] > v) {
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = v;
		}
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}
	}
	
	public static void swap(int[] a, int i , int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
