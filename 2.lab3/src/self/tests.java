package self;

import java.util.Random;

public class tests {

	public static void main(String[] args) {
		// list_test();
		// array_test();
		task3();
	}

	public static void task3() {
		ArrayDeque dequeue = new ArrayDeque();
		SinglyLinkedList list = new SinglyLinkedList();
		Random r = new Random();
		int line = 12;
		System.out.print("tail -> ");
		for (int i = 0; i < line; i++) {
			dequeue.addFirst(r.nextInt() % 10);
			// dequeue.addFirst(i);
			// System.out.print(dequeue.getFirst() + "-> ");
			// dequeue.addFirst(-i);
			System.out.print(dequeue.getFirst() + "-> ");
		}
		System.out.println(" <- head");
		dequeue.print();
		for (int i = 0; i < line; i++) {
			if (dequeue.getFirst() > dequeue.getLast())
				list.add(convertToBaseX(dequeue.removeFirst(), 2));
			else
				list.add(convertToBaseX(dequeue.removeLast(), 2));
		}
		list.print();
	}

	// here a few situation that can ruin the data &
	// correct working process, this is why i prefer list realization
	public static void array_test() {
		ArrayDeque a = new ArrayDeque();
		a.print();
		for (int i = 1; i < 38; i++) {
			a.addLast(-i);
			a.addFirst(i);
			a.print();
			System.out.println("=====");
		}
		a.print();
	}

	public static void list_test() {
		SinglyLinkedList head = new SinglyLinkedList();
		for (int i = 0; i < 25; i++) {
			head.add(convertToBaseX(i, 2));
		}
		System.out.println("====");
		System.out.println("=> " + head.remove(6));
		head.add("1111111111111111");
		head.set(7, "1111111111111111");
		head.set(0, "111000111000111");
		head.print();
		System.out.println("=====");
		System.out.println("=> " + head.remove("101"));
		head.print();
		System.out.println("");
		head.print();
	}

	public static String convertToBaseX(int num, int x) {
		if (num != 0) {

			String tetra = "0123456789ABCDEF";
			String to_return = "";
			boolean flag = false;

			if (num < 0) {
				num *= -1;
				flag = true;
			}
			int ostacha = 0;
			while (true) {
				ostacha = num % x;
				num /= x;
				if (num == 0 && ostacha == 0)
					break;
				to_return = tetra.charAt(ostacha) + to_return;
			}
			// System.out.println(to_return + "|||" + print_digit(to_return));
			if (flag == true)
				to_return = '-' + to_return;
			return to_return;
		} else
			return "0";
	}

	public static int print_digit(String h) {
		int y = 0;
		for (int i = 0; i < h.length(); i++) {
			y += (h.charAt(i) - 48) * Math.pow(2, h.length() - 1 - i);
		}
		return y;
	}
}
