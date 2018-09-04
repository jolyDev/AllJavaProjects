package lab4_task1;

import common.FigureSet;
import common.GeomFigure;

public class Hastable implements FigureSet {

	public GeomFigure[] table;

	private int size = 0;

	private static final int initialCapacity = 11;
	private int capacity = initialCapacity;

	private final double A = (Math.sqrt(5) - 1) / 2;
	private static double loadFactor = 0.75;

	public Hastable() {this(initialCapacity, loadFactor); } 
	
	public Hastable(int userInitialCapacity) {
		table = new GeomFigure[initialCapacity];
		capacity = userInitialCapacity;
	}

	public Hastable(int userInitialCapacity, double userLoadFactor) { // i have changed interface
		if (userInitialCapacity <= 0)
			table = new GeomFigure[initialCapacity];
		else {
			table = new GeomFigure[userInitialCapacity];
			capacity = userInitialCapacity;
		}
		if (userLoadFactor > 0 && userLoadFactor < 1)		 										   // primary was loadFactor
			loadFactor = userLoadFactor;							  // ask why they do not intersect
	}

	public int size() {return this.size;}

	private void rehash() {
		GeomFigure[] bigger_table = new GeomFigure[capacity+=16];
		for (int i = 0; i < capacity - 16; i++)
			if (table[i] != null)
				bigger_table[hash(table[i])] = table[i];
		table = bigger_table;
	}
	
	// gf.hashCode() % capacity // divide metod
	public int hash(GeomFigure gf) { return (int) (capacity * (gf.hashCode() * A % 1));} // multiply metod

	@Override
	public boolean add(GeomFigure gf) {
		if (gf != null) {
			int index = hash(gf);
			if (table != null && table[index] == null) { // ask why not working without table != null
				size = size + 1;
				table[index] = gf;
//				System.out.println(size);
//				System.out.print(gf.toString());
//				gf.printTrap();
//				System.out.println("");
			} else {return false;}
			if (size > loadFactor * capacity)
				rehash();
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(GeomFigure gf) {
		if (gf != null)
			return gf.equals(table[hash(gf)]);
		return false;
	}

	@Override
	public boolean remove(GeomFigure gf) {
		if (gf != null) {
			int index = hash(gf);
			if (contains(gf)) {
				this.table[index] = null;
				size--;
				return true;
			} else {return false;}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void print() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] == null)
				System.out.println(i + ") " + "null");
			else
				System.out.println(i + ") " + table[i].toString());
		}
	}
}