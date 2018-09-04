package Turanga_Lila;
import java.util.Scanner;

public class first1 {
	public static void main (String[] args) {
		
	    Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the ADS variant 1\n Choose 1 or 2 task");
		int choose = in.nextInt();
		
		if (choose == 1) {
		String myString = in.next();
		char [] symb = myString.toCharArray();
		int g = symb.length;
		
		for (int i = 0; i < g; i++) {
			System.out.print(symb[i]);
		}
		
		System.out.println("");
		
		for (int i = 0; i < g; i++) {
			if (symb[i] != 'a')
				System.out.print(symb[i]);
		}
	}
	 else {
			//DLNode newNode = new DLNode();
			//newNode.data = data;
	}
}
}