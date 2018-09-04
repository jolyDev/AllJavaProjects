package lab3;

import java.io.File;

/**
 * KPI- FPM - PZKS
 * Course: Algorithms and Data Structures (1)
 * Laboratory work 3
 * @author Olena Khomenko
 * This is a program skeleton for lab 3
 * Write your code in the places of the methods which are marked by TODO marker 
 * Write own methods that will be invoked from existing method 
 * 
 */

public class Main {
	private static String fileName = "input.dat";
	private static String currenDir = System.getProperty("user.dir") + File.separatorChar + "data";
	private static DLNode firstList = null;

		public static void main(String[] args) {
			FileAssistant fa = new FileAssistant();

			fa.setFileName(currenDir, fileName);
			

			// Task 3.1: Create the first double-linked list

			if (fa.readFile()) {
				// Successful reading file

				System.out.println("Start reading a file: ");

				// read the first integer value from the text file
				int number = fa.readNextInt();

				while (number != FileAssistant.ERROR_CODE) {
					//Output integer from a file
					System.out.printf(" %d ", number);

					//create new node of double-linked list
					DLNode node = createDLNode(number);
					
					//add new node to a double-linked list
					firstList = addNode(firstList, node);

					// read the next integer value from the text file
					number = fa.readNextInt();
				}
				System.out.println("\nStop reading a file: \n");

			} else {
				System.out.println("Error: file empty, or does't not found, or there are IO errors: \n");
			}

			System.out.println("THE FIRST LIST:");
			System.out.printf("Size = %d\n", size(firstList));
			printList(firstList);

			// Task 3.2:Change the first double-linked list and create new single-linked list
			SLNode secondList = createSecondList(firstList);

			// print the second list
			System.out.println(System.lineSeparator());
			System.out.println("THE SECOND LIST:");
			System.out.printf("Size = %d\n", size(secondList));
			printList(secondList);

			// check the content of the first list
			System.out.println(System.lineSeparator());
			System.out.println("THE FIRST LIST:");
			System.out.printf("Size = %d\n", size(firstList));
			printList(firstList);

		}
		
		/**
		 * creates new node of the single-linked list
		 * 
		 * @param data
		 *            integer number to be in the node
		 * @return new node
		 */
		
		private static SLNode createSLNode(int data) {
			SLNode newNode = new SLNode();
			newNode.data = data;
			return newNode;

		}

		/**
		 * creates new node of the double-linked list
		 * 
		 * @param data
		 *            integer number to be in the node
		 * @return new node
		 */
		
		private static DLNode createDLNode(int data) {
			DLNode newNode = new DLNode();
			newNode.data = data;
			return newNode;

		}

		/**
		 * Adds new node to the double-linked list to the position defined in the
		 * variant. Head of list that passed as parameter can be differ from the
		 * head when it returns if the new node is inserted to the beginning of the
		 * list
		 * 
		 * @param head
		 *            the first node of the double-linked list
		 * @param node
		 *            new node to be added to the list
		 * @return head of double-linked list
		 */
		
		private static DLNode addNode(DLNode head, DLNode node) {
			// TODO
			if(head != null) {
				node.next = head;
				head.prev = node;
				//node.prev = null;
			}
			return node;
		}
		
		// Add implementation
		// task 3.1
		// position where new node to be insert defines by the variant - the item (a)
		
		/**
		 * adds new node to the single-linked list to the position defined in the
		 * variant. Head of list that passed as parameter can be differ from the
		 * head when it returns if the new node is inserted to the beginning of the
		 * list
		 * @param head 
		 * 			  the first node of the single-linked list
		 * 
		 * @param node 
		 * 			new node to be added to the list
		 * @return
		 * 			head of single-linked list
		 */
		private static SLNode addNode(SLNode head, SLNode node) {
			// TODO
			
				if(head != null) {
					SLNode max = head;
					SLNode current = head;
					while(current != null) {
						if (current.data >= max.data) {
							max = current;
						}
						current = current.next;
					}
					node.next = max.next;
					max.next = node;
				}
				else
					head = node;
			return head;
		}
		
		/**
		 * prints values from nodes in the single-linked list if size of list equals
		 * 0, print message "The list is empty"
		 * 
		 * @param firstList
		 *            head of single-linked list
		 */
		private static void printList(SLNode list) {
			// TODO
			if(list != null) {
					while(list != null) {			
						System.out.printf("%d ", list.data);
						list = list.next;	
					}
			}
			else
				System.out.println("The list is empty");
			System.out.println("");  
		}
		
		// Add implementation
		// if the list is empty, print a message
		// if the list is not empty, print all numbers one by one in the line 
		
		/**
		 * prints values from nodes in the double-linked list. If size of list equals
		 * 0, print message "The list is empty"
		 * 
		 * @param list
		 *            head of double-linked list
		 */

		private static void printList(DLNode list) {
			// TODO
			if(list != null) {
				while(list != null) {
					System.out.printf("%d ", list.data);
					list = list.next;	
				}
			}else 
				System.out.println("List is null");
			System.out.println("");
		}
		
		// Add implementation
		// if the list is empty, print a message
		// if the list is not empty, print all numbers one by one in the line   
		/**obtains the number of nodes in the list
		 * @param list
		 *            head of single-linked list
		 * @return number of nodes in the list or 0, if the list is empty
		 */
		private static int size(SLNode list) {
			// TODO
			int counter = -1;
			if(list != null) {
				counter++;
					while(list != null) {
						counter++;
						list = list.next;
					}
		}
			return counter;
		}
		
		// Add implementation

		/**
		 * obtains the nodes of nodes in the list
		 * @param list
		 *            head of double-linked list
		 * @return number of nodes in the list or 0, if the list is empty
		 */
		private static int size(DLNode list) {
			// TODO
			int counter = -1;
			if(list != null) {
				counter++;
					while(list != null) {
						counter++;
						list = list.next;
					}
		}
			return counter;
		}
		// Add implementation

			/**
		 * finds nodes of double-linked list that satisfies given condition and
		 * delete theirs from list. create new single-linked list that contains
		 * nodes with values of such deleted nodes
		 * 
		 * @param dlHead
		 *            first node of double-linked list
		 * @return head of newly created single-linked list, or null, if any
		 *         elements of double-linked list can't be deleted
		 */
		private static SLNode createSecondList(DLNode dlHead) {
			// TODO
			SLNode SecondList = null;
			if(dlHead != null) {
				DLNode current = dlHead;
				while(current != null) {
					if (current.data % 2 == 0) {
						SecondList = addNode(SecondList, createSLNode(current.data));
						dlHead = remove(dlHead, current);
					}
					current = current.next;
				}
			}
			return SecondList;
		}

			// task 3.2
						// create head of single-linked list
						// go through double-linked list from the head to the tail
						// if the current node of double-linked list is such to be deleted (see variant item (b)),
						// save data from this node, delete node, create new single-linked list
						// node with saved data and add new node to the list in the given place
						// (see variant item (c))
		
	private static DLNode remove(DLNode dlHead, DLNode current) {
			if (current.prev != null)
				current.prev.next = current.next;
			else {
				dlHead = dlHead.next;
			}
		
			if(current.next != null)
				current.next.prev = current.prev;
			return dlHead;
	}
}