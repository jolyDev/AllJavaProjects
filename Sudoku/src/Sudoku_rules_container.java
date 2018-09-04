
public class Sudoku_rules_container {
	
	public Sudoku_rules_container() {
		
	}
	
	public static int firstGap(String[] board) {
		for (int i = 0; i < board.length; i++) {
			char[] line = board[i].toCharArray();
			for (int j = 0; j < line.length; j++) {
				if (line[j] == '.')
					return i * line.length + j;
			}
		}
		return -1;
	}
	
	public static void changeTile(String[] board, int pos, int value) {
		int row = pos / 9;
		int col = pos % 9;
		char[] ch = board[row].toCharArray();
		ch[col] = (char) ((char)value + '0');
		board[row] = String.copyValueOf(ch);
	}
	
	public static boolean canBeInRow(int number, int[] row) {
		for(int i : row) 
			if (i == number)
				return false;
		return true;
	}
	
	public static boolean canBeInColumn(int number, int[] col) {
		for(int i : col) 
			if (i == number)
				return false;
		return true;
	}
	
	public static boolean canBeInSquare(int number, int[] square) {
		for(int i : square) 
			if (i == number)
				return false;
		return true;
	}
	
	public static int[] StringToRow(String[] board, int row) {
		int[] nums = new int[9];
		char[] line = board[row].toCharArray();
		for (int i = 0; i < 9; i++) {
			if (line[i] == '.')
				nums[i] = 0;
			else nums[i] = (int)(line[i]) - '0';
		}
		return nums;
	}
	
	public static int[] StringToCol(String[] board, int col) {
		int[] nums = new int[9];
		for (int i = 0; i < 9; i++)
			if (board[i].charAt(col) == '.')
				nums[i] = 0;
			else nums[i] = (int)(board[i].charAt(col)) - '0';
		return nums;
	}
	
	public static int getSquarePosition(int Coordinates) {
		int y = Coordinates / 27;
		int x = (Coordinates % 9) / 3;
		return y * 3 + x;
	}
	// count of squares begins from zeros
	// 0 | y == 0..3 | x == 0..3
	// 5 | y == 3..6 | x == 6..9
	
	public static int[] StringToSquare(String[] board, int pos) {
		int x = 3 * (pos % 3);	int y = 3 * (pos / 3);
		int[] nums = new int[9];
		for (int i = y, k = 0; i < y + 3; i++) {
			for (int j = x; j < x + 3; j++, k++) {
				char u = board[i].charAt(j);
				if (u == '.')
					nums[k] = 0;
				else nums[k] = (int) u - '0';
			}
		}
		return nums;
	}
	
	public static void printGameBoard(String[] board) {
		for (int i = 0; i < board.length; i++) { // to refill gap
			if (i % 3 == 0)
				System.out.println("");
			char [] line = board[i].toCharArray();
			for (int y = 0; y < line.length; y++) {
				if (y % 3 == 0)
					System.out.print("  ");
				System.out.print(" " + line[y]);
			}
			System.out.println("");
		}
	}
}
