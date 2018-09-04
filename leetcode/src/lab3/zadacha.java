package lab3;

import java.util.Scanner;

public class zadacha {
	public static void main(String[] argc) {
		Scanner in = new Scanner(System.in);
        SLNode h = new SLNode();
		SLNode hcopy = h.next;
		for (int i = 0; i <= 9; i++) {
			h.next = add_SLNode(in.nextInt());
			h = h.next;
		}
		in.close();

		System.out.println('=');
		deleteDuplicates(hcopy);
	}
	
	public static SLNode deleteDuplicates(SLNode head) {

		System.out.println('=');
        if (head == null || head.next == null)
            return head;

		System.out.println('=');
        SLNode head_copy = head;
        SLNode head_copy2 = head;
        //SLNode delite = head;
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        head = head_copy2;

		System.out.println('=');
        boolean[] slot = new boolean[i + 1];
        slot[i] = false;
        i = 0;

		System.out.println('=');
        while(head != null) {
            while (head_copy != null) {
                if (head.data == head_copy.data && head != head_copy) {
                    slot[i] = true;
                    break;
                }
                head_copy = head_copy.next;
            }
            i++;
            head = head.next;
            head_copy = head_copy2;
        }

		System.out.println('=');
        //
        for(int j = 0; j < 10; j++) {
        	if (slot[j])
        		System.out.print('+');
        	else
        		System.out.print('-');
        }
        //
        head = head_copy2;
        i = 0;
        while (head != null) {
            if (!slot[i + 1])
                i++;
            else {
                while (slot[i + 1]) {
                    i++;
                    if (head.next == null){
                        head = null;
                        break;
                    }
                    head.next = head.next.next;
                }
            }
            if (head != null)
                head = head.next;
        }
        if(slot[0])
            return head_copy2.next;
        return head_copy2;     
    }
	
	public static SLNode add_SLNode(int a) {
		SLNode b = new SLNode();
		b.data = a;
		b.next = null;
		return b;
	}
}
