package lab3_class_skeleton.stack;

/**
 * @author Olena Khomenko <br>
 *         The Stack represents a last-in-first-out (LIFO) stack of objects.
 * 
 */
public interface Stack {

	/**
	 * Tests if this stack is empty
	 * 
	 * @return true if this stack contains no items; false otherwise
	 */
	boolean isEmpty();

	/**
	 * Removes the item at the top of this stack and returns that item as the
	 * value of this function.
	 * 
	 * @return the object at the top of this stack or empty String if this stack
	 *         is empty
	 * 
	 */
	String pop();

	/**
	 * Adds an item onto the top of this Stack
	 * 
	 * @param item
	 *            the item to be pushed onto this stack
	 */
	void push(String item);

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack
	 * 
	 * @return the top element in the stack, or null if the stack is empty.
	 **/
	String top();

	/**
	 * Returns the number of elements in this stack
	 * 
	 * @return the number of elements in the stack
	 */
	int size();

}