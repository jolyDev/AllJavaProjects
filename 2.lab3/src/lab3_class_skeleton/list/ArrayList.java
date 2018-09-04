package lab3_class_skeleton.list;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 * 
 *         Resizable-array. Implements List interface <br>
 *         This class skeleton contains methods with TODO <br>
 *         Implement methods with TODO and write addition methods to support
 *         class functionality.
 * 
 *         Methods isEmpty, get, set operations run in constant time. <br>
 *         The add operation runs in amortized constant time. <br>
 *         All of the other operations run in linear time (roughly speaking).
 */

public class ArrayList implements List {
	// The array buffer into which the elements of the ArrayList are stored. The
	// capacity of the ArrayList is the length of this array buffer

	private String[] list;

	// Default initial capacity
	private final int defaultCapacity = 10;

	// the size of the array used to store the elements in the list
	private int capacity;

	// The size of the ArrayList (the number of elements it contains)
	private int size;

	/**
	 * Constructs an empty list with an initial capacity of ten
	 * 
	 */
	public ArrayList() {
		this.capacity = defaultCapacity;
		// TODO

	}

	/**
	 * Constructs an empty list with the specified initial capacity
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the list
	 */
	public ArrayList(int initialCapacity) {
		this.capacity = initialCapacity;
		// TODO

	}

	@Override
	public boolean add(String element) {
		// TODO

		return false;
	}

	@Override
	public boolean add(int index, String e) {

		// TODO

		return false;

	}

	@Override
	public String remove(int index) {
		// TODO

		return null;
	}

	@Override
	public boolean remove(String element) {
		// TODO

		return false;
	}

	@Override
	public String get(int index) {
		// TODO

		return null;
	}

	@Override
	public String set(int index, String element) {
		// TODO

		return null;
	}

	@Override
	public int size() {
		// TODO

		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO

		return false;
	}

}
