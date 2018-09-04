package lab3;
public class buble_sort {
	public static void main (String[] argc) {
		int[] a = {4, 1, 5, 0, 8, -3, 7, 9, 1};
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "  ");
		}
		int n = a.length;
		System.out.print("\nn = " + n + "\n");
		for (int i = 0; i < n - 1; i++) {
			  //System.out.println("\nnew row!!!");
			for (int j = 0; j < n - 1 - i; j++) {
				/*
				System.out.print("\n");
				System.out.print("\n i = " + i + "       j = " + j +"\n"
						+ " a[j] = " + a[j] + "    a[j+1] = " + a[j + 1]); 
				System.out.print("\n\n");
				*/

				if (a[j + 1] < a[j]) 
					swap(a, j, j + 1);
				/*
				for (int k = 0; k < a.length; k++) {
					System.out.print(a[k] + "  ");
				}
				*/
			}
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static void swap(int[] a, int i , int j) {
		int temp = a[j];
		a[j] = a[i];
		a[i] = temp;
	}
}
