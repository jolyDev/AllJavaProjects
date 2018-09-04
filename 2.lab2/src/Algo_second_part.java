import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

public class Algo_second_part {
		private static String fileName = "1000.txt"; // 1 millisecond
		//private static String fileName = "10 000.txt"; // 4 millisecond
		//private static String fileName = "100 000.txt"; // 18 millisecond
		//private static String fileName = "250 000.txt"; // 44 millisecond
		//private static String fileName = "500 000.txt"; // 96 millisecond
		//private static String fileName = "750 000.txt"; // 156 millisecond
		// require more testing
		/*
		private static String fileName = "1 000 000.txt"; // 235 millisecond
		private static String fileName = "10 000 000.txt"; // 6561 millisecond
		*/
		/*
		 * check is working writing 6651 6629 6679
		 */
		//private static String currenDir = System.getProperty("user.dir")
				//+ File.separatorChar + "src\\array to test sorting String";
		
		private static String currenDirToWrite = System.getProperty("user.dir")
				+ File.separatorChar + "src";
		public static void main(String[] args) {

			String[] array = fill_array();
	        
			long before_sort_radix = 0;
			long after_sort_radix = 0;
			
			long before_sort_insertion = 0;
			long after_sort_insertion = 0;

			//nanoTime
			//currentTimeMillis
			before_sort_radix = System.currentTimeMillis();
			radix_sort(array);
			after_sort_radix = System.currentTimeMillis();
			System.out.println("hjh");
			System.out.println(before_sort_radix);
			System.out.println(after_sort_radix);
			System.out.println(after_sort_radix - before_sort_radix + " millisecond\n");

			
			
			write_to_file(array, "result massive second part radix", fileName);
			
			array = fill_array();
			
			before_sort_insertion = System.currentTimeMillis();
			insertion_sort(array);
			after_sort_insertion = System.currentTimeMillis();
			
			System.out.println(before_sort_insertion);
			System.out.println(after_sort_insertion);
			System.out.println(after_sort_insertion - before_sort_insertion + "Dich millisecond");
			
			write_to_file(array, "result massive second part insertion", fileName);
		}
		
		public static int get_size(String title) {
			int size = 0;
			for (int i = 0; i < fileName.length(); i++) {
				if (Character.isDigit(fileName.charAt(i)))
					size = size * 10 + fileName.charAt(i) - 48;
			}
			return size;
		}
		
		public static void radix_sort(String[] array) {
			
		}
		
		public static void insertion_sort(String[] ar) {
			int N = ar.length;
			for (int i = 1; i < N; i++) { // i points to the start of the sorted part
				int j = i - 1; // j points to the end of the unsorted part
				String key = ar[i];
				// insert key in the sorted part of the array
				while (j >= 0 && MyStrCompare(ar[j], key) == 1) {
					ar[j + 1] = ar[j];
					j--;
				}
				ar[j + 1] = key;
			}
		}
		
		public static int MyStrCompare(String s1, String s2) {
			if (s1 == null || s2 == null)
				return 0;
			if (s1.equals(s2)) {
				return 0;
			}
			int i = 0;
			
			
			
			
			for (; i < s1.length() && i < s1.length()
					&& s1.charAt(i) == s2.charAt(i); i++);
			if (i == s1.length()) {
				return 1;
			}
			
			
			
			if (i == s2.length()) {
				return -1;
			}
			if (s1.charAt(i) > s2.charAt(i)) {
				return 1;
			}
			return -1;
		}
		
		
		public static String[] fill_array() {
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))){
	            String line;
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	        } catch (IOException e) {
	            // log error
	        }
			return null;
		}
		
	public static void write_to_file(String[] array, String path_to_write, String filename) {
			
			String path = Paths.get(currenDirToWrite, path_to_write).toString();
			
			try(FileWriter writer = new FileWriter(path + "10.txt", false))
	        {
	    		for (int i = 0; i < array.length; i++) {
	    			writer.write(array[i]);
	    			System.out.println(array[i]);
	    		}
	            writer.flush();
	        }
	        catch(IOException ex){
	             System.out.println(ex.getMessage());
	        } 
		}
}
