package Turanga_Lila;

public class tic_tac_toe {
	public static void main (String[] argc) {
		String[] ttt = {"tic", "tac", "toe"};
		System.out.println(match(ttt[2], ttt[2], ttt[0], ttt[2], ttt[2]));
	}
	
	public static boolean match(String ... ts) {
		if (ts.length < 2)
			return false;			
		int[] ch = {0, 0, 0};
		for (int i = 0; i < ts.length; i++) {
			if (ts[i].charAt(1) == 'i')
				ch[0]++;
			if (ts[i].charAt(1) == 'a')
				ch[1]++;
			if (ts[i].charAt(1) == 'o')
				ch[2]++;
		}
		if (ch[0] == 0 && ch[2] == 1)
			return true;
		if (ch[1] == 0 && ch[0] == 1)
			return true;
		if (ch[2] == 0 && ch[1] == 1)
			return true;
		return false;
	}
}
