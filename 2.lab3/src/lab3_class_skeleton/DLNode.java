package lab3_class_skeleton;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko
 *
 *         Node in a double-linked list.
 */
public class DLNode {
	String data; // the data stored in this node.

	DLNode next; // pointer to the next node
	DLNode prev; // pointer to the previous nod

	/**
	 * Construct the node of doubly-linked list with null pointers to the next
	 * and previous nodes
	 * 
	 * @param data
	 *            the data to stored in this node
	 */
	public DLNode(String data) {
		this.data = data;
		next = null;
		prev = null;
	}

	/**
	 * Construct the node of doubly-linked list and fill its fields
	 * 
	 * @param data
	 *            the data to stored in this node
	 * @param next
	 *            pointer to the next node
	 * @param prev
	 *            pointer to the previous node
	 */
	public DLNode(String data, DLNode next, DLNode prev) {
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

}
