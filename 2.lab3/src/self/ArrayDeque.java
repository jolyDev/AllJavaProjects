package self;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 * 
 *         Resizable-array deque. Implements of the Deque interface. <br>
 *         Array deques have no capacity restrictions; they grow as necessary to
 *         support usage. <br>
 * 
 *         This class skeleton contains methods with TODO <br>
 *         Implement methods with TODO and write addition methods to support
 *         class functionality.
 * 
 * 
 */

public class ArrayDeque implements Deque {
	// The array in which the elements of the deque are stored.
	private final int startCapacity = 8;
	private int Capacity = startCapacity;
	int[] queue = new int[Capacity];

	// The index of the element at the head of the deque
	private int head = 0; // to go throw checking line 38

	// The index at which the next element would be added to the tail of the
	// deque
	private int tail = 0;

	private int size = 0;

	// The minimum capacity that we'll use for a newly created deque

	@Override
	public boolean addFirst(int e) {
		if (isFull())
			resize();
		if (head == 0) {
			if (!isEmpty())
				head = queue.length - 1;
		} else
			head--;
		size++;
		queue[head] = e;
		return true;
	}

	private boolean isFull() {
		if (size == Capacity)
			return true;
		return false;
	}

	@Override
	public boolean addLast(int e) {
		if (isFull())
			resize();
		queue[++tail] = e;
		size++;
		if (tail == queue.length)
			tail = 0;
		return true;
	}

	@Override
	public int removeFirst() {
		if (!isEmpty()) {
			size--;
			if (head == queue.length - 1) {
				head = 0;
				return queue[queue.length - 1];
			}
			return queue[++head - 1];
		}
		return -1;
	}

	@Override
	public int removeLast() {
		if (!isEmpty()) {
			size--;
			if (tail == 0)
				tail = queue.length;
			return queue[--tail];
		}
		return -1;
	}

	@Override
	public int getFirst() {
		return !isEmpty() ? queue[head] : -1;
	}

	@Override
	public int getLast() {
		if (tail == 0 && !isEmpty())
			return queue[queue.length - 1];
		return !isEmpty() ? queue[tail - 1] : -1;
	}

	@Override
	public int size() {
		return size;
	}

	public void print() {
		for (int i = 0; i < queue.length; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.print("\n");
	}

	private void resize() {
		Capacity *= 2;
		int[] bigger_queue = new int[Capacity];
		for (int i = head, j = 0; j < queue.length; i++, j++) {
			if (i == queue.length)
				i = 0;
			bigger_queue[j] = queue[i];
		}
		head = 0;
		tail = queue.length;
		queue = bigger_queue;
		// print();
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}
}
