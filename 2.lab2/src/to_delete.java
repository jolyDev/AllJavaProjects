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
        FileWriter fstream1 = new FileWriter(path);// ����������� � ����� ���������� - ��� ����������
        BufferedWriter out1 = new BufferedWriter(fstream1); //  ������ ���������������� �����
        out1.write(""); // �������, ����������� ������ ������ ������
         out1.close(); // ���������
         System.err.println("Suka");
         } catch (Exception e) 
            {System.err.println("Error in file cleaning: " + e.getMessage());
         }
	}
}
