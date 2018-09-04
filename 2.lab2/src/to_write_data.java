import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class to_write_data {
	
	private static String fileName = "1 000.txt"; // 1 millisecond
	//private static String fileName = "10 000.txt"; // 1 millisecond
	//private static String fileName = "100 000.txt"; // 1 millisecond
	//private static String fileName = "250 000.txt"; // 1 millisecond
	//private static String fileName = "500 000.txt"; // 1 millisecond
	//private static String fileName = "750 000.txt"; // 1 millisecond
	//private static String fileName = "1 000 000.txt"; // 1 millisecond
	//private static String fileName = "10 000 000.txt"; // 1 millisecond
	
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "src\\array to test sorting";
	
	public static void main (String[] args) {
		

		String path = Paths.get(currenDir, fileName).toString();
		
        try(FileWriter writer = new FileWriter(path, false))
        {
           // запись всей строки
    		
    		Random r = new Random();
    		int size = get_size(fileName);
    		int below_bound = -1000;
    		int upper_bound = 15000;
    		int[] array = new int[size];
    		for (int i = 0; i < size; i++) {
    			array[i] = r.nextInt(upper_bound + 1 - below_bound) + below_bound;
    			writer.write(Integer.toString(array[i]) + " ");
    		}

            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println("LOL" + ex.getMessage());
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
}
