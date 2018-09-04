package bst;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * KPI- FPM - PZKS Course: Algorithms and Data Structures (2) Laboratory work 5
 * 
 * @author Olena Khomenko <br>
 * 
 *         Binary search tree based implementation StudentDictionary Keeps
 *         specified information about students
 * 
 *         each node contains id (number of student's card) and information
 *         about student (name, surname etc.)
 * 
 *         all search, delete and get operation use unique id as a key
 * 
 * @param <E>
 */

public class BSTree<E extends Student> implements StudentDictionary<E> {

	/**
	 * root of a tree
	 */
	private TreeNode<E> root = null;
	
	private int size = 0;

	public BSTree() {

	}

	/**
	 * Returns true if this dictionary (binary search tree) contains an student
	 * for the specified cardNumber
	 * 
	 * @param cardNumber
	 *            cardNumber whose presence in this tree is to be tested
	 * @return true if this tree contains an student record for the specified
	 *         cardNumber
	 */
	@Override
	public boolean containsKey(int cardNumber) {
		if (cardNumber <= 0)
			return false;
		TreeNode<E> self = this.root;
		while (self != null) {
			// System.out.print(self.st.getName());
			if (cardNumber < self.st.getID())
				self = self.left;
			else if (cardNumber > self.st.getID())
				self = self.right;
			else if (self.st.getID() == cardNumber)
					return true;
		}
		return false;
	}

	/**
	 * Returns the number of nodes in this tree.
	 * 
	 * @return he number of nodes in this tree
	 */
	@Override
	public int size() { return size; }

	/**
	 * Returns the student to which the specified cardNumber is associated, or
	 * null if this tree contains no student for the cardNumber.
	 * 
	 * @param cardNumber
	 *            the cardNumber whose associated student is to be returned
	 * @return the student with the specified cardNumber, or null if this tree
	 *         contains no student for the cardNumber or cardNumber is invalid
	 *         (negative or 0)
	 */
	@Override
	public E get(int cardNumber) {
		if (cardNumber <= 0)
			return null;
		TreeNode<E> self = this.root;
		while (self != null) {
			if (cardNumber < self.st.getID())
				self = self.left;
			else if (cardNumber > self.st.getID())
				self = self.right;
			else
				return self.st;
		}
		return null;
	}
	
	private TreeNode<E> getNode(int cardNumber) {
		if (cardNumber <= 0)
			return null;
		TreeNode<E> self = this.root;
		while (self != null) {
			if (cardNumber < self.st.getID())
				self = self.left;
			else if (cardNumber > self.st.getID())
				self = self.right;
			else
				return self;
		}
		return null;
	}

	/**
	 * Removes the student for this cardNumber from this tree if present.
	 * 
	 * @param cardNumber
	 *            cardNumber for which student should be removed
	 * @return the previous student associated with cardNumber, or null if there
	 *         was no student for cardNumber.
	 */
	@Override
	public E remove(int cardNumber) {
		TreeNode<E> to_remove = getNode(cardNumber);
		if (to_remove == null)
			return null;
//		if (to_remove == this.root) {
//			replaceSubTree(to_remove.right.getMinimum().getValue());
//			return to_remove.getValue();
//		}
		if (to_remove.right == null && to_remove.left == null)
				replaceSubTree(to_remove, null);
		else if (to_remove.right != null && to_remove.left == null) {
				replaceSubTree(to_remove, to_remove.right);
				to_remove.right.left = to_remove.left;
		}
		else if (to_remove.right == null && to_remove.left != null) {
				replaceSubTree(to_remove, to_remove.left);
				to_remove.left.right = to_remove.right;
		}
		else {
			TreeNode<E> newcomer = to_remove.getMinimum();
			if (newcomer.parent == to_remove) {
				replaceSubTree(to_remove, newcomer);
				newcomer.left = to_remove.left;
			} else {
				if (to_remove.parent != null)
					if (to_remove.parent.isLeftChild(to_remove))
						to_remove.parent.left = newcomer;
					else
						to_remove.parent.right = newcomer;
				replaceSubTree(newcomer, newcomer.right);
				replaceSubTree(to_remove, newcomer);
				newcomer.right = to_remove.right;
				newcomer.left = to_remove.left;
			}
		}
		return to_remove.st;					
	}
	

	// use this method when remove nodes
	private void replaceSubTree(TreeNode<E> u, TreeNode<E> v) {
		if (u == root) {
			root = v;
		} else {
			if (u.parent.isLeftChild(u))
				u.parent.setLeft(v);
			else
				u.parent.setRight(v);
		}
	}

	/**
	 * Remove from a tree all students that satisfy specified criteria
	 * 
	 * @param removeCriteria
	 *            one or more criteria by witch students will be removed from
	 *            this tree
	 * @return number of students was be removed
	 */
	public void remove(String[] removeCriteria) {
		TreeNode<E> st = this.root;
		// List<MyType> myList = new ArrayList<MyType>();
		List<TreeNode<E>> prisoners =  new ArrayList<TreeNode<E>>();
		recRemove(removeCriteria, this.root,  prisoners);
		System.out.println("Nodes to delete is " + prisoners.size());
		for (Iterator<BSTree<E>.TreeNode<E>> it = prisoners.iterator(); it.hasNext();)
			this.remove(it.next().getValue().getID());
		// 1) find all nodes witch students satisfy specified removeCriteria
		// save in a list nodes to be removed
		// 2) call method remove (node) for each node in a list
		// 3) call size method to check successful removing
		// 4) return difference between old size and new size
		return ;

	}
	
	private void recRemove(String[] crit, TreeNode<E> currSt, List<TreeNode<E>> prisoners) {
		if (currSt == null)
			return ;
		boolean to_remove = true;
		for (int i = 0; i < crit.length; i+=2) {
			if (crit[i].equals("Name")) 		to_remove = to_remove && isRemoveName(crit[i + 1], currSt);
			if (crit[i].equals("gradYear")) 	to_remove = to_remove && isRemoveGradYear(crit[i + 1], currSt);
			if (crit[i].equals("ID"))			to_remove = to_remove && isRemoveID(crit[i + 1], currSt);
			if (crit[i].equals("averScore")) 	to_remove = to_remove && isRemoveAverScore(crit[i + 1], currSt);
			if (crit[i].equals("Nation"))		to_remove = to_remove && isRemoveNation(crit[i + 1], currSt);
		}
		if (to_remove)  {
			System.out.println(currSt.toString());
			prisoners.add(currSt);
		}
		recRemove(crit, currSt.left, prisoners);
		recRemove(crit, currSt.right, prisoners);
	}
	
	private boolean isRemoveName(String crit, TreeNode currSt) {
		if (crit.equals(currSt.getValue().getName()))
			return true;
		return false;
	}

	private boolean isRemoveNation(String crit, TreeNode currSt) {
		if (crit.equals(currSt.getValue().getNation()))
			return true;
		return false;
	}
	
	private boolean isRemoveGradYear(String crit, TreeNode currSt) {
		if (Integer.valueOf(crit) == currSt.getValue().getGradYear())
			return true;
		return false;
	}
	
	private boolean isRemoveID(String crit, TreeNode currSt) {
		if (Integer.valueOf(crit) == currSt.getValue().getID())
			return true;
		return false;
	}
	
	private boolean isRemoveAverScore(String crit, TreeNode currSt) {
		Double mark = Double.valueOf(crit);
		Double stud_mark = currSt.getValue().getScore();
		if (mark < 0 || stud_mark < 0)
			return false;
		if (mark <= 40 && stud_mark <= 40)  // Fx
			return true;
		if (mark <= 60 && stud_mark <= 60
				&& mark > 40 && stud_mark > 40)  // F
			return true;
		if (mark <= 65 && stud_mark <= 65
				&& mark > 60 && stud_mark > 60)  // E
			return true;
		if (mark <= 75 && stud_mark <= 75
				&& mark > 65 && stud_mark > 65)  // D
			return true;
		if (mark <= 85 && stud_mark <= 85
				&& mark > 75 && stud_mark > 75)  // C
			return true;
		if (mark <= 95 && stud_mark <= 95
				&& mark > 85 && stud_mark > 85)  // B
			return true;
		if (mark <= 100 && stud_mark <= 100
				&& mark > 95 && stud_mark > 95) // A
			return true;
		return false;
	}

	/**
	 * Returns true if this dictionary contains no key-value mappings
	 * 
	 * @return true if this dictionary contains no key-value mappings
	 */
	@Override
	public boolean isEmpty() { return size == 0 ? true : false;}

	/**
	 * Associates the specified student with the specified cardNumber in this
	 * dictionary. If the dictionary previously contained a mapping for the
	 * cardNumber, the old student is replaced by the specified student.
	 * 
	 * @param num
	 *            cardNumber with which the specified student is to be
	 *            associated
	 * @param s
	 *            student to be associated with the specified cardNumber
	 * @return the previous student associated with cardNumber, or null if there
	 *         was no mapping for key
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public E put(int cardNumber, Student s) {
		if (cardNumber <= 0 || s == null)
			return null;
		size++;
		TreeNode<E> rookie = new TreeNode(s);
		if (this.root == null) {
			this.root = rookie;
			return null;
		}
		TreeNode<E> self = new TreeNode<E>();
		self = this.root;
		while (true) {
			if (cardNumber < self.st.getID()) { // tut neponyatno
				if (self.left == null) {
					System.out.println("	 " + self.st.getName() + "-> left");
					self.left = rookie;
					rookie.parent = self;
					return null;
				}
				else {
					System.out.println("	from " + self.st.getName());
					self = self.left;
					System.out.println("   l> " + self.st.getName());
				}
			} else if (cardNumber > self.st.getID()) {
				if (self.right == null) {
					System.out.println("	 " + self.st.getName() + "-> right");
					self.right = rookie;
					rookie.parent = self;
					return null;
				} else {
					System.out.println("	from " + self.st.getName());
					self = self.right;
					System.out.println("   r> " + self.st.getName());
				}
			} else {
				System.out.println("Error equals id\n This element not added to the tree");return null;}
		}
	}

	/**
	 * Outputs dictionary elements in table form
	 */


	public void levelOrderPrint() {
		Queue q = new ArrayBlockingQueue<TreeNode<E>>(11); // i can`t add null-element in queue
		// Queue<TreeNode<E>> q = Queue<TreeNode<E>>;
		if (this.root == null)
			return ;
		q.add(this.root);
		for(int i = 2, j = 2; !q.isEmpty(); j++) {
			TreeNode<E> node = (BSTree<E>.TreeNode<E>) q.remove();
			if (node != null) {
				System.out.print(node.getValue().getName() + " ");
				if (node.left != null)
					q.add(node.left);
				// else  System.out.print("empty node ");
				if (node.right != null) // i can`t crasivo vyvesty becouse nizzya q(null)
					q.add(node.right);
				// else  System.out.print("empty node ");
			}
			if (i == j) {
				System.out.println();
				i+=2;
			}
		}
	}
	
	public void printDictionary() {	
		// this.levelOrderPrint(); // can`t nice paint becouse fucking null
		recPrint(this.root);
		}
	
	private void recPrint(TreeNode<E> self) {
		if (self == null || self.st == null)
			return ;
		// System.out.println(self.st.toString()); // full info
		System.out.print(self.st.getName() + "=>"); // less info
		recPrint(self.left);
		recPrint(self.right);
	}

	@SuppressWarnings("hiding")
	class TreeNode<E extends Student> {
		/**
		 * information about student. Instance of class Student
		 */
		private E st = null;

		/**
		 * reference to the right node
		 */
		private TreeNode<E> right = null;

		/**
		 * reference to the left node
		 */
		private TreeNode<E> left = null;
		/**
		 * reference to the parent node
		 */

		private TreeNode<E> parent = null;
		
		public TreeNode() {
			
		}

		public TreeNode(E e) { this.st = e; }

		public TreeNode(E s, TreeNode<E> parent) {
			TreeNode<E> newS = new TreeNode<E>(s);
			newS.parent = parent;
			if (s.getID() < parent.st.getID())
				parent.left = newS;
			else 
				parent.right = newS;
			// this(s);
		}

		public int getKey() { return st.getkey(); }

		public E getValue() { return st; }

		public TreeNode<E> addLeftChild(E s) {
			TreeNode<E> prevChild = this.left;
			this.left = new TreeNode<E>(s, this);
			this.left.parent = this;
			return prevChild;
		}

		public TreeNode<E> addRightChild(E s) {
			TreeNode<E> prevChild = this.right;
			this.right = new TreeNode<E>(s, this);
			this.right.parent = this;
			return prevChild;
		}

		public void setLeft(TreeNode<E> left) { 
			this.left = left;
			if (this.left != null)
				this.left.parent = this;
			}

		public void setRight(TreeNode<E> right) { 
			this.right = right;
			if (this.right != null)
				this.right.parent = this;
			}

		public boolean isLeftChild(TreeNode<E> node) { 
			return this.left == node ? true : false;
		}

		public boolean isRightChild(TreeNode<E> node) {
			return this.right == node ? true : false;
		}

		public TreeNode<E> getMinimum() {
			TreeNode<E> min = this.right;
			while (min.left != null)
				min = min.left;
			return min;
		}

		@Override
		public String toString() { return st.toString();}

	}

}
