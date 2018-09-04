package Turanga_Lila;
public class Convert_to_any_base {
	public static void main (String[] argc) {
		System.out.println(convertToBaseX(279, 8));
	}
    public static String convertToBaseX(int num, int x) {
    	if (x == 1) {
    		for (int i = 0; i < num; i++) {
    			if (i % 5 == 0)
    				System.out.print(" I");
    			else
    				System.out.print("I");
    		}
    	}
        if (num != 0) {
            String tetra = "0123456789ABCDEF";
            String to_return = "";
            boolean flag = false;
            
            if (num < 0) {
                num *=-1;
                flag = true;
            }
            int ostacha = 0;
            while (true) {
                ostacha = num % x;
                num /= x;
                if(num == 0 && ostacha == 0)
                    break;
                to_return = tetra.charAt(ostacha) + to_return;
            }
            if (flag == true)
                to_return = '-' + to_return;
            return to_return;
        } else return "0";
    }
}
