package lab3;
import java.util.Scanner;
import lab3.SLNode;

public class exam2 {
	public static void main(String[] argc) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter the amount of the lisy");
		int amount = in.nextInt();

		System.out.println("Fill values for list");
		SLNode h = new SLNode();
		SLNode dummy = h;
		for (int i = 0; i < amount; i++) {
			h.next = add_SLNode(in.nextInt());
			h = h.next;
		}
		h = dummy.next;
		
		int counter = 0;
		
		while (h != null) {
			h = h.next;
			counter++;
		}
		
		if (counter == 0 ) {
			System.out.println("Mistake");
		} else {
			
		if (counter == 1) {
			//return null;
			
		} else {
		h = dummy.next;
		
		//System.out.println(counter + "\n");
		
		if (counter % 2 != 0) {
			counter = counter / 2 + 1;
			for (int i = 1; i < counter - 1; i++) {
				h = h.next;
			}
			h.next = h.next.next;
		}
		
		h = dummy.next;
		
		while(h != null) {
			System.out.print(h.data + "=>");
			h = h.next;
		}
		
		in.close();
		
			}
		}
	}
	
	public static SLNode add_SLNode(int a) {
		SLNode b = new SLNode();
		b.data = a;
		b.next = null;
		return b;
	}
}