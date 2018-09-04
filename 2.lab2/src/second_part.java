import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class second_part {
		//private static String fileName = "10.txt"; // 1 millisecond
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
	private static String fileName[] = {
			"10.txt",
			"100.txt",
			"1000.txt",
			"10000.txt",
			"100000.txt",
			"250000.txt",
			"500000.txt",
			"750000.txt",
			"1000000.txt",
			"1500000.txt",
			"2000000.txt",
			"2500000.txt",
			"5000000.txt", 
			"7500000.txt",
			"10000000.txt",
			"25000000.txt",
	};
		private static short MAX_WORD_LENGTH = 8;
		private static short check_times = 1;
		public static void main(String[] args) {
			int radix_time[] = new int[check_times];
			int insertion_time[] = new int[check_times];
			int insertion_sum = 0;
			int radix_sum = 0;
			float average = 0.0f; // ask why exp float average = 0.0 is not correct
			// every size need checked few(10) times
			for (int i = 8; i < fileName.length; i++) {
				System.out.print("Sorting " + fileName[i] + "\n");
				// sort every file
				for (int j = 0 ; j < check_times; j++) {
				
					String currenDir = System.getProperty("user.dir")
							+ File.separatorChar + "src\\array to test sorting String//" + fileName[i];
				
					String ToWriteInsertion = System.getProperty("user.dir")
							+ File.separatorChar + "src\\result massive second part insertion//" + fileName[i];
				
					String ToWriteRadix = System.getProperty("user.dir")
							+ File.separatorChar + "src\\result massive second part radix//" + fileName[i];

					String[] array = fill_array(currenDir);
					long before_sort_radix = 0;
					long after_sort_radix = 0;
			
					long before_sort_insertion = 0;
					long after_sort_insertion = 0;

					before_sort_radix = System.currentTimeMillis();
					radix_sort(array);
					after_sort_radix = System.currentTimeMillis();

					write_to_file(array, ToWriteRadix);
					
					radix_time[j] = (int)(after_sort_radix - before_sort_radix);
					/*
					System.out.print("Radix:");
					System.out.print(radix_time[j]);
					System.out.print(" ms ");
					*/
					
					array = fill_array(currenDir);
			
					before_sort_insertion = System.currentTimeMillis();
					insertion_sort(array);
					after_sort_insertion = System.currentTimeMillis();
			
					write_to_file(array, ToWriteInsertion);
					insertion_time[j] = (int)(after_sort_insertion - before_sort_insertion);
					/*
					System.out.print(" Insertion:");
					System.out.print(insertion_time[j]);
					System.out.print(" ms ||");
					*/
					refresh_unsorted_array(currenDir, get_size(fileName[i]));
				}
				
				for (int j = 0; j < check_times; j++) {
					insertion_sum += insertion_time[j];
					radix_sum += radix_time[j];
				}
				System.out.print("Radix: "); 
				System.out.print((radix_sum * 1.0) / check_times);
				System.out.print(" | Insertion: "); 
				System.out.print((insertion_sum * 1.00) / check_times);
				System.out.print("\n\n"); 
			}
		}
		
		private static void refresh_unsorted_array(String path, int size) {
			Random r = new Random();
			int space = 0;
			// write into every .txt file\
			try(FileWriter writer = new FileWriter(path, false)) {
				// Write that amount of words that equals name of file
				for (int k = 0; k < size; k++) {
					space = r.nextInt(MAX_WORD_LENGTH) + 1;
					// write word by each letter
		    		for (int j = 0; j < space; j++) {
		    			writer.write(r.nextInt('z' + 1 - 'a') + 'a');
		    		}
	    			writer.write(" ");
				}
		        writer.flush();
		    } catch(IOException ex){
		    	System.out.println("LOL" + ex.getMessage());
		    }
		}
		public static void radix_sort(String[] array) {
			char[] elements = new char[array.length]; 
			
			for (int j = 1; j <= MAX_WORD_LENGTH; j++) {
				for (int i = 0; i < array.length; i++) {
					int char_pos = array[i].length() - j;
					if (char_pos >= 0)
						elements[i] = array[i].charAt(char_pos);
					else 
						elements[i] = ' ';
				}
				counting_sort_help(array, elements);
			}
		}
		

		public static void counting_sort_help(String[] array, char[] elements) {
	        int n = array.length;
	        
	        // The output character array that will have sorted arr
	        String output[] = new String[n];
	 
	        // Create a count array to store count of inidividul
	        // characters and initialize count array as 0
	        int count[] = new int[256];
	        for (int i = 0; i < 256; ++i)
	            count[i] = 0;
	 
	        // store count of each character
	        for (int i=0; i<n; ++i)
	            ++count[elements[i]];
	 
	        // Change count[i] so that count[i] now contains actual
	        // position of this character in output array
	        for (int i = 1; i <= 255; ++i)
	            count[i] += count[i-1];
	 
	        // Build the output character array
	        for (int i = n - 1; i >= 0; --i)
	        {
	            output[count[elements[i]]-1] = array[i];
	            --count[elements[i]];
	        }
	 
	        // Copy the output array to arr, so that arr now
	        // contains sorted characters
	        for (int i = 0; i < n; ++i)
	        	array[i] = output[i];
		}
		
		public static void insertion_sort(String[] ar) {
			if (ar == null)
					return ;
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
			
			for (; i < s1.length() && i < s2.length()
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
			
		public static String[] fill_array (String currenDir) {
		     String[] text = null;
		        try {
		            String str = null;
		            BufferedReader br = new BufferedReader(new FileReader(currenDir));
		            while ((str = br.readLine()) != null) {
		            	text = str.split(" ");
		            }
		            br.close();
		        } catch (IOException exc) {
		            System.out.println("IO error!" + exc);
		        }
		        return text;
		}
		
		public static int get_size(String filename) {
			int size = 0;
			for (int i = 0; i < filename.length(); i++) {
				if (Character.isDigit(filename.charAt(i)))
					size = size * 10 + filename.charAt(i) - 48;
			}
			return size;
		}
		
	public static void write_to_file(String[] array, String filename) {
			if (array == null || filename == null) {
				return ;
			}
			
			try(FileWriter writer = new FileWriter(filename, false))
	        {
	    		for (int i = 0; i < array.length - 1; i++) {
	    			writer.write(array[i] + " ");
	    			if (array[i].charAt(0) != array[i + 1].charAt(0)) {
		    			writer.write("\r\n");
	    			}
	    		}
	    		writer.write(array[array.length - 1] + "\r\n");
	            writer.flush();
	        }
	        catch(IOException ex){
	             System.out.println("Ne" + ex.getMessage());
	        } 
	}
}
