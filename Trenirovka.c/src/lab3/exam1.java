package lab3;

public class exam1 {
	public static void main(String[] argc) {
		//int [] a = {8, 5, 40, 10, 30, 80, 60, 20,5, 85};
		int [] a = {8, 5, 40, 5, 30, 5, 10, 5, 5, 85};
		int n = a.length;
		int A = 5;
		
		if (n <= 0) {
			System.out.println("Mistake");
			return;
		}
		
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}

		boolean first = true;
		int lo = 0;
		int hi = 0;
		
		for (int i = 0; i < n; i++) {
			if (a[i] == A) {
				if (first) {
					lo = i;
					first = false;
				}
				else 
					hi = i;
			}
		}
		
		for (int i = lo; i < hi ; i++) {
			int v = a[i];
			int j = i-1;
			while (j >= lo && a[j] > v) {
				a[j+1] = a[j];
				j = j-1;
			}
			a[j+1] = v;
		}
		
		System.out.print("\n");
		for (int k = 0; k < a.length; k++) {
			System.out.print(a[k] + "  ");
		}
	}		
}
