package lab4_task2;

import common.FigureSet;
import common.GeomFigure;

/**
 * 
 * This class implements a set as a hash table. Hash table resolves collisions
 * Hash table is an associative array of entries. <br>
 * Each entry contains geometric figure or null. <br>
 * 
 *
 */
public class SChHastable implements FigureSet {

	private GeomFigure[] table;


	private int size;


	private final int initialCapacity = 11;
	private int capacity = initialCapacity;

	private double loadFactor = 0.75;

	
	private final double A = (Math.sqrt(5) - 1) / 2;

	
	public SChHastable() {table = new GeomFigure[initialCapacity];}

	
	public SChHastable(int userInitialCapacity) {table = new GeomFigure[userInitialCapacity];}

	
	public SChHastable(int userInitialCapacity, double userLoadFactor) {
		table = new GeomFigure[userInitialCapacity];
		loadFactor = userLoadFactor;
	}


	public int size() {return size;}

	/**
	 * Increases the capacity of and internally reorganizes this hashtable, in
	 * order to accommodate and access its entries more efficiently. This method
	 * is called when the number of elements in the hashtable exceeds this
	 * hashtable's capacity and load factor
	 */
	private void rehash() {
		GeomFigure[] bigger_table = new GeomFigure[capacity+=16];
		for (int i = 0; i < capacity - 16; i++)
			if (table[i] != null)
				bigger_table[hash(table[i])] = table[i];
		table = bigger_table;
	}

	/**
	 * The hash function is used to calculate the hasvalue of the object gf.
	 * Choose hashing method from your variant (table 1): deletion or
	 * multiplication
	 * 
	 * @param gf
	 *            some geometric figure
	 * @return hash value - index in table
	 */
	private int hash(GeomFigure gf) {return gf.hashCode() % capacity;}

	@Override
	public boolean add(GeomFigure gf) { // without colisions
		// TODO
		// if gf is not null and hashtable doesn't contain gf
		// ---calculate hash-value (slot number) of gf
		// ---add new Node (gf) to the linked list in the this slot
		// ---increase the size of hash table
		// ---return true
		return false;
	}

	@Override
	public boolean contains(GeomFigure gf) { // do not cheaked
		if (gf != null) {
			int index = hash(gf);
			if (table[index] != null)
				return gf.equals(table[index]);
		}
		return false;
	}

	@Override
	public boolean remove(GeomFigure gf) {
		// TODO
		// if gf is not null and hashtable contains gf
		// ---Calculate hashvalue of gf
		// ---if slot is not empty
		// -------delete Node (gf) from linked list
		// -------decrease the size of hash table
		// -------return true
		
		if (gf != null) {
			int index = hash(gf);
			if (table[index] == null) 
				return false;
			else {
				table[index] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		// check the size of hashtable
		return false;
	}

	@Override
	public void print() {
		// TODO
		// Output the table , where each row contains a number of the hash-table
		// slot, and the all elements that hashes to this slot.For example,

		// If a slot is empty the row contains a number of the hash-table slot
		// and the message “The slot is empty”.

	}

}

class DLNode {

	private GeomFigure f;

	private DLNode next;
	private DLNode prev;

}
