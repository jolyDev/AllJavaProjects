package Turanga_Lila;

import java.util.ArrayList;
import java.util.List;

public class Tasks {
	public static void main (String[] argc) {
		// System.out.println(allUnicCharecter("abuhgtrfdm"));
//		System.out.println(reverseMatrix("abu"
//				+ "hgt"
//				+ "rfd"));
		//System.out.println();
		findZeros();
	}
	
	public static void findZeros() {
		int[][] tg = {
				{1,2,4,5},
				{5,7,8,0},
				{5,0,9,3}};
		List<Integer> row = new ArrayList<Integer>();
		List<Integer> col = new ArrayList<Integer>();
		for(int i = 0; i < tg.length; i++)
			for(int j = 0; j < tg[i].length; j++)
				if (tg[i][j] == 0) {
					row.add(i); col.add(j);
				}
		for (int k : row)
			for (int i = 0; i < tg[k].length; i++)
				tg[k][i] = 0;
		for (int k : col) 
			for (int i = 0; i < tg.length; i++)
				tg[i][k] = 0;
		
		for(int i = 0; i < tg.length; i++) {
			for(int j = 0; j < tg[i].length; j++)
					System.out.print(tg[i][j]+ " ");
			System.out.println();
		}
	}
	
	public static String reverseMatrix(String s) {
		int len = (int) Math.sqrt(s.length());
		char[] ch = s.toCharArray();
		char temp;
		for(int i = 0; i < len; i++)
			for(int j = i + 1; j < len; j++) {
				temp = ch[i];
				ch[i] = ch[j];
				ch[j] = temp;
			}
		s = new String(ch);
		return s;
	}
	
	public static boolean allUnicCharecter(String s) {
		char[] ch =  s.toCharArray();
		for(int i = 0; i < ch.length - 1; i++)
			for(int j = i + 1; j < ch.length; j++) 
				if (ch[i] == ch[j])
					return false;
		return true;
	}
}
