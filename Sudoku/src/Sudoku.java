public class Sudoku {
	// please do not run empty slot, it will take forever to find out)
	public static String[] initBoard = {
			"...534.8.",
			".8..1.4..",
			".2.8...71",
			"8...6..5.",
			"4....583.",
			"63.1.....",
			".....13..",
			"....7....",
			".162....."
			};
	
	public static void main(String[] argc) {		
		System.out.println("Initial game board");
		Sudoku_rules_container.printGameBoard(initBoard);
		solve(initBoard);
	}
	
	public static void solve (String[] board) {
		firstOrderTraversal(new DNode(initBoard));
	}
	
	public static boolean firstOrderTraversal(DNode root) {
		//Sudoku_rules_container.printGameBoard(root.cells_placement);
		int gap = Sudoku_rules_container.firstGap(root.cells_placement);
		if (gap == -1) {
			System.out.println("\nFilled board");
			printPath(root);
			return true;
		}
		int[] row = Sudoku_rules_container.StringToRow(root.cells_placement, gap / 9); 
		int[] col = Sudoku_rules_container.StringToCol(root.cells_placement, gap % 9);
		int sqX = (gap / 9) % 3;	int sqY = (gap % 9) / 3;
		int sqPos = Sudoku_rules_container.getSquarePosition(gap);
		int[] square = Sudoku_rules_container.StringToSquare(root.cells_placement, sqPos);  
		for (int i = 1; i <10; i++) {
			//System.out.println(Sudoku_rules_container.canBeInRow(i, row, gap % 9) + " " +
//				Sudoku_rules_container.canBeInColumn(i, col, gap / 9) + " " +
//				Sudoku_rules_container.canBeInSquare(i, square, sqY*3 + sqX) + " | " + i );
			if (Sudoku_rules_container.canBeInRow(i, row) &&
				Sudoku_rules_container.canBeInColumn(i, col) && 
				Sudoku_rules_container.canBeInSquare(i, square)) {
					firstOrderTraversal(new DNode(root.cells_placement, gap, i));
			}
		}
		return false;
	}

	public static void printPath(DNode node) {
		Sudoku_rules_container.printGameBoard(node.cells_placement);
	}
}
