package lab3_class_skeleton.queue;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 *         Resizable-array queue. Implements Queue interface <br>
 *         This class skeleton contains methods with TODO <br>
 *         Implement methods with TODO and write addition methods to support
 *         class functionality.
 * 
 */

public class ArrayQueue implements Queue {
	// The array in which the elements of the queue are stored
	String[] queue;

	// The index of the element at the head of the queue
	private int head;

	// The index at which the next element would be added to the tail of the
	// queue
	private int tail;

	// The minimum capacity that we'll use for a newly created queue
	private final int defaultCapacity = 8;

	public ArrayQueue() {
		// TODO
		// Allocate empty array to hold the defaultCapacity number of elements.
	}

	public ArrayQueue(int initialCapacity) {
		// TODO
		// Allocate empty array to hold the initialCapacity number of elements.
	}

	@Override
	public boolean enqueue(String e) {
		// TODO
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO
		return false;
	}

	@Override
	public String dequeue() {
		// TODO
		return null;
	}

	@Override
	public String head() {
		// TODO
		return null;
	}

	@Override
	public int size() {
		// TODO
		return 0;
	}

}
