import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;

public class to_delete {
	
private static String fileName = "1 000.txt"; // 1 millisecond
//private static String fileName = "10 000.txt"; // 1 millisecond
//private static String fileName = "100 000.txt"; // 1 millisecond
//private static String fileName = "250 000.txt"; // 1 millisecond
//private static String fileName = "500 000.txt"; // 1 millisecond
//private static String fileName = "750 000.txt"; // 1 millisecond
//private static String fileName = "1 000 000.txt"; // 1 millisecond
//private static String fileName = "10 000 000.txt"; // 1 millisecond

private static String currenDir = System.getProperty("user.dir")
+ File.separatorChar + "src\\array to test sorting\\";


	public static void main(String argc[], int argv) {
	String path = Paths.get(currenDir, fileName).toString();
	
	try {
        FileWriter fstream1 = new FileWriter(path);// конструктор с одним параметром - для перезаписи
        BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
        out1.write(""); // очищаем, перезаписав поверх пустую строку
         out1.close(); // закрываем
         System.err.println("Suka");
         } catch (Exception e) 
            {System.err.println("Error in file cleaning: " + e.getMessage());
         }
	}
}
