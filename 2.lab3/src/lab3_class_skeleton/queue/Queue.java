package lab3_class_skeleton.queue;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 *         Queue order elements in a FIFO (first-in-first-out)policy. <br>
 *         In a FIFO queue,all new elements are inserted at the tail of the
 *         queue. The head of the queue is that element which would be removed
 *         by a call to dequeue(). Other kinds of queues may use different
 *         placement rules. Every Queue implementation must specify its ordering
 *         properties
 * 
 */

public interface Queue {

	/**
	 * Insert element e at the tail of the queue
	 * 
	 * @param item
	 *            the element to add
	 * @return true if this queue changed as a result of the call
	 */
	public boolean enqueue(String e);

	/**
	 * Retrieves and removes the head of this queue
	 * 
	 * @return the head of this queue or empty string
	 */
	public String dequeue();

	/**
	 * Retrieves, but does not remove, the head of this queue
	 * 
	 * @return the head of this queue, or empty String if this queue is empty
	 */
	public String head();

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the number of elements in this queue
	 */
	public int size();

	/**
	 * Returns true if this queue contains no elements.
	 * 
	 * @return true if this queue contains no elements
	 */
	public boolean isEmpty();

}
