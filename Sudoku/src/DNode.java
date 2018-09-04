
public class DNode {
	
		public String[] cells_placement = null;
		
		public DNode(String[] data) {
			this.cells_placement = data;
		}
		
		public DNode(String[] data, int gap, int value) {
			this.cells_placement = new String[9];
			for (int i = 0; i < data.length; i++) 
				this.cells_placement[i] = new String(data[i]);
			Sudoku_rules_container.changeTile(this.cells_placement, gap, value);
			//System.out.println(this.cells_placement);
		}
}
