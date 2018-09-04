package Turanga_Lila;

import java.util.Random;
import java.util.Scanner;

public class Game_of_Master_Mind {
	public static void main (String[] argc) {
		Scanner in = new Scanner(System.in);
		System.out.println(" The Game of Master Mind if you want to see rules enter 1, if you want to play pres any key: \r\n");
		//if (in.nextLine().equals("1"))
			//System.out.println(
//				"The computer has four slots containing balls that are red (R), yellow (Y), green (G) or \r\n" + 
//				"blue (B).  For example, the computer might have RGGB (e.g., Slot #1 is red, Slots #2 and \r\n" + 
//				"#3 are green, Slot #4 is blue).\r\n" + 
//				"You, the user, are trying to guess the solution. You might, for example, guess YRGB.\r\n" + 
//				"When you guess the correct color for the correct slot, you get a “hit”. If you guess \r\n" + 
//				"a color that exists but is in the wrong slot, you get a “pseudo-hit”. For example, the \r\n" + 
//				"guess YRGB has 2 hits and one pseudo hit.\r\n" + 
//				"For each guess, you are told the number of hits and pseudo-hits. \r\n" + 
//				"Write a method that, given a guess and a solution, returns the number of hits and \r\n" + 
//				"pseudo hits.");
//		else System.out.println("Go!");
		String answer = randomColor();
		// System.out.println(answer);
		while (!gues(answer, in.nextLine()));
		System.out.println("Congratulation, you win!");
	}
	
	public static boolean gues(String x, String y) {
		if (y.length() != 4)
			System.out.println("Attention you have entered more then 4 elements");
		int hits = 0;
		int p_hits = 0;
		char[] a = x.toCharArray();
		char[] b = y.toCharArray();
		for (int i = 0; i < 4; i++)
			if (a[i] == b[i]) {
				hits++;
				a[i] = 'l';
				b[i] = 'o';
			}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++)
				if  (a[i] == b[j]) {
					if (a[i] != b[i] && b[j] != a[j]) {
						p_hits++;
						b[j] = 'o';
					break;
				}
			}
		}
		System.out.println("AVAILABLE COLOR R(red) Y(yellow) G(green) B(blue) ");
		System.out.println("hits " + hits + " | pseudo hits " + p_hits);
		System.out.println("XXXX " +  y + "\n");
		return hits == 4 ? true : false;
			
	}
	
	public static String randomColor() {
		String code = "";
		int t = 0;
		Random r = new Random();
		while (code.length() != 4) {
			t = Math.abs(r.nextInt()) % 4;
			switch(t) {
				case 0:
					code = "R" + code;
				break;
				case 1:
					code = "Y" + code;
				break;
				case 2:
					code = "G" + code;
				break;
				case 3:
					code = "B" + code;
				break;
			}
		}
		return code;
	}
	
}
