package Turanga_Lila;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class FunnyMath {

	public static void main (String[] argc) {
//		int[] x = {9,9,9,9,7,4,5};
//		int[] y = {5,0,0};
		
//		int[] x = {9,9,9,9,4,3,6};
//		int[] y = {7,2,1};
		
		int[] x = {9,9,5,3};
		int[] y = {7,0};
		int[] res = FunnyAdd(x, y);
		for (int i = 0; i < res.length; i++) 
			System.out.print(res[i] + " | ");
	}
	
	public static int[] FunnyAdd(int[] x, int[] y) {
		int xlen = x.length - 1;
		int ylen = y.length - 1;
		
		int t  = 0;
		
		List<Integer> to_rem = new ArrayList<Integer>();
		
		for (int i = ylen; i >= 0; i--) {
			System.out.print(x[xlen - ylen + i] + " | " +  y[i] + " || ");
			t = x[xlen - ylen + i] + y[i];
			System.out.println(t);
			if (t > 10) {
				++x[xlen - ylen - 1];
				System.out.println("Increment" + " " + x[xlen - ylen - 1]);
				to_rem.add(t - 10);
				// MakeAllprevZeros(x, xlen);
				for (int k = y.length - 1; k > 0; k--)  {
					to_rem.add((y[k] + x[xlen - ylen + k] - 9)*(-1));
					System.out.println(y[k] + " " + x[xlen - ylen + k] + "{}");
				}
				
				for (int j = 0; j < x.length; j++)
					x[j] = -9;
				
				System.out.println( " \n" + to_rem.size());
				
				for (Integer s : to_rem)
					System.out.println(s + " = ");

				for (int j = 0; j < to_rem.size(); j++) {
					x[x.length - to_rem.size() + j] += to_rem.get(j);
				}
			}
			
			
		}
		return x;
	}
}
