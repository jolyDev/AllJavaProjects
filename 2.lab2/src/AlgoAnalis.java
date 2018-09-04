import java.io.*;
import java.nio.file.Paths;

public class AlgoAnalis {
	
	//private static String fileName = "1 000.txt"; // 1 millisecond
	//private static String fileName = "10 000.txt"; // 4 millisecond
	//private static String fileName = "100 000.txt"; // 18 millisecond
	//private static String fileName = "250 000.txt"; // 44 millisecond
	//private static String fileName = "500 000.txt"; // 96 millisecond
	private static String fileName = "750 000.txt"; // 156 millisecond
	// require more testing
	/*
	private static String fileName = "1 000 000.txt"; // 235 millisecond
	private static String fileName = "10 000 000.txt"; // 6561 millisecond
	*/
	/*
	 * check is working writing 6651 6629 6679
	 */
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "src\\array to test sorting";
	
	private static String currenDirToWrite = System.getProperty("user.dir")
			+ File.separatorChar + "src\\result massive";

	
	public static void main(String[] args) {

		int[] array = fill_array();
        
		long before_sort = 0;
		long after_sort = 0;

		//nanoTime
		//currentTimeMillis
		before_sort = System.currentTimeMillis();
		Shell_sort(array);
		after_sort = System.currentTimeMillis();

		System.out.println(before_sort);
		System.out.println(before_sort);
		System.out.println(after_sort);
		System.out.println(after_sort - before_sort + " millisecond");
		
		write_to_file(array);
	}
	
	public static void Shell_sort(int[] ar) {
		int h = 1;
		while (h <= ar.length / 3) {
			h = h * 3 + 1;
		}
		while (h > 0) {
			for (int i = h; i < ar.length; i++) {
				int temp = ar[i];
				int j = i;

				while (j > h - 1 && ar[j - h] >= temp) {
					ar[j] = ar[j - h];
					j -= h;
				}
				ar[j] = temp;
			}
			h = h / 3;
		}
	}
	
	public static int get_size(String title) {
		int size = 0;
		for (int i = 0; i < fileName.length(); i++) {
			if (Character.isDigit(fileName.charAt(i)))
				size = size * 10 + fileName.charAt(i) - 48;
		}
		return size;
	}
	
	public static int[] fill_array() {
		
		String path = Paths.get(currenDir, fileName).toString();
		int size = get_size(fileName);
		int[] array = new int[size];
		try(FileReader reader = new FileReader(path))
        {
           // reading by character
            int c = 0;
            int i = 0;
            int sign = 1;
            while((c = reader.read()) != -1){            	
            	if ((char)c == ' ' || c == '-') {
                    if (c == '-') {
                    	sign = -1;
                    }
                   	else {
                   		sign = 1;
                		i++;
                   	}
            	}	else 
            		array[i] = array[i] * 10 + sign * (c - 48);
            } 
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
		return array;
	}
	
	public static void write_to_file(int[] array) {
		
		String path = Paths.get(currenDirToWrite, fileName).toString();
		
		try(FileWriter writer = new FileWriter(path, false))
        {
    		for (int i = 0; i < array.length; i++) {
    			writer.write(Integer.toString(array[i]) + " ");
    		}
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
	}
}
