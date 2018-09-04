package self;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 *         Dequeue is double ended queue. <br>
 *         This interface defines methods to access the elements at both ends of
 *         the deque. Methods are provided to insert, remove, and examine the
 *         element.
 * 
 */

public interface Deque {

	/**
	 * Inserts the specified element at the front of this deque if it is
	 * possible
	 * 
	 * @param e
	 *            the element to add
	 * @return true if this queue changed as a result of the call
	 */
	boolean addFirst(int e);

	/**
	 * Inserts the specified element at the end of this deque if it is possible
	 * 
	 * @param e
	 *            the element to add
	 * @return true if this queue changed as a result of the call
	 */
	boolean addLast(int e);

	/**
	 * Retrieves and removes the first element of this deque
	 * 
	 * @return the head of this deque or empty String if this queue is empty
	 */
	int removeFirst();

	/**
	 * Retrieves and removes the last element of this deque if it is possible
	 * 
	 * 
	 * @return the tail of this deque or empty String if this queue is empty
	 */
	int removeLast();

	/**
	 * Retrieves, but not removes, the first element of this deque
	 * 
	 * @return the head of this deque or empty String if this queue is empty
	 */
	int getFirst();

	/**
	 * Retrieves, but not removes, the last element of this deque
	 * 
	 * @return the tail of this deque or empty String if this queue is empty
	 */
	int getLast();

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	int size();

	/**
	 * Returns true if this deque contains no elements.
	 * 
	 * @return true if this deque contains no elements
	 */
	boolean isEmpty();

}
