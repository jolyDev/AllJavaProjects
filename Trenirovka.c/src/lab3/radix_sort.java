package lab3;

public class radix_sort {
	public static void main (String[] argc) {
		int [] a = {6123, 7532, 3145, 1124, 0753, 8985, 5456,
				3642, 2109, 1067, 6546, 7234, 0234, 9765, 7973};
		int[] af = new int[a.length];
		int n = a.length;
		int rozryad = 4;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "  ");
		}
		for (int i = 10; i < rozryad; i*=10) {
			for (int j = 0; j < a.length; j++) {
				af[j] = (a[j] % i)/(i/10);
			}
			buble_sort(af, a);
		}
		System.out.print("\n");
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "  ");
		}
	}
	
	
	public static void buble_sort (int[] af, int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				if (af[j + 1] < af[j]) 
					swap(a, j, j + 1);
			}
		}
	}
	
	public static void swap(int[] a, int i , int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
