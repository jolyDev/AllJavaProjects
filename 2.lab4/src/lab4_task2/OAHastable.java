package lab4_task2;

import common.FigureSet;
import common.GeomFigure;


public class OAHastable implements FigureSet {

	public GeomFigure[] table;


	private int size;


	private final int initialCapacity = 11;
	private int capacity = initialCapacity;


	private double loadFactor = 0.75;


	private final double A = (Math.sqrt(5) - 1) / 2;


	private final static DelGeomFigure DELL = DelGeomFigure.getInstance(); // DelGeomFigure.getInstance(); 
																 // i do not know how it works so ...

	public OAHastable() {table = new GeomFigure[initialCapacity];}


	public OAHastable(int userInitialCapacity) { // why i cant write it nice like
		capacity = userInitialCapacity;			// OAHastable(userInitialCapacity, loadFactor);
		table = new GeomFigure[userInitialCapacity];
	}

	
	public OAHastable(int userInitialCapacity, double userLoadFactor) {
		table = new GeomFigure[userInitialCapacity];
		loadFactor = userLoadFactor;
	}


	@Override
	public int size() {	return size;}

	
	private void rehash() {
		GeomFigure[] bigger_table = new GeomFigure[capacity+=16];
		for (int i = 0; i < capacity - 16; i++)
			if (table[i] != null && table[i] != DELL)
				bigger_table[hash(table[i])] = table[i];
		this.table = bigger_table;
		// this.print();
	}


	public int hash(GeomFigure gf) {return gf.hashCode() % capacity;}

	@Override
	public boolean add(GeomFigure gf) {
		if (gf != null) {
			int index = hash(gf);
			if (table[index] == null || table[index] == DELL) { // ask why not working without table != null
				table[index] = gf;
//				System.out.println("");
//				System.out.print(gf.toString());
//				gf.printTrap();
//				System.out.println("");
			} else {
				if (table[index].equals(gf)) 
					return false;
				else {
					int i = 1;
					for (; table[(index + i) % capacity] != null &&
							table[(index + i) % capacity] != DELL; i++);
					table[(index + i) % capacity] = gf;
				}
			}
			size++;
			// System.out.println("size = " + size + " Capacity " + capacity);
			if ((double)size >= loadFactor * capacity)
				rehash();
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(GeomFigure gf) { // i do not know
		if (gf != null)
			if (table[hash(gf)] != null)
				return gf.equals(table[hash(gf)]);
		return false;
	}

	@Override
	public boolean remove(GeomFigure gf) {
		if (gf != null) {
			int index = hash(gf);
			if (table[index] == null || table[index] == DELL) 
				return false;
			else {
				table[index] = DELL;
				size--;
				return true;
			}
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
			else if (table[i] ==  DELL) {
				System.out.println(i + ") " + DELL.toString());
			} else
				System.out.println(i + ") " + table[i].toString());
		}
	}

}

/*
 * Represents object that was be deleted from a table
 */

class DelGeomFigure extends GeomFigure {
	private static DelGeomFigure delFigure = null;;;;;; // nice, i don`t know that i can do this, Wow
	static String[] del = {"0", "0", "0", "0", "0", "0", "0", "0"};
	
	private DelGeomFigure() {
		super(del);
	}

	public static DelGeomFigure getInstance() {
		if (delFigure == null) {
			delFigure = new DelGeomFigure();
		}
		return delFigure;
	}
	
	@Override
	public String toString() {return "deleted)";}

}
