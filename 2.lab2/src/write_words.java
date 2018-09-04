import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Random;

public class write_words {
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
	private static String currenDir = System.getProperty("user.dir")
			+ File.separatorChar + "src\\array to test sorting String\\";
	public static void main(String[] args) {
		Random r = new Random();
		int space = 0;
		// write into every .txt file
		for (int i = 0; i < fileName.length; i++) {
			int size = get_size(fileName[i]);
			String path = Paths.get(currenDir, fileName[i]).toString();
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
	        }
	        catch(IOException ex){
	            System.out.println("LOL" + ex.getMessage());
	        } 
		}
		System.out.print("Data shoud be writed");
	}
	
	public static int get_size(String filename) {
		int size = 0;
		for (int i = 0; i < filename.length(); i++) {
			if (Character.isDigit(filename.charAt(i)))
				size = size * 10 + filename.charAt(i) - 48;
		}
		return size;
	}
}
