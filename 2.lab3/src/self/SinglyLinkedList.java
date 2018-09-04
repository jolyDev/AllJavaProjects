package self;

import lab3_class_skeleton.SLNode;
import lab3_class_skeleton.list.List;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 3
 * 
 * @author Olena Khomenko <br>
 *         Singly-linked list. Implements List interface <br>
 *         This class skeleton contains methods with TODO <br>
 *         Implement methods with TODO and write addition methods to support
 *         class functionality.
 * 
 *         Operations that index into the list will traverse the list from the
 *         beginning or the end, whichever is closer to the specified index.
 *         <br>
 *
 */

public class SinglyLinkedList implements List {
	// Pointer to first node.
	private static SLNode first;
	private static SLNode last;
	private static int size = 0;
	static int int_length = 16; // ask why const is error?

	public SinglyLinkedList() {
		first = null;
	}

	@Override
	public boolean add(String element) {
		element = isCorrect(element);
		if (element == null)
			return false;
		if (first == null) {
			first = new SLNode(element); // i don`t know is that correct
			last = first;
			size = 1;
		} else {
			last.next = new SLNode(element);
			last = last.next;
			size++;
		}
		return true;
	}

	@Override
	public boolean add(int index, String element) {
		element = isCorrect(element);
		if (element == null || !isValidIndex(index))
			return false;
		SLNode copy = getNode(index);
		// insert operation
		SLNode temp = copy.next;
		copy.next = new SLNode(element);
		copy.next.next = temp;
		size++;

		return true;
	}

	private boolean isValidIndex(int index) {
		if (index < 0 || index >= size)
			return false;
		return true;
	}

	@Override
	public String remove(int index) {
		if (isEmpty() || !isValidIndex(index)) {
			return null;
		}
		size--;
		if (index == 0) {
			String to_ret = first.data;
			first = first.next;
			return to_ret;
		}
		return deleteAfter(getNode(index - 1));
	}

	@Override
	public boolean remove(String element) {
		if (first == null)
			return false;
		element = strTransform(element);
		if (first.data.equals(element)) {
			first = first.next;
			size--;
			return true;
		}
		SLNode copy = first;
		while (copy.next != null) {
			if (copy.next.data.equals(element)) {
				deleteAfter(copy);
				size--;
				return true;
			}
			copy = copy.next;
		}
		return false;
	}

	private String deleteAfter(SLNode self) {
		String to_ret = self.next.data;
		self.next = self.next.next;
		return to_ret;
	}

	@Override
	public String get(int index) {
		SLNode copy = getNode(index);
		if (copy != null)
			return copy.data;
		else
			return null;
	}

	@Override
	public String set(int index, String element) {
		SLNode copy = getNode(index);
		if (copy != null) {
			String to_ret = copy.data;
			copy.data = strTransform(element);
			return to_ret;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if (first == null)
			return true;
		return false;
	}

	public void print() {
		SLNode copy = first;
		while (copy != null) {
			System.out.println(copy.data + " \\|/ " + print_digit(copy.data));
			copy = copy.next;
		}
	}

	public static int print_digit(String h) {
		int y = 0;
		for (int i = 1; i < h.length(); i++) {
			y += (h.charAt(i) - 48) * Math.pow(2, h.length() - 1 - i);
		}
		if (h.charAt(0) == '1')
			y *= -1;
		return y;
	}

	private SLNode getNode(int index) {
		if (!isValidIndex(index))
			return null;
		SLNode copy = first;
		for (int i = 0; copy != null; i++) {
			if (i == index)
				return copy;
			copy = copy.next;
		}
		return null; // dead code :)
	}

	private String isCorrect(String a) {
		int len = a.length();
		if (len > int_length)
			return null;
		for (int i = 0; i < len; i++) {
			if (a.charAt(i) != '1' && a.charAt(i) != '0') {
				if (a.charAt(0) != '-')
					return null;
			}
		}
		return strTransform(a);
	}

	private String strTransform(String a) {
		String result = "";
		boolean isMinus = false;
		if (a.charAt(0) == '-')
			isMinus = true;
		for (int i = a.length() - 1; i >= 0; i--) {
			if (a.charAt(i) != '-')
				result = a.charAt(i) + result;
		}
		for (int i = a.length() - 1; i < int_length; i++) {
			result = "0" + result;
		}
		if (isMinus)
			result = "1" + result;
		// else
		// result = "0" + result;
		// System.out.println(result + ";;;;;;");
		return result;
	}

	@Override
	public int size() {
		return size;
	}
}
